package com.blaquesystems.backend.service;

import com.blaquesystems.backend.exception.SmsSendingException;
import com.blaquesystems.backend.models.Channel;
import com.blaquesystems.backend.models.EChannel;
import com.blaquesystems.backend.models.Notification;
import com.blaquesystems.backend.models.User;
import com.blaquesystems.backend.repository.ChannelRepository;
import com.blaquesystems.backend.repository.NotificationRepository;
import com.blaquesystems.backend.repository.UserRepository;
import com.mashape.unirest.http.HttpResponse;
import com.mashape.unirest.http.JsonNode;
import com.mashape.unirest.http.Unirest;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Service;

import java.util.Date;

@Service
public class EmailService {

    @Autowired
    NotificationRepository notificationRepository;

    @Autowired
    UserRepository userRepository;

    @Autowired
    ChannelRepository channelRepository;

    @Value("${mailtrap.url}")
    private String url;

    @Value("${mailtrap.apiToken1}")
    private String api_token1;

    @Value("${mailtrap.apiToken2}")
    private String api_token2;

    @Value("${mailtrap.jwtToken}")
    private String jwt_token;

    @Value("${mailtrap.senderEmail}")
    private String sender_email;

    @Value("${mailtrap.senderName}")
    private String sender_name;

    public void sendEmail(String email, String subject, String message) throws SmsSendingException {
        try {
            User user = userRepository.findByEmail(email).orElse(null);
            Channel channel;

            if (channelRepository.existsByName(EChannel.CHANNEL_EMAIL)){
                channel = channelRepository.findByName(EChannel.CHANNEL_EMAIL).orElse(null);
            }
            else {
                Date now = new Date();
                channel = new Channel(EChannel.CHANNEL_EMAIL, "Send email notifications", now, now);
                channelRepository.save(channel);
            }

            String requestBody = "{\"from\":{\"email\":\"" + sender_email + "\",\"name\":\"" + sender_name + "\"},\"to\":[{\"email\":\"" + email + "\"}],\"subject\":\"" + subject + "\",\"text\":\"" + message + "\",\"category\":\"Notifications\"}";

            Unirest.setTimeouts(0, 0);
            HttpResponse<JsonNode> response = Unirest.post(url)
                    .header("Authorization", "Bearer " + api_token1)
                    .header("Content-Type", "application/json")
                    .body(requestBody)
                    .asJson();

            int statusCode = response.getStatus();
            if (statusCode >= 200 && statusCode < 300) {
                saveNotification(user, message, channel);
            } else {
                throw new SmsSendingException("Failed to send Email. HTTP status code: " + statusCode);
            }
        } catch (Exception e) {
            throw new SmsSendingException("Failed to send Email.", e);
        }
    }

    private void saveNotification(User user, String message, Channel channel) {
        Date now = new Date();
        Notification notification = new Notification(user, message, channel, now, now);
        notificationRepository.save(notification);
    }
}

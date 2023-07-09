package com.blaquesystems.backend;

import com.blaquesystems.backend.exception.SmsSendingException;
import com.blaquesystems.backend.models.*;
import com.blaquesystems.backend.repository.ChannelRepository;
import com.blaquesystems.backend.repository.NotificationRepository;
import com.blaquesystems.backend.repository.UserRepository;
import com.blaquesystems.backend.service.SmsService;
import org.junit.jupiter.api.*;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.io.UnsupportedEncodingException;
import java.util.Date;
import java.util.HashSet;

@SpringBootTest
public class SmsServiceTest {

    @Autowired
    private SmsService smsService;

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private ChannelRepository channelRepository;

    @Mock
    private NotificationRepository notificationRepository;
    private User user;
    private Channel channel;



    @BeforeEach
    public void beforeEach() {
        user = new User("test-user", "firstName", "lastName", "12345678", "test@gmail.com", "test#245", true, new HashSet<Role>());
        user.setCreatedAt(new Date());
        user.setUpdatedAt(new Date());
        channel = new Channel(EChannel.CHANNEL_SMS, "send sms messages to users", new Date(), new Date());

        userRepository.save(user);
        channelRepository.save(channel);
    }

    @AfterEach
    public void afterEach() {
        notificationRepository.deleteByChannel(channel);
        channelRepository.delete(channel);
        notificationRepository.deleteByUser(user);
        userRepository.delete(user);
    }


    @Test
    public void testSendSms() throws SmsSendingException, UnsupportedEncodingException {
        // Mock the necessary dependencies and set expectations
        String message = "Test SMS";

        Mockito.when(notificationRepository.save(Mockito.any(Notification.class)))
                .thenAnswer(invocation -> invocation.getArgument(0)); // Save the notification and return it as the result


        // Call the sendSms method with test data
        smsService.sendSms(message, 254720106420L, Mockito.any(User.class));

        // Verify that the saveNotification method was called with the correct parameters
        Mockito.verify(notificationRepository, Mockito.times(1))
                .save(Mockito.eq(new Notification(Mockito.any(User.class), message, Mockito.any(Channel.class), Mockito.any(Date.class), Mockito.any(Date.class))));
    }
}
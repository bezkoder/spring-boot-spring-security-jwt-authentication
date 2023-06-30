package com.blaquesystems.backend;

import com.blaquesystems.backend.models.Notification;
import com.blaquesystems.backend.repository.NotificationRepository;
import com.blaquesystems.backend.security.services.SmsService;
import org.junit.jupiter.api.Test;
import org.mockito.Mock;
import org.mockito.Mockito;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

@SpringBootTest
public class SmsServiceTest {

    @Autowired
    private SmsService smsService;

    @Mock
    private NotificationRepository notificationRepository;

    @Test
    public void testSendSms() {
        // Mock the necessary dependencies and set expectations
        String message = "Test SMS";
        int userId = 1;
        int channelId = 2;

        Mockito.when(notificationRepository.save(Mockito.any(Notification.class)))
                .thenAnswer(invocation -> invocation.getArgument(0)); // Save the notification and return it as the result

        // Call the sendSms method with test data
        smsService.sendSms(message, userId, channelId);

        // Verify that the saveNotification method was called with the correct parameters
        Mockito.verify(notificationRepository, Mockito.times(1))
                .save(Mockito.eq(new Notification(userId, message, channelId, Mockito.any(LocalDateTime.class), Mockito.any(LocalDateTime.class))));
    }
}

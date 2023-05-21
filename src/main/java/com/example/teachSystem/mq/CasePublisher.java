package com.example.teachSystem.mq;

import com.example.teachSystem.Entity.NewCaseNotification;
import org.springframework.amqp.core.AmqpTemplate;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;

@Component
public class CasePublisher {
    private static final String EXCHANGE_NAME = "new_case_exchange";

    @Autowired
    private AmqpTemplate rabbitTemplate;

    public void publishNewCaseNotification(String caseTitle) {
        NewCaseNotification notification = new NewCaseNotification(caseTitle);
        rabbitTemplate.convertAndSend(EXCHANGE_NAME, "", notification);
    }
}

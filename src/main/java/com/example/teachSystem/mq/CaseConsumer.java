package com.example.teachSystem.mq;

import com.example.teachSystem.Entity.NewCaseNotification;
import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class CaseConsumer {
    @RabbitListener(queues = "new_case_exchange")
    public void receiveNewCaseNotification(NewCaseNotification notification) {
        // 处理新案例通知
        System.out.println("收到新案例通知: " + notification.getTitle());
        // 执行相应的操作，例如发送通知或更新UI

    }
}

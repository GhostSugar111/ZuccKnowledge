package com.example.teachSystem.mq;

import org.springframework.amqp.rabbit.annotation.RabbitListener;
import org.springframework.stereotype.Component;

@Component
public class StarConsumer {
    @RabbitListener(queues = "task_queue")
    public void receiveTask(String task) {
        System.out.println(" [x] Received '" + task + "'");
        // 处理任务
        processTask(task);
    }

    private void processTask(String task) {
        // 执行相应的操作，例如将点赞或阅读记录入库
        System.out.println("Processing task: " + task);
    }
}

package com.example.kafka.consumer.Service;

import com.example.kafka.consumer.domain.dto.TestMessage;
import lombok.extern.slf4j.Slf4j;
import org.springframework.kafka.annotation.KafkaListener;
import org.springframework.messaging.handler.annotation.Payload;
import org.springframework.stereotype.Service;

/**
 * KafkaConsumerService
 * Producer에서 온 메시지를 받아 비즈니스 로직을 수행하는 Service
 *
 * @author devhoi
 */
@Service
@Slf4j
public class KafkaConsumerService {

    /**
     * consume
     * consumer Test Method
     * KafkaListener를 통해 메시지 분기 처리
     *
     * @author devhoi
     * @param message 메시지
     */
    @KafkaListener(topics = "test-topic", groupId = "group-id-test")
    public void consume(@Payload TestMessage<String> message) {
        log.debug("test id : {}", message.id());
        log.debug("test message : {}", message.body());

        // Do something...
    }
}

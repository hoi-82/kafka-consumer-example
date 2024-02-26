package com.example.kafka.consumer.config;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.context.annotation.Bean;
import org.springframework.context.annotation.Configuration;
import org.springframework.kafka.annotation.EnableKafka;
import org.springframework.kafka.config.TopicBuilder;
import org.springframework.kafka.core.KafkaAdmin;

/**
 * Kafka Config
 *
 * Kafka 설정을 위한 Configuration Class
 *
 * @author devhoi
 */
@EnableKafka
@Configuration
public class KafkaConfig {

    /**
     * createTestTopic
     *
     * Kafka Test Topic 생성
     * - Topic을 이미 생성한 경우는 사용하지 않아도 상관없음.
     * - Partitions는 증축만 가능하니 처음 생성 시 적절량만 생성하고 추후 증가해나가야 한다.
     *
     * @author devhoi
     */
    @Bean
    public NewTopic createTestTopic() {
        return TopicBuilder.name("test-topic")
                .partitions(3) // 2.6 버전부터 생략 가능 (브로커 버전 2.4이상)
                .replicas(1) // 2.6 버전부터 생략 가능 (브로커 버전 2.4이상)
                .build();
    }

    /**
     * createTestTopics
     *
     * Kafka Topic 다수 생성
     *
     * @author devhoi
     */
    @Bean
    public KafkaAdmin.NewTopics createTestTopics() {
        return new KafkaAdmin.NewTopics(
                TopicBuilder.name("test-topic-2").build()
                , TopicBuilder.name("test-topic-3").build()
        );
    }
}

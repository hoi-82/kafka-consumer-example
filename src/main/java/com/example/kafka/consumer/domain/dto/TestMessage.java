package com.example.kafka.consumer.domain.dto;

public record TestMessage<T>(String id, String body) {
}

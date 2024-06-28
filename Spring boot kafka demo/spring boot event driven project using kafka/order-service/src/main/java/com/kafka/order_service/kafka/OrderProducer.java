package com.kafka.order_service.kafka;

import org.apache.kafka.clients.admin.NewTopic;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

import com.kafka.base_domains_service.dto.OrderEvent;


@Service
public class OrderProducer {
    private NewTopic topic;

    private KafkaTemplate<String, OrderEvent>
}

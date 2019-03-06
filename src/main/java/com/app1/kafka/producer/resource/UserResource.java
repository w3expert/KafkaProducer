package com.app1.kafka.producer.resource;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.app1.kafka.producer.model.User;

@RestController
@RequestMapping("kafka")
public class UserResource {

	@Autowired
	@Qualifier("kafkaTemplate1")
    private KafkaTemplate<String, String> kafkaTemplate1;
	
    @Autowired
    @Qualifier("kafkaTemplate2")
    private KafkaTemplate<String, User> kafkaTemplate2;

    private static final String TOPIC_1 = "Kafka_Example";
    private static final String TOPIC_2 = "Kafka_Example2";

    @GetMapping("/publish1/{name}")
    public String postStr(@PathVariable("name") final String name) {

    	kafkaTemplate1.send(TOPIC_1, name);

        return "Published successfully";
    }
    
    @GetMapping("/publish2/{name}")
    public String postUser(@PathVariable("name") final String name) {

        kafkaTemplate2.send(TOPIC_2, new User(name, "Technology", 12000L));

        return "Published successfully";
    }
}

package com.example.demo;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.test.context.junit4.SpringRunner;

import com.app1.kafka.producer.KafkaProducerApp;

@RunWith(SpringRunner.class)
@SpringBootTest(classes = KafkaProducerApp.class)
public class KafkaProducerApplicationTests {

	@Test
	public void contextLoads() {
	}

}

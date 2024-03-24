package com.alves.microsservicekafka;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import org.springframework.kafka.annotation.EnableKafka;

@EnableKafka
@SpringBootApplication
public class MicrosserviceKafkaApplication {

	public static void main(String[] args) {
		SpringApplication.run(MicrosserviceKafkaApplication.class, args);
	}

}

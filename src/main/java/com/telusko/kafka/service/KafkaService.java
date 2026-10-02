package com.telusko.kafka.service;

import com.telusko.kafka.model.Course;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.kafka.core.KafkaTemplate;
import org.springframework.stereotype.Service;

@Service
public class KafkaService {

    @Autowired
    private KafkaTemplate<String, Course> kafkaTemplate;


    public String sendMessage(Course course){

        String key = String.valueOf(course.getCourseId());

        kafkaTemplate.send("telusko",key,course);

        return  "Course_message_sent_to_kafka_server";
    }


}

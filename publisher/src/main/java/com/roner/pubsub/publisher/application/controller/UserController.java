package com.roner.pubsub.publisher.application.controller;

import com.roner.pubsub.publisher.User;
import com.roner.pubsub.publisher.application.messaging.Producer;
import com.roner.pubsub.publisher.application.request.UserRequest;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/users")
public class UserController {

    private final Producer producer;

    public UserController(Producer producer) {
        this.producer = producer;
    }

    @PostMapping(value = "/publish")
    public void sendMessageToKafkaTopic(@RequestBody UserRequest userRequest) {
        this.producer.sendMessage(new User(userRequest.getName(), userRequest.getAge()));
    }
}
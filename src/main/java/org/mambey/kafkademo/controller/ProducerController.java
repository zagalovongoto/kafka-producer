package org.mambey.kafkademo.controller;

import org.mambey.kafkademo.model.Message;
import org.mambey.kafkademo.service.ProducerService;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping(value = "/kafka")
public class ProducerController {
    private final ProducerService producerService;
    public ProducerController(ProducerService producerService){
        this.producerService = producerService;
    }

    @PostMapping("/send")
    public String send(@RequestBody Message message) {
        producerService.sendMessage(message.value());

        return message.value();
    }
}

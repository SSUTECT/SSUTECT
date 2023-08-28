package com.ssu.ssutect.message.controller;

import com.ssu.ssutect.message.service.MessageService;
import lombok.RequiredArgsConstructor;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequiredArgsConstructor
public class MessageController {

    private final MessageService messageService;

    @PostMapping("/result/spam")
    public ResponseEntity compareMessages(@RequestBody String userMessage) {
        Boolean pac = messageService.compareMessages(userMessage);
        return ResponseEntity.ok(pac);
    }

}

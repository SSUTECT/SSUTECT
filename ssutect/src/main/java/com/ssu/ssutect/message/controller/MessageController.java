package com.ssu.ssutect.message.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestParam;

import com.ssu.ssutect.message.service.MessageService;

@Controller
public class MessageController {

    @Autowired
    private MessageService messageService;
    
    @PostMapping("/report")
    public String processMessageReport(@RequestParam String content){
        messageService.processMessageReport(content);
        return "Data processed successfully";
    }
}

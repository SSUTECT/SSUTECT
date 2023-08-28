package com.ssu.ssutect.message.service;

import com.ssu.ssutect.message.repository.MessageRepository;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
@RequiredArgsConstructor
public class MessageService {

    private final MessageRepository messageRepository;

    public List<String> getAllMessage() {
        List<String> messages = messageRepository.getAllMessage();
        return messages;
    }

}

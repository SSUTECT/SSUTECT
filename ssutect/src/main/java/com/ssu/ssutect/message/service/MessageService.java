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

    public Boolean compareMessages(String userMessage) {
        List<String> allMessage = getAllMessage();
        for (String m : allMessage) {
            // ai를 이용한 비교 코드 작성
            Boolean pac = compareMessage(m, userMessage);
            if(pac == true){
                return true; // 스팸 메시지이면 true 반환
            }
        }
        return false; // 스팸 메시지가 아니면 false 리턴
    }

    public Boolean compareMessage(String m1, String m2) {
        if(m1.equals(m2))
            return true;

        return false;
    }

}

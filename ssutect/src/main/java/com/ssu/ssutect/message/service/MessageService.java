package com.ssu.ssutect.message.service;

import com.ssu.ssutect.message.Message;
import org.springframework.beans.factory.annotation.Autowired;

import com.ssu.ssutect.message.repository.MessageRepository;

public class MessageService {
    @Autowired
    private MessageRepository messageRepository;

    public void processMessageReport(String content){
        Message message = messageRepository.findByContent(content);
        if(message != null){    // 이미 같은 내용을 갖는 문자가 DB에 존재하면
            message.setCount(message.getCount() + 1);   // 신고 횟수를 증가시킴
            messageRepository.save(message);
        }
        else {
            Message reportMessage = new Message();
            reportMessage.setContent(content);
            reportMessage.setCount(1);
            reportMessage.setReport(1);     // report 1 : 제보된 메세지 / report 0 : 기존 저장된 메세지
            messageRepository.save(reportMessage);
        }
    }

}

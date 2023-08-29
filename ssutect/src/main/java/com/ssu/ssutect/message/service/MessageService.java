package com.ssu.ssutect.message.service;

import com.ssu.ssutect.message.Message;
import com.ssu.ssutect.message.vo.MessageVO;
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
            if(pac.equals(true)){
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

    public Boolean processMessageReport(String content){
        Message message = messageRepository.findByContent(content);
        int result;
        if(message != null){    // 이미 같은 내용을 갖는 문자가 DB에 존재하면
            message.setCount(message.getCount() + 1);   // 신고 횟수를 증가시킴
            result = messageRepository.updateMessage(message);
        }
        else {
            MessageVO reportMessage = new MessageVO();
            reportMessage.setContent(content);
            reportMessage.setCount(1);
            reportMessage.setReport(1);     // report 1 : 제보된 메세지 / report 0 : 기존 저장된 메세지
            result = messageRepository.saveMessage(reportMessage);
        }
        if(result == 1) {return true;}
        return false;
    }
}

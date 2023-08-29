package com.ssu.ssutect.message.repository;

import com.ssu.ssutect.message.Message;
import com.ssu.ssutect.message.vo.MessageVO;
import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageRepository {

    List<String> getAllMessage();

    Message findByContent(String content);
    int updateMessage(Message message);
    int saveMessage(MessageVO message);

}

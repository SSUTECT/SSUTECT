package com.ssu.ssutect.message.repository;

import com.ssu.ssutect.message.Message;

import org.springframework.data.jpa.repository.JpaRepository;

public interface MessageRepository extends JpaRepository<Message, Long>{
 
    Message findByContent(String content);
}


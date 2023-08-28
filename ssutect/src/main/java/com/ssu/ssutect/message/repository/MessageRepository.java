package com.ssu.ssutect.message.repository;

import org.apache.ibatis.annotations.Mapper;
import org.springframework.stereotype.Repository;

import java.util.List;

@Mapper
@Repository
public interface MessageRepository {

    List<String> getAllMessage();

}

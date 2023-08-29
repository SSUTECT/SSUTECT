package com.ssu.ssutect.message.vo;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
public class MessageVO {
    
    private String content; // 메시지 내용

    private int count; // 누적 횟수

    private int report; // 리포트 여부
}

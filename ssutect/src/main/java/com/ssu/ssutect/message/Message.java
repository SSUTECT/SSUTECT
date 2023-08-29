package com.ssu.ssutect.message;

import lombok.Getter;
import lombok.Setter;

import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.Id;

@Getter @Setter
public class Message {

    private Long id;

    private Long count; // 누적 횟수

    private String content; // 메시지 내용

    private Long report; // 리포트 여부
}

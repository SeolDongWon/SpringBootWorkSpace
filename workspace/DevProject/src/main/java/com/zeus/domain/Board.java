package com.zeus.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.AllArgsConstructor;
import lombok.Builder;
import lombok.Data;
import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


// 롬복 애너테이션
// @Data를 쓰면 6가지 전부 적용
//@Getter
//@Setter
//@NoArgsConstructor
//@RequiredArgsConstructor	//:@NonNull 혹은 final 필드값을 인자로 받는 생성자
//@AllArgsConstructor		//: 객체의 모든 필드값을 인자로 받는 생성자
//@ToString(exclude ="writer")
//@EqualsAndHashCode(of="boardNo")
@Data
//@Builder
public class Board implements Serializable {
	
	private static final long serialVersionUID = 1L;
//	@NonNull
	private int boardNo;
//	@NonNull
	private String title;
	private String content;
	private String writer;
	private Date regDate;
	
}

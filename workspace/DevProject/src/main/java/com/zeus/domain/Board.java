package com.zeus.domain;

import java.io.Serializable;
import java.util.Date;

import lombok.EqualsAndHashCode;
import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;
import lombok.Setter;
import lombok.ToString;


// 롬복 애너테이션

@Getter
@Setter
@NoArgsConstructor
@RequiredArgsConstructor
@ToString
@EqualsAndHashCode(of="boardNo")
public class Board implements Serializable {
	
	private static final long serialVersionUID = 1L;
	
	@NonNull
	private int boardNo;
	@NonNull
	private String title;
	private String writer;
	private Date regDate;
	
}

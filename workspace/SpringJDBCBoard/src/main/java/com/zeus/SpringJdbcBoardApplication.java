package com.zeus;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

@SpringBootApplication //현 파일이 위치한 패키지의 모든 하위패키지의 @객체 생성
public class SpringJdbcBoardApplication {

	public static void main(String[] args) {
		SpringApplication.run(SpringJdbcBoardApplication.class, args);
	}

}

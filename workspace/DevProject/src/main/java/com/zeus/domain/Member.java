package com.zeus.domain;

import java.time.LocalDate;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;

import jakarta.validation.constraints.NotBlank;
import lombok.Builder;
import lombok.Data;

//@Getter
//@Setter
//@ToString
@Data
//@Builder
public class Member {
	@NotBlank
	private String userId;
	private String password="1111";
	private String userName="설동원";
	private String email;
	private String gender;
	private String hobby;
	
	private String[] hobbyArray;
	private List<String> hobbyList;
	
	private boolean foreigner;
	private String developer;
	private String nationality;
	private Address address;
	private List<Card> cardList;
	private String cars;
	private String[] carArray;
	private List<String> carList;
	private String introduction;
	@DateTimeFormat(pattern = "yyyy-MM-dd")
	private Date dateOfBirth;
	private LocalDate LocalDateOfBirth;

	private int coin;
	
	

}

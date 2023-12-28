package com.zeus.domain;

import java.time.LocalDate;
import java.util.List;



import lombok.Builder;
import lombok.Data;

//@Getter
//@Setter
//@ToString
@Data
//@Builder
public class Member {
	private String userId;
	private String password;
	
	private String userName;
	
	private String email;
	
	private LocalDate dateOfBirth;
	
	private Address address;
	
	private List<Card> cardList;
	
	private String hobby;
	private String[] hobbyArray;
	private List<String> hobbyList;
	

}

package com.zeus.domain;

import java.time.YearMonth;
import java.util.Date;

import org.springframework.format.annotation.DateTimeFormat;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

//@Getter
//@Setter
//@ToString
@Data
public class Card {
	
	private String no;
	
	@DateTimeFormat(pattern = "yyyyMM")
	private Date validMonth;
//	private YearMonth validMonth;

}

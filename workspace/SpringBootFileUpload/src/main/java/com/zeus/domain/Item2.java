package com.zeus.domain;

import java.io.Serializable;
import java.util.List;

import org.springframework.web.multipart.MultipartFile;

import lombok.Getter;
import lombok.Setter;
import lombok.ToString;

@Getter
@Setter
@ToString
public class Item2 implements Serializable {
	private static final long serialVersionUID = 1L;
	private Integer itemId;
	private String itemName;
	private Integer price;
	private String description;
	private String pictureUrl;
	private String pictureUrl2;
	private List<MultipartFile> pictures;
}

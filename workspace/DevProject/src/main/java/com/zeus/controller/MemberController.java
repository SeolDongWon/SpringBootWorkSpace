package com.zeus.controller;

import java.time.LocalDate;
import java.time.LocalDateTime;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.springframework.format.annotation.DateTimeFormat;
import org.springframework.http.HttpStatus;
import org.springframework.http.HttpStatusCode;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.multipart.MultipartFile;

import com.zeus.domain.Address;
import com.zeus.domain.Card;
import com.zeus.domain.Member;

import lombok.extern.java.Log;

@Log
@Controller
public class MemberController {

	@RequestMapping(value = "/registerForm", method = RequestMethod.GET)
	public String registerForm() {
		log.info("registerForm");
		return "registerForm";
	}

	@RequestMapping(value = "/register/{userId}", method = RequestMethod.GET)
	public String registerByPath(@PathVariable("userId") String userId) {
		log.info("registerBy Path : /register/{userId}");
		log.info("userId : " + userId);
		return "success";
	}

	@RequestMapping(value = "/register/{userId}/{coin}", method = RequestMethod.GET)
	public String registerByPath(@PathVariable("userId") String userId, @PathVariable("coin") int coin) {
		log.info("registerBy Path : /register/{userId}/{coin}");
		log.info("userId : " + userId);
		log.info("coin : " + coin);
		return "success";
	}

	@RequestMapping(value = "/register01", method = RequestMethod.POST)
	public String register01(String userId) {
		log.info("register01 : userId");
		log.info("userId : " + userId);
		return "success";
	}

	@RequestMapping(value = "/register02", method = RequestMethod.POST)
	public String register02(@RequestParam("userId") String username) {
		log.info("register02 : @RequestParam");
		log.info("userId : " + username);
		return "success";
	}

	@PostMapping(value = "/registerbeans01")
	public String registerbeans01(Member member) {
		log.info("registerbeans01");
		log.info("member.getUserId : " + member.getUserId());
		log.info("member.getPassword : " + member.getPassword());
		log.info("member.getCoin : " + member.getCoin());
		return "success";
	}

	@PostMapping(value = "/registerbeans02")
	public String registerbeans02(Member member, int coin) {
		log.info("registerbeans02");
		log.info("member.getUserId : " + member.getUserId());
		log.info("member.getPassword : " + member.getPassword());
		log.info("member.getCoin : " + member.getCoin());
		log.info("coin : " + coin);
		return "success";
	}

	@PostMapping(value = "/registerdate")
	public String registerdate(Member member) {
		log.info("registerdate");
		log.info("member.getUserId : " + member.getUserId());
		log.info("member.getPassword : " + member.getPassword());
		log.info("member.getDateOfBirth : " + member.getDateOfBirth());
		member.setLocalDateOfBirth(LocalDate.of(2000, 10, 1));
		log.info("member.getLocalDateOfBirth : " + member.getLocalDateOfBirth());

		return "success";
	}

	@RequestMapping(value = "/registerByDateFormat03")
	public String registerByDateFormat03(Member member) {
		log.info("registerByDateFormat03");
		log.info("member.getUserId : " + member.getUserId());
		log.info("member.getDateOfBirth : " + member.getDateOfBirth());

		return "success";
	}

	@GetMapping(value = "/registerAllForm")
	public String registerAllForm() {
		log.info("registerAllForm");
		return "registerAllForm";
	}

	@PostMapping(value = "/registerMemberUserId")
	public String registerMemberUserId(Member member) {
		log.info("registerMemberUserId");
		log.info("member.getUserId() : " + member.getUserId());
		return "success";
	}

	@PostMapping(value = "/registerUser")
	public String registerUser(Member member) {
		log.info("registerUser");
		log.info("member.getUserId() : " + member.getUserId());
		log.info("member.getGender() : " + member.getGender());
		log.info("member.getHobby() : " + member.getHobby());
		log.info("member.isForeigner() : " + member.isForeigner());
		log.info("member.getDeveloper() : " + member.getDeveloper());
		log.info("member.getDateOfBirth() : " + member.getDateOfBirth());
		log.info("member.getCars() : " + member.getCars());
		log.info("member.getIntroduction() : " + member.getIntroduction());

		String[] hobbyArray = member.getHobbyArray();

		if (hobbyArray != null) {
			log.info("hobbyArray.length" + hobbyArray.length);
			for (int i = 0; i < hobbyArray.length; i++) {
				log.info("hobbyArray[" + i + "] : " + hobbyArray[i]);
			}
		} else {
			log.info("hobbyArray == null");
		}

		List<String> hobbyList = member.getHobbyList();

		if (hobbyList != null) {
			log.info("hobbyList.size() : " + hobbyList.size());
			for (int i = 0; i < hobbyList.size(); i++) {
				log.info("hobbyList(" + i + ") : " + hobbyList.get(i));
			}
		} else {
			log.info("hobbyList == null");
		}

		Address address = member.getAddress();

		if (address != null) {
			log.info("address.getPostCode : " + address.getPostCode());
			log.info("address.getLocation : " + address.getLocation());
		} else {
			log.info("address == null");
		}

		List<Card> cardList = member.getCardList();

		if (cardList != null) {
			log.info("cardList.size() : " + cardList.size());
			for (int i = 0; i < cardList.size(); i++) {
				Card card = cardList.get(i);
				log.info("card.getNo() : " + card.getNo());
				log.info("card.getValidMonth() : " + card.getValidMonth());
			}

		} else {
			log.info("cardList == null");
		}

		String[] carArray = member.getCarArray();

		if (carArray != null) {
			log.info("carArray.length" + carArray.length);
			for (int i = 0; i < carArray.length; i++) {
				log.info("carArray[" + i + "] : " + carArray[i]);
			}
		} else {
			log.info("carArray == null");
		}

		return "success";

	}

	@PostMapping(value = "/registerUserId")
	public String registerUserId(String userId) {
		log.info("registerUserId");
		log.info("userId : " + userId);
		return "success";
	}

	@PostMapping(value = "/registerPassword")
	public String registerPassword(String Password) {
		log.info("registerPassword");
		log.info("Password : " + Password);
		return "success";
	}

	@PostMapping(value = "/registerTextArea")
	public String registerTextArea(String introduction) {
		log.info("registerTextArea");
		log.info("introduction : " + introduction);
		return "success";
	}

	@PostMapping(value = "/registerRadio")
	public String registerRadio(String gender) {
		log.info("registerRadio");
		log.info("gender : " + gender);
		return "success";
	}

	@PostMapping(value = "/registerCheckbox01")
	public String registerCheckbox01(String hobby) {
		log.info("registerCheckbox01");
		log.info("hobby : " + hobby);
		return "success";
	}

	@PostMapping(value = "/registerCheckbox02")
	public String registerCheckbox02(String[] hobbyArray) {
		log.info("registerCheckbox02");

		if (hobbyArray != null) {
			log.info("hobbyArray.length" + hobbyArray.length);
			for (int i = 0; i < hobbyArray.length; i++) {
				log.info("hobbyArray[" + i + "] : " + hobbyArray[i]);
			}
		} else {
			log.info("hobbyArray == null");
		}

		return "success";
	}

	@PostMapping(value = "/registerCheckbox03")
	public String registerCheckbox04(String developer) {
		log.info("registerCheckbox04");
		log.info("developer : " + developer);

		return "success";
	}

	@PostMapping(value = "/registerCheckbox04")
	public String registerCheckbox05(boolean foreigner) {
		log.info("registerCheckbox05");
		log.info("foreigner : " + foreigner);

		return "success";
	}

	@PostMapping(value = "/registerSelect")
	public String registerSelect(String nationality) {
		log.info("registerSelect");
		log.info("nationality : " + nationality);

		return "success";
	}

	@PostMapping(value = "/registerMultipleSelect01")
	public String registerMultipleSelect01(String cars) {
		log.info("registerMultipleSelect01");
		log.info("cars : " + cars);

		return "success";
	}

	@PostMapping(value = "/registerMultipleSelect02")
	public String registerMultipleSelect02(String[] carArray) {
		log.info("registerMultipleSelect02");
		
		if (carArray != null) {
			log.info("carArray.length" + carArray.length);
			for (int i = 0; i < carArray.length; i++) {
				log.info("carArray[" + i + "] : " + carArray[i]);
			}
		} else {
			log.info("carArray == null");
		}
		return "success";
	}
	@PostMapping(value = "/registerMultipleSelect03")
	public String registerMultipleSelect03(@RequestParam("carList") ArrayList<String> carList) {
		log.info("registerMultipleSelect03");
		if (carList != null) {
			log.info("carList.size() : " + carList.size());
			for (int i = 0; i < carList.size(); i++) {
				log.info("carList(" + i + ") : " + carList.get(i));
			}
		} else {
			log.info("carList == null");
		}
		return "success";
	}
	@PostMapping(value = "/registerAddress")
	public String registerAddress(Address address) {
		log.info("registerAddress");
		
		if (address != null) {
			log.info("address.getPostCode : " + address.getPostCode());
			log.info("address.getLocation : " + address.getLocation());
		} else {
			log.info("address == null");
		}
		return "success";
	}
	@PostMapping(value = "/registerUserAddress")
	public String registerUserAddress(Member member) {
		log.info("registerUserAddress");
		
		Address address = member.getAddress();
		
		if (address != null) {
			log.info("address.getPostCode : " + address.getPostCode());
			log.info("address.getLocation : " + address.getLocation());
		} else {
			log.info("address == null");
		}
		return "success";
	}
	@PostMapping(value = "/registerUserCardList")
	public String registerUserCardList(Member member) {
		log.info("registerUserCardList");
		
		List<Card> cardList = member.getCardList();

		if (cardList != null) {
			log.info("cardList.size() : " + cardList.size());
			for (int i = 0; i < cardList.size(); i++) {
				Card card = cardList.get(i);
				log.info("card.getNo() : " + card.getNo());
				log.info("card.getValidMonth() : " + card.getValidMonth());
			}

		} else {
			log.info("cardList == null");
		}
		return "success";
	}
	@PostMapping(value = "/registerDate01")
	public String registerDate01(@DateTimeFormat(pattern = "yyyyMMdd") Date dateOfBirth) {
		log.info("registerDate01");
		
		
		if (dateOfBirth != null) {
			log.info("dateOfBirth : " + dateOfBirth);
		} else {
			log.info("dateOfBirth == null");
		}
		return "success";
	} 
	
	@PostMapping(value = "/uploadAjax", produces = "text/plain;charset=UTF-8")
	public ResponseEntity<String> uploadAjax(MultipartFile file) throws Exception{
		String originalFilename =file.getOriginalFilename();
		
		log.info("originalFilename : "+originalFilename);
		
		ResponseEntity<String> entity = new ResponseEntity<String>("UPLOAD SUCCESS : "+originalFilename,HttpStatus.OK);
		
		return entity;
	}
	
	@GetMapping(value = "/model03")
	public String model03(Model model) {
		
		String[] carArray= {"saab","audi"};
		
		List<String> carList = new ArrayList<String>();
		carList.add("saab");
		carList.add("audi");
		
		String[] hobbyArray = {"Music","Movie"};
		
		List<String> hobbyList = new ArrayList<String>();
		hobbyList.add("Music");
		hobbyList.add("Movie");
		
		model.addAttribute("carArray", carArray);
		model.addAttribute("carList", carList);
		
		model.addAttribute("hobbyArray", hobbyArray);
		model.addAttribute("hobbyList", hobbyList);
		
		return "model03"; // 뷰 파일명
	}
}

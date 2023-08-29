package com.marondal.spring.test.jsp;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.ResponseBody;

import com.marondal.spring.test.jsp.domain.Seller;
import com.marondal.spring.test.jsp.service.SellerService;

@RequestMapping("/jsp/seller")
@Controller
public class SellerController {
	
	@Autowired
	private SellerService sellerService;
	
	// 닉네임, 프로필 url, 매너 온도 전달받고 저장하는 기능
	@PostMapping("/create")
	@ResponseBody
	public String createSeller(
			@RequestParam("nickname") String nickname
			, @RequestParam("profileImage") String profileImage
			, @RequestParam("temperature") double temperature) {
		
		int count = sellerService.addSeller(nickname, profileImage, temperature);
		
		
		return "수행 결과 : " + count;
		
	}
	
	@GetMapping("/input")
	public String sellerInput() {
		
		
		return "jsp/sellerInput";
	}
	
	@GetMapping("/last")
	public String lastSeller(Model model) {
		
		Seller seller = sellerService.getLastSeller();
		model.addAttribute("seller", seller);
		
		
		return "jsp/sellerInfo";
	}
	
	@GetMapping("/info")
	public String sellerInfo(
			@RequestParam(value="id", required=false) Integer id
			, Model model) {
		Seller seller = null;
		// id 파라미터가 있으면, id와 일치하는 판매자 정보
		if(id != null) {
			seller = sellerService.getSeller(id);
		} else { // id 파리미터가 없으면, 최근 등록된 판매자 정보
			seller = sellerService.getLastSeller();
		}		
		
		model.addAttribute("seller", seller);
		return "jsp/sellerInfo";
		
	}
	

}

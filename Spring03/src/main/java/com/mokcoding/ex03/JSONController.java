package com.mokcoding.ex03;

import java.util.ArrayList;
import java.util.List;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseBody;

import com.mokcoding.ex03.domain.ProductDTO;

import lombok.extern.log4j.Log4j;

@Controller
@Log4j
public class JSONController {
	
	
	@GetMapping("/jsp")
	public String returnJSP() {
		log.info("returnJSP()");
		return "home"; // jsp 호출
	} // end returnJSP()
	
	// 문자열 리턴
	@GetMapping("/json1")
	@ResponseBody // 리턴 결과가 바인딩된 JSON 데이터
	public String json1() {
		log.info("json1()");
		return "Hello, Spring"; // 문자열 데이터 바인딩 및 전송
	} // end json1()
	
	// DTO 객체를 JSON 데이터로 바인딩 후 전송
	@GetMapping("/json2")
	@ResponseBody
	public ProductDTO json2() {
		log.info("json3() 호출");
		ProductDTO product = new ProductDTO();
		product.setName("야구공");
		product.setPrice(10000);
		
		return product;
	} // end json2()
	
	// List 객체를 JSON 데이터로 바인딩 후 전송
	@GetMapping("/json3")
	@ResponseBody
	public List<ProductDTO> json3() {
		log.info("json3() 호출");
		ProductDTO product1 = new ProductDTO();
		product1.setName("야구공");
		product1.setPrice(10000);

		ProductDTO product2 = new ProductDTO();
		product2.setName("축구공");
		product2.setPrice(15000);
		
		List<ProductDTO> list = new ArrayList<>();
		list.add(product1);
		list.add(product2);
		
		return list;
	} // end json3()
	
	
	@PostMapping("/json4")
	@ResponseBody
	public String json4(@RequestBody ProductDTO dto) {
		// @RequestBody : 매개변수로 지정된 객체에 JSON 데이터 바인딩
		log.info(dto);
		return "success";
	}
	
} // end JSONController
package com.mokcoding.ex03.domain;

import lombok.Getter;
import lombok.NoArgsConstructor;
import lombok.Setter;
import lombok.ToString;

@NoArgsConstructor
@Getter 
@Setter
@ToString 
public class ProductDTO {
	private String name; // 이름
	private int price; // 가격

} // end ProductDTO
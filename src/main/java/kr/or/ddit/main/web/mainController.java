package kr.or.ddit.main.web;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

@Controller
public class mainController {
	
	/**
	 * 
	* Method   : main 
	* 작성자 : chan 
	* 변경이력 :  
	* @return  
	* Method 설명 : main 화면 요청
	 */
	@RequestMapping("/main")
	public String main() {
		return "main";
	}
	
}

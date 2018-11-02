package kr.or.ddit.user.web;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.http.HttpMethod;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;

import kr.or.ddit.user.UserVo;

@RequestMapping("/user")
@Controller

public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	@RequestMapping("/loginView")
	public String login() {
		
		return "/login/login";
	}
	
	@RequestMapping(value="/loginProcess", method = RequestMethod.POST)
	public String loginProcess(UserVo userVo) {
		
		if(userVo.getUserId().equals("brown") && userVo.getPass().equals("brownpass")) {
			return "main";
		}else {
			return "login/login";
		}
		
		
	}

}

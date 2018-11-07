package kr.or.ddit.prod.web;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.RequestMapping;

import kr.or.ddit.user.service.UserServiceInf;

@RequestMapping("/prod")
@Controller
public class ProdController {
	
//	//userService 스프링 주입
//		@Resource(name="prodService")
//		private UserServiceInf userService;
//		
//		@RequestMapping("/prod")
//		public String login() {
//			
//			return "/login/login";
//		}
}

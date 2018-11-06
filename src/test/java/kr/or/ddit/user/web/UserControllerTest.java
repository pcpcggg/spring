package kr.or.ddit.user.web;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.post;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.ControllerTestConfig;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/servlet-context.xml",
"classpath:kr/or/ddit/config/spring/root-context.xml"})
@WebAppConfiguration   // 스프링 컨테이너를 web 기반 컨테이너로 생성
public class UserControllerTest extends ControllerTestConfig{
	
	
	/**
	 * 
	* Method   : loginViewTest 
	* 작성자 : chan 
	* 변경이력 :    
	* Method 설명 :
	 * @throws Exception 
	 */
	@Test
	public void loginViewTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/user/loginView")).andReturn();
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		//viewName
		assertEquals("/login/login", mav.getViewName());
	}
	
	/**
	 * 
	* Method   : loginProcessTest 
	* 작성자 : chan 
	* 변경이력 :    
	* Method 설명 :
	 * @throws Exception 
	 */
	
	@Test
	public void loginProcessSuccessTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(post("/user/loginProcess").param("userId", "brown").param("pass", "brownpass")).andReturn();
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		
		
		/***Then***/
		assertEquals("main", mav.getViewName());
	}
	
	@Test
	public void loginProcessFailTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(post("/user/loginProcess").param("userId", "brownm").param("pass", "brownpassm")).andReturn();
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		
		
		/***Then***/
		assertEquals("login/login", mav.getViewName());
	}


}

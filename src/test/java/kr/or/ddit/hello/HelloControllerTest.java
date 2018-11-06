package kr.or.ddit.hello;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.test.ControllerTestConfig;
import kr.or.ddit.user.util.model.UserVo;


public class HelloControllerTest extends ControllerTestConfig{
	
	
	private Logger logger = LoggerFactory.getLogger(HelloControllerTest.class);
	
	@Test
	public void helloTest() throws Exception {
		/***Given***/
		
		/***When***/
		//dispatcher servlet으로 요청 전송
		MvcResult mvcResult = mockMvc.perform(get("/hello/hello.do")).andReturn();
		
		ModelAndView mav = mvcResult.getModelAndView();
		
		/***Then***/
		//viewName : hello
		assertEquals("hello", mav.getViewName());
	}
	
	@Test
	public void modelTest() throws Exception{
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/hello/model")).andReturn();
		
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		List<String> rangers = (List<String>) mav.getModel().get("rangers");
		mav.getModelMap().get("rangers");
		
		for(String ranger : rangers) {
			logger.debug("ranger : {}",ranger);
		}
						
		/***Then***/
		// 1. view 이름
		assertEquals("hello", viewName);
		
		// 2. rangers 속성 (model)
		assertEquals(3, rangers.size());
		
		
	}
	
	@Test
	public void requestTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/hello/request").param("userId", "brown").param("pass", "brownpass")).andReturn();
		
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		
		//viewName
		String viewName = mav.getViewName();
		
		//userId, pass 속성
		String userId = (String)mav.getModel().get("userId");
		String pass = (String)mav.getModel().get("pass");
		
		/***Then***/
		assertEquals("hello", viewName);
		assertEquals("brown_attr", userId);
		assertEquals("brownpass_attr", pass);
		
	}
	
	@Test
	public void voTest() throws Exception {
		/***Given***/
		
		MvcResult mvcResult = mockMvc.perform(get("/hello/vo").param("userId", "brown").param("pass", "brownpass")).andReturn();
		
		
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		
		String viewName = mav.getViewName();
		UserVo uservo = (UserVo) mav.getModel().get("userVo");

		String userId = uservo.getUserId();
		String pass = uservo.getPass();

		/***Then***/
		
		assertEquals("hello", viewName);
		assertEquals("brown", userId);
		assertEquals("brownpass", pass);
	}
	
	
	@Test
	public void modelAndView() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/hello/modelAndView")).andReturn();
		/***When***/
		
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName();
		
		List<String> rangers = (List<String>) mav.getModel().get("rangers");
		
		/***Then***/
		assertEquals(3, rangers.size());
	}
	

}

package kr.or.ddit.mvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.model;

import java.util.ArrayList;
import java.util.List;

import org.junit.Before;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MockMvc;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.test.web.servlet.setup.MockMvcBuilders;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.ModelAttribute;
import org.springframework.web.context.WebApplicationContext;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.file.util.FileUtil;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/servlet-context.xml",
"classpath:kr/or/ddit/config/spring/root-context.xml"})
@WebAppConfiguration  //spring ioc 컨테이너 구성을  web 환경에 맞게 구성
public class MvcControllerTest {
	
	
	
	private Logger logger = LoggerFactory.getLogger(MvcControllerTest.class);
	
	@Autowired
	private WebApplicationContext ctx; 	// spring ioc 컨테이너
	
	private MockMvc mockMvc; 			//dispatcher servlet(front controller)
	
	@Before
	public void setup() {
		mockMvc = MockMvcBuilders.webAppContextSetup(ctx).build();
	}
	
	@Test
	public void helloTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/mvc/view")).andReturn();
		
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();
		String viewName = mav.getViewName(); 
		List<String> rangers = (List<String>) mav.getModel().get("rangers");
		
		/***Then***/
		assertEquals("mvc/view", viewName);
		assertEquals(4, rangers.size());
	
	}
	
	@Test
	public void fileuploadViewTest() throws Exception {
		/***Given***/
		MvcResult mvcResult = mockMvc.perform(get("/mvc/fileupload")).andReturn();
		/***When***/
		ModelAndView mav = mvcResult.getModelAndView();

		/***Then***/
		assertEquals("mvc/fileuploadView", mav.getViewName());
	}
	
	// 테스트 코드를 운영코드보다 먼저 작성하는 방법
	// Test Driven Development
	@Test
	public void fileExtension() {
		/***Given***/
		String fileName = "park.jpg";
		String fileName2 = "park";
		/***When***/
		FileUtil fileUtil = new FileUtil();
	
		String fileExt = fileUtil.getFileExt(fileName);
		String fileExt2 = fileUtil.getFileExt(fileName2);
		
		/***Then***/
		assertEquals(".jpg", fileExt);
		assertEquals("", fileExt2);
	}

	

	
}

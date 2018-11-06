package kr.or.ddit.mvc;

import static org.junit.Assert.assertEquals;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;

import java.util.List;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;
import org.springframework.test.context.web.WebAppConfiguration;
import org.springframework.test.web.servlet.MvcResult;
import org.springframework.web.servlet.ModelAndView;

import kr.or.ddit.file.util.FileUtil;
import kr.or.ddit.test.ControllerTestConfig;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/servlet-context.xml",
"classpath:kr/or/ddit/config/spring/root-context.xml"})
@WebAppConfiguration  //spring ioc 컨테이너 구성을  web 환경에 맞게 구성
public class MvcControllerTest extends ControllerTestConfig {
	
	
	
	private Logger logger = LoggerFactory.getLogger(MvcControllerTest.class);
	
	
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

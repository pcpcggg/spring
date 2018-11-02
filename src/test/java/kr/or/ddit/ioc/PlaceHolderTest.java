package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.Properties;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/ioc/application-context-placeholder.xml"})
public class PlaceHolderTest {

	@Resource(name="placeHolder")
	private PlaceHolder placeHolder;
	
	/**  
	* Method   : placeHolderTest 
	* 작성자 : bms 
	* 변경이력 :    
	* Method 설명 : 설정한 placeholder 의 값이 정상적으로 불러지는지 확인  
	*/
	@Test
	public void placeHolderTest() {
		/***Given***/
		

		/***When***/

		/***Then***/
		assertEquals("bms", placeHolder.getUser());
		assertEquals("java", placeHolder.getPassword());
		assertEquals("oracle.jdbc.driver.OracleDriver", placeHolder.getDriver());
		assertEquals("jdbc:oracle:thin:@localhost:1521:xe", placeHolder.getUrl());
	}
	

}

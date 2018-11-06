package kr.or.ddit.user.dao;

import static org.junit.Assert.*;

import java.util.Date;
import java.util.GregorianCalendar;
import java.util.List;

import javax.annotation.Resource;

import kr.or.ddit.hello.HelloControllerTest;
import kr.or.ddit.test.ServiceDaoTestConfig;
import kr.or.ddit.user.dao.UserDao;
import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.util.model.UserVo;

import org.junit.Before;
import org.junit.Test;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class UserDaoTest extends ServiceDaoTestConfig {
	
	private Logger logger = LoggerFactory.getLogger(HelloControllerTest.class);
	
	@Resource(name="userDao")
	private UserDaoInf ud;
	
	@Before
	public void setup(){
		ud = new UserDao();
	}

	@Test
	public void selectUserAllTest() {
		List<UserVo> userVoList = ud.getUserAll();
		for(UserVo uv : userVoList){
			System.out.println(uv.toString());
		}
		
		assertEquals(105, userVoList.size());
	}
	
	/**
	 * 아이디를 매개변수로 주고 userVo 를 얻어오는 메서드 테스트
	 * Method : selectUserTest
	 * 작성자 : bms
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void selectUserTest(){
		/***Given***/
		
		/***When***/
		UserVo brown = ud.selectUser("brown");
		System.out.println(brown.getName()+","+brown.getUserId());
		
		/***Then***/
		
		assertEquals("브라운",brown.getName());
		assertEquals("brown",brown.getUserId());
		
	}
	
	/**
	 * Dao 의 같은 메서드명에 다른 매개변수를 가진 오버로딩 메서드를 활용
	 * Method : selectUserByVoTest
	 * 작성자 : bms
	 * 변경이력 :
	 * Method 설명 :
	 */
	@Test
	public void selectUserByVoTest(){
		/***Given***/
		UserVo TestVo = new UserVo();
		TestVo.setUserId("brown");
		/***When***/
		UserVo brown = ud.selectUser(TestVo);
		System.out.println(brown.getName()+","+brown.getUserId());
		
		/***Then***/
		
		assertEquals("브라운",brown.getName());
		assertEquals("brown",brown.getUserId());
		
	}
	
	//기존 service >> dao 는 단순히 동일이름 메서드 호출만했다
	// 이제 service 에서 dao에서 여러개의 메서드 호출
	
	//ex) 게시글 입력
	// 제목, 내용 --> board
	// 첨부파일 ==> boardFile  두번에 걸쳐 불러와야한다

	@Test
	public void getUserCntTest(){
		/***Given***/

		/***When***/
		int totalCnt = ud.getUserCnt();

		/***Then***/
		assertEquals(105,totalCnt);

	}
	
	@Test
	public void insertUserTest(){
		/***Given***/
		//UserVo 준비
		UserVo userVo = new UserVo();
		userVo.setUserId("testId");
		userVo.setName("TestNm");
		userVo.setPass("pass1234");
		userVo.setAddr1("큰주소");
		userVo.setAddr2("작은주소");
		userVo.setZipcd("12345");
		GregorianCalendar gc = new GregorianCalendar(2018,7,8);
		userVo.setBirth(new Date(gc.getTimeInMillis()));
		userVo.setEmail("이메일@이메일");
		userVo.setTel("전화번호");
		
		

		/***When***/
		//userDao.insert.User()
		int cnt = ud.insertUser(userVo);
		

		/***Then***/
		//입력건수
		assertEquals(1, cnt);

	}
	
	@Test
	public void deleteUserTest(){
		/***Given***/
		String userId = "testId";

		/***When***/
		int cnt = ud.deleteUser(userId);

		/***Then***/
		assertEquals(1,cnt);

	}
	
	
}

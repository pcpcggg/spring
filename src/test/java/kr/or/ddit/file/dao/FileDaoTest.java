package kr.or.ddit.file.dao;

import static org.junit.Assert.assertEquals;

import javax.annotation.Resource;

import org.junit.Test;

import kr.or.ddit.file.model.FileVo;
import kr.or.ddit.test.ServiceDaoTestConfig;

//@RunWith(SpringJUnit4ClassRunner.class)
//@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/root-context.xml"})

public class FileDaoTest extends ServiceDaoTestConfig {
	
	@Resource(name="fileDao")
	private FileDaoInf fileDao;
	
	/**
	 * 
	* Method   : test 
	* 작성자 : chan 
	* 변경이력 :    
	* Method 설명 : 파일정보 입력 테스트
	 */
	@Test(timeout = 5000)
	public void insertFileTest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("3f65c515-19b4-4525-9906-a81e4fddf4b2.png");
		fileVo.setOrg_file_name("noun_1850157_cc.png");
		fileVo.setFile_ext(".png");
		fileVo.setFile_path("C:\\Users\\chan\\Desktop\\DeveloperCourse\\A_TeachingMaterial\\6.JspSrpgin\\upload");
		
		/***When***/
		
		int insertCnt = fileDao.insertFile(fileVo);

		/***Then***/
		
		assertEquals(1, insertCnt);
	}
	
	

}

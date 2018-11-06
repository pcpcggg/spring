package kr.or.ddit.file.service;

import static org.junit.Assert.*;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

import kr.or.ddit.file.model.FileVo;


@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/root-context.xml"})

public class FileServiceTest {

	@Resource(name="fileService")
	private FileServiceInf fileService;
	
	@Test
	public void insertFileServiceTest() {
		/***Given***/
		FileVo fileVo = new FileVo();
		fileVo.setFile_name("3f65c515-19b4-4525-9906-a81e4fddf4b2.png");
		fileVo.setOrg_file_name("noun_1850157_cc.png");
		fileVo.setFile_ext(".png");
		fileVo.setFile_path("C:\\Users\\chan\\Desktop\\DeveloperCourse\\A_TeachingMaterial\\6.JspSrpgin\\upload");
		
		/***When***/
		
		int insertCnt = fileService.insertFile(fileVo);

		/***Then***/
		
		assertEquals(1, insertCnt);
	}
}

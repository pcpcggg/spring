package kr.or.ddit.ioc;

import static org.junit.Assert.*;

import java.util.List;

import javax.annotation.Resource;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Service;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;


import kr.or.ddit.board.dao.BoardDao;
import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

@RunWith(SpringJUnit4ClassRunner.class)
@ContextConfiguration(locations= {"file:src/main/resources/kr/or/ddit/ioc/application-context-scan.xml"})

public class ComponentScanTest {
	
	
	private Logger logger = LoggerFactory.getLogger(ComponentScanTest.class);
	
	@Resource(name="boardDao")
	private BoardDaoInf boardDao;
	
	@Resource(name="boardService")
	private BoardServiceInf boardService;
	
	/**
	 *  
	* Method   : componentScanTest
	* 작성자 : chan 
	* 변경이력 :    
	* Method 설명 : spring annotation scan을 통해 스프링 빈 생성이 정상적으로 되었는지 테스트
	 */
	
	@Test
	public void componentScanTest() {
			
		List<BoardVo> boardList = boardDao.selectBoardList();
		for(BoardVo boardVo : boardList) {
			logger.debug("{}", boardVo);
		}
		
		assertNotNull(boardDao);
		
	}
	
	// boardService 스프링 빈 테스트
	
	@Test
	public void boardServiceTset() {
			
		List<BoardVo> boardList2 = boardService.selectBoardList();
		for(BoardVo boardVo : boardList2) {
			logger.debug("{}", boardVo);
		}
		
		assertNotNull(boardService);
		
	}
	
	@Test 
	public void boardSDaoCompare(){
		
		/***Given***/
		
		/***When***/
		
		/***Then***/
		
		assertEquals(boardDao, boardService.getBoardDao());
		
	}

}

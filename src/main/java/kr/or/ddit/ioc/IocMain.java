package kr.or.ddit.ioc;

import java.util.List;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.context.ApplicationContext;
import org.springframework.context.support.ClassPathXmlApplicationContext;

import kr.or.ddit.board.dao.BoardDaoInf;
import kr.or.ddit.board.model.BoardVo;
import kr.or.ddit.board.service.BoardService;
import kr.or.ddit.board.service.BoardServiceInf;

public class IocMain {
	
	private static Logger logger = LoggerFactory.getLogger(IocMain.class);
	
	public static void main(String[] args) {
		
		
		//스프링 컨테이너 생성
		ApplicationContext context = new ClassPathXmlApplicationContext(new String[] {
			"classpath:kr/or/ddit/ioc/application-context.xml"
		});
		
		//스프링 컨테이너에서 boardDao 스프링 빈을 요청(DL : dependency Lookup)
		BoardDaoInf boardDao = (BoardDaoInf)context.getBean("boardDao");
		List<BoardVo> boardList = boardDao.selectBoardList();
		for(BoardVo boardVo : boardList) {
			logger.debug("Dao >> boardVo : {}",boardVo);
			//System.out.println("boardVo : " + boardVo);
		}
		
		
		//스프링 컨테이너에서 boardService 스프링 빈을 요청한 후 selectBoardList 결과를 logger를 이용해 console 출력
		BoardServiceInf boardService = (BoardService) context.getBean("boardService");
		List<BoardVo> boardList2 = boardService.selectBoardList();
		for(BoardVo boardVo : boardList2) {
			logger.debug("Service >> boardVo : {}",boardVo);
			//System.out.println("boardVo : " + boardVo);
		}
		
		//생성자 주입을 통해 생성된 boardService 스프링 빈을 요청
		BoardServiceInf boardServiceConst = context.getBean("boardServiceConst", BoardService.class);
		List<BoardVo> boardList3 = boardServiceConst.selectBoardList();
		for(BoardVo boardVo : boardList3) {
			logger.debug("ServiceConst >> boardVo : {}",boardVo);
			//System.out.println("boardVo : " + boardVo);
		}
		
		//spring scope-prototype test
		BoardDaoInf boardDaoPrototype1 = context.getBean("boardDaoPrototype1",BoardDaoInf.class);
		BoardDaoInf boardDaoPrototype2 = context.getBean("boardDaoPrototype1",BoardDaoInf.class);
		
		logger.debug("spring prototype bean test : {}",boardDaoPrototype1==boardDaoPrototype2);
		
		//spring scope-singleton test
		BoardDaoInf boardDaoSingleton1 = context.getBean("boardDaoSingleton",BoardDaoInf.class);
		BoardDaoInf boardDaoSingleton2 = context.getBean("boardDaoSingleton",BoardDaoInf.class);
		logger.debug("spring singleton bean test : {}",boardDaoSingleton1==boardDaoSingleton2);
		
		
	} // main 메서드 종료
} // IocMain 클래스 종료

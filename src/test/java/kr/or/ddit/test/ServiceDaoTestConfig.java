package kr.or.ddit.test;

import static org.junit.Assert.assertTrue;

import org.junit.Ignore;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.test.context.ContextConfiguration;
import org.springframework.test.context.junit4.SpringJUnit4ClassRunner;

@RunWith(SpringJUnit4ClassRunner.class)

//service, dao 대한 설정파일만 필요한다.
@ContextConfiguration(locations= {"classpath:kr/or/ddit/config/spring/root-context.xml"})


public class ServiceDaoTestConfig {
	
	@Ignore
	@Test
	public void test() {
		assertTrue(true);
	}

}

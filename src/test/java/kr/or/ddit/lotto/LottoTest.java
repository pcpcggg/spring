package kr.or.ddit.lotto;

import static org.junit.Assert.*;

import org.junit.Test;
public class LottoTest {


	
	
	@Test
	public void test() {
		/***Given***/
		//객체 생성시 Lotto(총숫자갯수, 최대번호수를 지정한다)
		//이때 당첨 번호가 나온다
		Lotto lotto = new Lotto(6,45);

		/***When***/
		int[] result = lotto.numMaker();

		/***Then***/
		System.out.println("등수 : "+lotto.getGradeChk());
		System.out.println(lotto.toString());
		assertEquals(6, result.length);
		
	}

}

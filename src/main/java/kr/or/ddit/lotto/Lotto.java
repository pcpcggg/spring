package kr.or.ddit.lotto;

import java.util.Arrays;

public class Lotto {
	//lotto 요구사항
	/*
	1. 사용자로부터 공의 갯수를 입력받음
	2. 추첨 공의 갯수도 입력받음
	3. 실행시 추첨 공의 갯수만큼의 정수를 담은 배열을 리턴해 준다
	4. 추첨된 공은 중복 될 수 없다
	5. 실행할 수있는 테스트 코드를 같이 만든다.
	
	@Test
	public void lottoTest(){
		Lotto lotto = new Lotto();
		lotto.setMaxNum(55);
	}
	
	
	 */
	private int[] comNumList;
	private int[] numList;
	private int maxNum;
	private int gradeChk;
	
	public Lotto() {}
	
	//매개변수있는 생성자에서 생성할때 배열의 갯수와, 최대값을 정해주면서 생성한다
	public Lotto(int numCount, int maxNum) {
		numList = new int[numCount];
		comNumList = new int[numCount];
		this.maxNum = maxNum;
		comNumList = comNumMaker();
	}

	// getter setter
	public int[] getNumList() {
		return numList;
	}

	public void setNumList(int[] numList) {
		this.numList = numList;
	}

	public int getMaxNum() {
		return maxNum;
	}

	public void setMaxNum(int maxNum) {
		this.maxNum = maxNum;
	}
	
		
	public int[] getComNumList() {
		
		return comNumList;
	}

	public void setComNumList(int[] comNumList) {
		this.comNumList = comNumList;
	}

	public int getGradeChk() {
		return gradeChk;
	}

	public void setGradeChk(int gradeChk) {
		this.gradeChk = gradeChk;
	}

	//사용자 로또 숫자 생성 메서드 numMaker
	public int[] numMaker() {
		
		
		for(int n = 0; n < numList.length; n++) {
			int num = 0;
			
			do {
				num=(int)(Math.random()*maxNum+1);
				
			} while(numChk(num)); // 중복되는 숫자가 없을때까지 반복해서 random 돌림
			
			numList[n] = num; 
		}
		//등수는 갯수 +1등에서 시작
		gradeChk = numList.length+1;
		// 일치하는게 있을떄마다 등수하나씩 감소
		for(int n = 0; n < numList.length; n++) {
			for(int mm = 0+n;mm < comNumList.length;mm++) {
				if(numList[n]==comNumList[mm]) {
					gradeChk--;
				}
				
			}
		}
		
		return numList;
	}
	//로또회사  숫자 생성 메서드 comNumMaker
	public int[] comNumMaker() {
		
		
		for(int n = 0; n < comNumList.length; n++) {
			int num = 0;
			
			do {
				num=(int)(Math.random()*maxNum+1);
				
			} while(ComNumChk(num)); // 중복되는 숫자가 없을때까지 반복해서 random 돌림
			
			comNumList[n] = num; 
		}
		
		return comNumList;
	}
	
	//배열안에 중복숫자 있는지 테스트
	public boolean numChk(int num) {
		boolean chk=false;
		
		for(int n = 0; n < numList.length; n++) {
			if(numList[n]==num) {
				chk=true;
			}
		}
		
		return chk;
	}
	//배열안에 중복숫자 있는지 테스트
	public boolean ComNumChk(int num) {
		boolean chk=false;
		
		for(int n = 0; n < comNumList.length; n++) {
			if(comNumList[n]==num) {
				chk=true;
			}
		}
		
		return chk;
	}

	@Override
	public String toString() {
		return "Lotto [comNumList=" + Arrays.toString(comNumList) + ", numList=" + Arrays.toString(numList)
				+ ", maxNum=" + maxNum + ", gradeChk=" + gradeChk + "]";
	}
	
	
	
}

package kr.or.ddit.board.model;

public class BoardVo {
	private int boardNm;
	private String boardId;
	private String regId;
	
	
	//기본생성자
	public BoardVo() {}
	
	//매개변수있는 생성자
	public BoardVo(int boardNm, String boardId, String regId) {
		super();
		this.boardNm = boardNm;
		this.boardId = boardId;
		this.regId = regId;
	}
	
	public int getBoardNm() {
		return boardNm;
	}
	public void setBoardNm(int boardNm) {
		this.boardNm = boardNm;
	}
	public String getBoardId() {
		return boardId;
	}
	public void setBoardId(String boardId) {
		this.boardId = boardId;
	}
	public String getRegId() {
		return regId;
	}
	public void setRegId(String regId) {
		this.regId = regId;
	}
	@Override
	public String toString() {
		return "BoardVo [boardNm=" + boardNm + ", boardId=" + boardId + ", regId=" + regId + "]";
	}
	
	
	
	
}

package kr.or.ddit.user.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.user.dao.UserDaoInf;
import kr.or.ddit.user.util.model.PageVo;
import kr.or.ddit.user.util.model.UserVo;

@Service("userService")
public class UserService implements UserServiceInf {
	
	@Resource(name="userDao")
	private UserDaoInf ud;
	

	@Override
	public List<UserVo> getUserAll() {
		return ud.getUserAll();
	}
	
	@Override
	public UserVo selectUser(String userId) {
		return ud.selectUser(userId);
	}
	
	@Override
	public UserVo selectUser(UserVo userVo) {
		return ud.selectUser(userVo);
	}

	@Override
	public UserVo selectUser() {
	
		return null;
	}
	
	/**
	 * 
	* Method : selectUserPageList
	* 작성자 : chan
	* 변경이력 :
	* @param page
	* @return
	* Method 설명 : 사용자 페이지 조회
	 */
	
	@Override
	public Map<String, Object> selectUserPageList(PageVo page){
		// 페이지에 해당하는 유저 리스트 (1~10건 사이)
		List<UserVo> userList = ud.selectUserPageList(page);
		
		// 페이지 내비게이션을 위한 유저 리스트 조회
		int totalUserCnt = ud.getUserCnt();
		
		// 결과를 담는 map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("pageList", userList);
		resultMap.put("pageCnt", (int)Math.ceil( (double)totalUserCnt / page.getPageSize()));
		
		//(int)Math.ceil( (double)totalUserCnt / pageVo.getPageSize());
		
		return resultMap;
	}



	public int getUserCnt() {
		return ud.getUserCnt();
	}
	
	/**
	 * 
	* Method : insertUser
	* 작성자 : chan
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 회원 추가
	 */

	public int insertUser(UserVo userVo) {
		return ud.insertUser(userVo);
	}
	
	/**
	 * 
	* Method : deleteUser
	* 작성자 : chan
	* 변경이력 :
	* @param userId
	* @return
	* Method 설명 : 회원 삭제
	 */
	
	public int deleteUser(String userId) {
		return ud.deleteUser(userId);
	}

	
	/**
	 * 
	* Method : updateUser
	* 작성자 : chan
	* 변경이력 :
	* @param userVo
	* @return
	* Method 설명 : 회원 업데이트
	 */
	
	public int updateUser(UserVo userVo) {
		return ud.updateUser(userVo);
	}
	
	
	
}

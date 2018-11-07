package kr.or.ddit.user.web;

import java.io.File;
import java.io.IOException;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RequestPart;
import org.springframework.web.multipart.MultipartFile;

import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.user.util.model.PageVo;
import kr.or.ddit.user.util.model.UserVo;

@RequestMapping("/user")
@Controller

public class UserController {
	
	private Logger logger = LoggerFactory.getLogger(UserController.class);
	
	//userService 스프링 주입
	@Resource(name="userService")
	private UserServiceInf userService;
	
	@RequestMapping("/loginView")
	public String login() {
		
		return "/login/login";
	}
	
	@RequestMapping(value="/loginProcess", method = RequestMethod.POST)
	public String loginProcess(UserVo userVo) {
		
		if(userVo.getUserId().equals("brown") && userVo.getPass().equals("brownpass")) {
			return "main";
		}else {
			return "login/login";
		}
	}
	
	/**
	 * 
	* Method   : userAllList 
	* 작성자 : chan 
	* 변경이력 :  
	* @return  
	* Method 설명 : 사용자 전체 조회
	 */
	@RequestMapping(value="/userAllList")
	public String userAllList(Model model) {
		
		List<UserVo> userList= userService.getUserAll();
		
		model.addAttribute("userList", userList);
		
		return "/user/userAllList";
	}
	
	@RequestMapping(value="/userPageList")
	public String userPageList(Model model, PageVo pageVo) {
		
		//spring 컨테이너로 부터 bean을 주입받기 때문에 new 연산자를 통해서 생성할 필요 없음
		
		
//		PageVo pageVo = new PageVo() ;
//		pageVo.setPageSize(Integer.parseInt(request.getParameter("pageSize")));
//		pageVo.setPage(Integer.parseInt(request.getParameter("page")));
		
		//controller method 매개변수로 선언
		
//		Map<String, Object> resulMap = userService.selectUserPageList(pageVo);
//		// 페이지 리스트
//		List<UserVo> pageList = (List<UserVo>)resulMap.get("userList");
//		
//		// 페이지 건수
//		int pageCnt = (int) resulMap.get("pageCnt");
//						
//		// request 객체에 저장
//		request.setAttribute("pageList", pageList);
//		request.setAttribute("pageCnt", pageCnt);
		
		Map<String, Object> resulMap = userService.selectUserPageList(pageVo);
		model.addAllAttributes(resulMap);
		
		
		
		return "/user/userPageList";
	}
	
	
	@RequestMapping("/userDetail")
	public String userDetail(@RequestParam("userId")String userId, Model model) {
		
		//String userId = request.getParameter("userId");
		//@RequestParam("userId")String userId 으로 처리
		
		UserVo userVo = userService.selectUser(userId);
		
		model.addAttribute("userVo", userVo);
		
		return "/user/userDetail";
	}
	
	
	@RequestMapping(value="/userForm", method = RequestMethod.GET)
	public String userFormView() {
		return "user/userForm";
	}
	
	@RequestMapping(value="/userForm", method = RequestMethod.POST)
	public String userForm(@RequestPart("profilePic")MultipartFile part, 
			HttpServletRequest request, UserVo userVo) {
		
		try {
			if(part.getSize() > 0) {
				String path = request.getServletContext().getRealPath("/profile");
				String fileName = part.getOriginalFilename();
				userVo.setProfile("/profile/" + fileName);
				
				part.transferTo(new File(path + File.separator + fileName));
			}else {
				userVo.setProfile("");
			}
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		int insertCnt = userService.insertUser(userVo);
		// response.sendRedirect("/userPageList?page=1&pageSize=5");
		
		return "redirect:/user/userPageList?page=1&pageSize=10";
	}
	
	@RequestMapping(value="/userUpdate", method=RequestMethod.GET)
	public String userUpdateView(@RequestParam("userId")String userId, Model model){
		
		UserVo userVo = userService.selectUser(userId);
		model.addAttribute("userVo", userVo);
		
		return "/user/userUpdateForm";
	}
	
	@RequestMapping(value="/userUpdate", method=RequestMethod.POST)
	public String userUpdateForm(@RequestPart("profilePic")MultipartFile part, 
			HttpServletRequest request, UserVo userVo) {
		
		try {
			if(part.getSize() > 0) {
				String path = request.getServletContext().getRealPath("/profile");
				String fileName = part.getOriginalFilename();
				userVo.setProfile("/profile/" + fileName);
				
				part.transferTo(new File(path + File.separator + fileName));
			}else {
				userVo.setProfile("");
			}
			
		} catch (IllegalStateException | IOException e) {
			e.printStackTrace();
		}
		
		int updateCnt = userService.updateUser(userVo);
		
		return "redirect:/user/userDetail?userId="+userVo.getUserId();
	}

}

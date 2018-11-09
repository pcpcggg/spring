package kr.or.ddit.prod.web;

import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;

import kr.or.ddit.prod.service.ProdServiceInf;
import kr.or.ddit.prod.util.model.ProdVo;
import kr.or.ddit.user.service.UserServiceInf;
import kr.or.ddit.user.util.model.PageVo;
import kr.or.ddit.user.util.model.UserVo;

@RequestMapping("/prod")
@Controller
public class ProdController {
	
	//userService 스프링 주입
	@Resource(name="prodService")
	private ProdServiceInf prodService;
	
	@RequestMapping(value="/prodPageList")
	public String prodList(/*Model model, PageVo pageVo*/) {
		
		/*
		Map<String, Object> resulMap = prodService.prodList(pageVo);
		model.addAllAttributes(resulMap);
		*/
		return "/prod/prodPageList";
		
	}
	
	@RequestMapping("prodPageListAjax")
	public String prodPageListAjax(Model model, PageVo pageVo) {
		
		Map<String, Object> resulMap = prodService.prodList(pageVo);
		model.addAllAttributes(resulMap);
		
		return "jsonView";
	}
	
	@RequestMapping("prodListHtml")
	public String prodListHtml(Model model, PageVo pageVo) {
		
		Map<String, Object> resulMap = prodService.prodList(pageVo);
		model.addAllAttributes(resulMap);
		
		return "prod/pageListHtml";
	}
	
	@RequestMapping("prodPagenationHtml")
	public String prodPagenationHtml(Model model, PageVo pageVo) {
		
		Map<String, Object> resulMap = prodService.prodList(pageVo);
		model.addAllAttributes(resulMap);
		
		return "prod/pagenationHtml";
	}
	
	
	

	@RequestMapping("/prodDetail")
	public String prodDetail(@RequestParam("prodId")String prodId, Model model) {
		
		//String userId = request.getParameter("userId");
		//@RequestParam("userId")String userId 으로 처리
		
		ProdVo prodVo = prodService.selectProd(prodId);
		
		model.addAttribute("prodVo", prodVo);
		
		return "/prod/prodDetail";
	}
	
}

package kr.or.ddit.prod.service;

import java.util.Map;

import kr.or.ddit.prod.util.model.ProdVo;
import kr.or.ddit.user.util.model.PageVo;


public interface ProdServiceInf {

	Map<String, Object> prodList(PageVo page);
	int getProdCnt();
	ProdVo selectProd(ProdVo prodVo);
	ProdVo selectProd(String prodId);
}

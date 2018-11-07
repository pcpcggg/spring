package kr.or.ddit.prod.dao;

import java.util.List;

import kr.or.ddit.prod.util.model.ProdVo;
import kr.or.ddit.user.util.model.PageVo;

public interface ProdDaoInf {
	List<ProdVo> prodList(PageVo page);
	int getProdCnt();
	ProdVo selectProd(ProdVo prodVo);
	
	ProdVo selectProd(String prodId);
}

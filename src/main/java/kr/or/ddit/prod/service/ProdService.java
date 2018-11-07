package kr.or.ddit.prod.service;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.annotation.Resource;

import org.springframework.stereotype.Service;

import kr.or.ddit.prod.dao.ProdDaoInf;
import kr.or.ddit.prod.util.model.ProdVo;
import kr.or.ddit.user.util.model.PageVo;


@Service("prodService")
public class ProdService implements ProdServiceInf{
	
	@Resource(name="prodDao")
	private ProdDaoInf pd;
	
	
	@Override
	public Map<String, Object> prodList(PageVo page){
		// 페이지에 해당하는 유저 리스트 (1~10건 사이)
		List<ProdVo> prodList = pd.prodList(page);
		
		// 페이지 내비게이션을 위한 유저 리스트 조회
		int totalProdCnt = pd.getProdCnt();
		
		// 결과를 담는 map
		Map<String, Object> resultMap = new HashMap<String, Object>();
		resultMap.put("prodList", prodList);
		resultMap.put("pageCnt", (int)Math.ceil( (double)totalProdCnt / page.getPageSize()));
		
		return resultMap;
	}

	public int getProdCnt() {
		return pd.getProdCnt();
	}
	
	@Override
	public ProdVo selectProd(ProdVo prodVo) {
		return pd.selectProd(prodVo);
	}
	

	@Override
	public ProdVo selectProd(String prodId) {
		return pd.selectProd(prodId);
	}
}

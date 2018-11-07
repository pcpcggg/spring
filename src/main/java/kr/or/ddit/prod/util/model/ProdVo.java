package kr.or.ddit.prod.util.model;

import java.util.Date;

public class ProdVo {
	private String prod_id;
	private String prod_name;
	private String lprod_nm;
	private Date prod_insdate;
	private int rnum;
	
	public ProdVo() {
		super();

	}

	public ProdVo(String prod_id, String prod_name, String lprod_nm,
			Date prod_insdate, int rnum) {
		super();
		this.prod_id = prod_id;
		this.prod_name = prod_name;
		this.lprod_nm = lprod_nm;
		this.prod_insdate = prod_insdate;
		this.rnum = rnum;
	}
	
	
	
	public int getRnum() {
		return rnum;
	}

	public void setRnum(int rnum) {
		this.rnum = rnum;
	}

	public String getProd_id() {
		return prod_id;
	}
	public void setProd_id(String prod_id) {
		this.prod_id = prod_id;
	}
	public String getProd_name() {
		return prod_name;
	}
	public void setProd_name(String prod_name) {
		this.prod_name = prod_name;
	}
	public String getLprod_nm() {
		return lprod_nm;
	}
	public void setLprod_nm(String lprod_nm) {
		this.lprod_nm = lprod_nm;
	}
	public Date getProd_insdate() {
		return prod_insdate;
	}
	public void setProd_insdate(Date prod_insdate) {
		this.prod_insdate = prod_insdate;
	}
	
	
	
}

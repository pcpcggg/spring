package kr.or.ddit.file.model;

public class FileVo {
	private int id;
	private String file_name;
	private String org_file_name;
	private String file_path;
	private String file_ext;
	
	public FileVo() {
		super();
	}

	public int getId() {
		return id;
	}

	public void setId(int id) {
		this.id = id;
	}

	public String getFile_name() {
		return file_name;
	}

	public void setFile_name(String file_name) {
		this.file_name = file_name;
	}

	public String getOrg_file_name() {
		return org_file_name;
	}

	public void setOrg_file_name(String org_file_name) {
		this.org_file_name = org_file_name;
	}

	public String getFile_path() {
		return file_path;
	}

	public void setFile_path(String file_path) {
		this.file_path = file_path;
	}

	public String getFile_ext() {
		return file_ext;
	}

	public void setFile_ext(String file_ext) {
		this.file_ext = file_ext;
	}
	
	public FileVo(int id, String file_name, String org_file_name, String file_path, String file_ext) {
		super();
		this.id = id;
		this.file_name = file_name;
		this.org_file_name = org_file_name;
		this.file_path = file_path;
		this.file_ext = file_ext;
	}
	

}

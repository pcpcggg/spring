package kr.or.ddit.file.service;

import javax.annotation.Resource;

import org.springframework.stereotype.Repository;

import kr.or.ddit.file.dao.FileDaoInf;
import kr.or.ddit.file.model.FileVo;

@Repository
public class FileService implements FileServiceInf {
	
	@Resource(name="fileDao")
	FileDaoInf fileDao;
	
	public int insertFile(FileVo fileVo) {
		return fileDao.insertFile(fileVo);
	};
}

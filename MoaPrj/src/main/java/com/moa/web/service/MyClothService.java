package com.moa.web.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moa.web.dao.MyClothDao;
import com.moa.web.vo.Cloth;
import com.moa.web.vo.CntCloth;

@Service
public class MyClothService {

	@Autowired
	private MyClothDao clothDao;

	public List<Cloth> getClothList(String uid, String category, int page) {

		int size = 6;
		int offset = (page - 1) * size;

		return clothDao.getClothList(uid, category, offset, size);

	}

	public void delCloth(String id, String category) {

		clothDao.delCloth(id, category);
	}

	public void regClothList(String uid, String category, String img) {

		clothDao.regCloth(uid, category, img);
	}

	public CntCloth getCount(String uid) {
		
		return clothDao.getCount(uid);
	}

	public List<Cloth> getOuterList(String uid) {

		return clothDao.getOuterList(uid);
	}
	
	public List<Cloth> getTopList(String uid) {

		return clothDao.getTopList(uid);
	}
	
	public List<Cloth> getBottomList(String uid) {

		return clothDao.getBottomList(uid);
	}
	
	public List<Cloth> getShoeList(String uid) {

		return clothDao.getShoeList(uid);
	}
	
	public List<Cloth> getEtcList(String uid) {

		return clothDao.getEtcList(uid);
	}

}

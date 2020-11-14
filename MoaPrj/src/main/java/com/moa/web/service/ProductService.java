package com.moa.web.service;

import java.sql.SQLException;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.moa.web.dao.ProductDao;
import com.moa.web.vo.ProductView;

@Service
public class ProductService {

	@Autowired
	private ProductDao productDao;

	public List<ProductView> getProductList(int page, String mfr, String search, String cup)
			throws ClassNotFoundException, SQLException {

		page = (page - 1) * 16;

		return productDao.getProductList(page, mfr, search, cup);
	}

	public List<ProductView> getProductRank(int page, String mfr, String search, String cup)
			throws ClassNotFoundException, SQLException {
		return productDao.getProductRank(page, mfr, search, cup);
	}
}
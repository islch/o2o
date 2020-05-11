package com.imooc.myo2o.service.impl;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.imooc.myo2o.dao.ShopCategoryDao;
import com.imooc.myo2o.entity.ShopCategory;
import com.imooc.myo2o.service.ShopCategoryService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.web.multipart.MultipartFile;

import com.fasterxml.jackson.databind.JavaType;
import com.fasterxml.jackson.databind.ObjectMapper;

/**
 * @Description: 店鋪类别业务接口实现类
 *
 * @author isLch
 * @date 2018年5月27日
 */
@Service
public class ShopCategoryServiceImpl implements ShopCategoryService {

	@Autowired
	private ShopCategoryDao shopCategoryDao;

	private static Logger logger = LoggerFactory.getLogger(ShopCategoryServiceImpl.class);

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imooc.myo2o.service.ShopCategoryService#getShopCategoryList(com.imooc.myo2o.
	 * entity.ShopCategory)
	 */
	@Override
	public List<ShopCategory> getShopCategoryList(ShopCategory shopCategoryCondition) {
		// 定义接收对象
		List<ShopCategory> shopCategories = null;
		// 若不存在，则从数据库中取出数据
		shopCategories = shopCategoryDao.selectShopCategory(shopCategoryCondition);
		return shopCategories;
	}

}
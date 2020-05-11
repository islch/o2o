package com.imooc.myo2o.service.impl;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.imooc.myo2o.dao.ProductCategoryDao;
import com.imooc.myo2o.dao.ProductDao;
import com.imooc.myo2o.dto.ProductCategoryExecution;
import com.imooc.myo2o.entity.ProductCategory;
import com.imooc.myo2o.enums.OperationStatusEnum;
import com.imooc.myo2o.enums.ProductCategoryStateEnum;
import com.imooc.myo2o.exceptions.ProductCategoryOperationException;
import com.imooc.myo2o.service.ProductCategoryService;

/**
 * @Description: 店铺的商品类别业务接口实现
 *
 * @author: isLch
 * @date: 2018年9月21日
 */

@Service
public class ProductCategoryServiceImpl implements ProductCategoryService {

	@Autowired
	private ProductCategoryDao productCategoryDao;

	@Autowired
	private ProductDao productDao;

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imooc.myo2o.service.ProductCategoryService#getProductCategoryList(java.lang
	 * .Long)
	 */
	@Override
	public List<ProductCategory> getProductCategoryList(Long shopId) {
		return productCategoryDao.selectProductCategoryList(shopId);
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see
	 * com.imooc.myo2o.service.ProductCategoryService#batchAddProductCategory(java.
	 * util.List)
	 */
	@Override
	@Transactional
	public ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException {
		// 列表不为空
		if (productCategoryList != null && !productCategoryList.isEmpty()) {
			try {
				int effectedNum = productCategoryDao.batchInsertProductCategory(productCategoryList);
				if (effectedNum <= 0) {
					throw new ProductCategoryOperationException("");
				} else {
					return new ProductCategoryExecution(OperationStatusEnum.SUCCESS, productCategoryList, effectedNum);
				}
			} catch (Exception e) {
				throw new ProductCategoryOperationException(
						ProductCategoryStateEnum.EDIT_ERROR.getStateInfo() + e.getMessage());
			}
		} else {
			return new ProductCategoryExecution(ProductCategoryStateEnum.EMPETY_LIST);
		}
	}

	/*
	 * (non-Javadoc)
	 * 
	 * @see com.imooc.myo2o.service.ProductCategoryService#deleteProductCategory(long,
	 * long)
	 */
	@Override
	@Transactional
	public ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException {
		// 删除商品类别时将商品记录中的类别项置空
		try {
			int effectNum = productDao.updateProductCategoryToNull(productCategoryId);
			if (effectNum < 0) {
				throw new ProductCategoryOperationException(ProductCategoryStateEnum.EDIT_ERROR.getStateInfo());
			}
		} catch (ProductCategoryOperationException e) {
			throw new ProductCategoryOperationException("deleteProductCategory error" + e.getMessage());
		}

		// 删除商品类别
		try {
			int effectedNum = productCategoryDao.deleteProductCategory(productCategoryId, shopId);
			if (effectedNum <= 0) {
				throw new ProductCategoryOperationException(ProductCategoryStateEnum.DELETE_ERROR.getStateInfo());
			} else {
				return new ProductCategoryExecution(OperationStatusEnum.SUCCESS, null, effectedNum);
			}
		} catch (Exception e) {
			throw new ProductCategoryOperationException("deleteProductCategory error" + e.getMessage());
		}
	}

}

/**
 * 
 */
package com.imooc.myo2o.service;

import java.util.List;

import com.imooc.myo2o.dto.ProductCategoryExecution;
import com.imooc.myo2o.entity.ProductCategory;
import com.imooc.myo2o.exceptions.ProductCategoryOperationException;

/**
 * @Description: 店铺的商品类别业务接口
 *
 * @author: isLch
 * @date: 2018年9月21日
 */

public interface ProductCategoryService {

	/**
	 * 查询指定某个店铺下的所有商品列表信息
	 * 
	 * @param shopId
	 * @return
	 */
	List<ProductCategory> getProductCategoryList(Long shopId);

	/**
	 * 批量添加商品类别
	 * 
	 * @param productCategoryList
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution batchAddProductCategory(List<ProductCategory> productCategoryList)
			throws ProductCategoryOperationException;

	/**
	 * 将此类别下的商品里的类别id置空，再删除该商品类别
	 * 
	 * @param productCategoryId
	 * @param shopId
	 * @return
	 * @throws ProductCategoryOperationException
	 */
	ProductCategoryExecution deleteProductCategory(long productCategoryId, long shopId)
			throws ProductCategoryOperationException;
}

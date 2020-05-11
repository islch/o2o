package com.imooc.myo2o.exceptions;

/**
 * @Description: 商品类别操作异常
 *
 * @author: isLch
 * @date: 2018年9月22日
 */
public class ProductCategoryOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductCategoryOperationException(String msg) {
		super(msg);
	}
}

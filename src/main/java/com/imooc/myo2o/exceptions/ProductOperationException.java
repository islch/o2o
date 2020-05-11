package com.imooc.myo2o.exceptions;

/**
 * @Description: 商品操作异常
 *
 * @author: isLch
 * @date: 2018年10月27日
 */
public class ProductOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ProductOperationException(String msg) {
		super(msg);
	}
}

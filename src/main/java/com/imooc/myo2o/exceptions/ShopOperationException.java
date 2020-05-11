package com.imooc.myo2o.exceptions;

/**
 * @Description: 店铺操作异常
 *
 * @author isLch
 * @date 2018年4月15日
 */
public class ShopOperationException extends RuntimeException {

	private static final long serialVersionUID = 1L;

	public ShopOperationException(String msg) {
		super(msg);
	}
}

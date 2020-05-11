package com.imooc.myo2o.service;

import java.util.List;

import com.imooc.myo2o.entity.Area;

/**
 * @Description: 区域业务接口
 *
 * @author isLch
 * @date 2018年3月24日
 */
public interface AreaService {
	public final static String AREA_LIST_KEY = "arealist";

	/**
	 * 获取区域列表,将区域信息放入缓存中
	 * 
	 * @return
	 */
	List<Area> getAreaList();

}

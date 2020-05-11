package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.Area;

import java.util.List;

public interface AreaDao {
	/**
	 * 查询区域信息
	 * 
	 * @return
	 */
	List<Area> selectArea();

}

package com.imooc.myo2o.service.impl;

import java.io.IOException;
import java.util.List;

import com.imooc.myo2o.entity.Area;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imooc.myo2o.dao.AreaDao;
import com.imooc.myo2o.service.AreaService;

@Service
public class AreaServiceImpl implements AreaService {

	@Autowired
	private AreaDao areaDao;


	@Override
	public List<Area> getAreaList() {
		return areaDao.selectArea();
	}


}

package com.imooc.myo2o.dao;

import static org.junit.Assert.assertEquals;

import com.imooc.myo2o.BaseTest;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import com.imooc.myo2o.entity.Area;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class AreaDaoTest extends BaseTest {
	@Autowired
	private AreaDao areaDao;

	@Test
	public void testQueryArea() {
		List<Area> areaList = areaDao.selectArea();
		System.out.println("dao测试：" + areaList.toString());
	}
}

package com.imooc.myo2o.dao;

import static org.junit.Assert.assertEquals;

import java.util.Date;
import java.util.List;

import com.imooc.myo2o.entity.Area;
import com.imooc.myo2o.entity.PersonInfo;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.entity.ShopCategory;
import com.imooc.myo2o.enums.EnableStatusEnum;
import org.junit.FixMethodOrder;
import org.junit.Test;
import org.junit.runners.MethodSorters;
import org.springframework.beans.factory.annotation.Autowired;

import com.imooc.myo2o.BaseTest;

@FixMethodOrder(MethodSorters.NAME_ASCENDING)
public class ShopDaoTest extends BaseTest {
	@Autowired
	private ShopDao shopDao;



    @Test
    public void testAInsertShop() throws Exception {
        Shop shop = new Shop();
        PersonInfo owner = new PersonInfo();
        ShopCategory shopCategory = new ShopCategory();
        Area area = new Area();
        owner.setUserId(1L);
        area.setAreaId(1);
        shopCategory.setShopCategoryId(1L);
        shop.setOwner(owner);
        shop.setShopCategory(shopCategory);
        shop.setArea(area);
        shop.setShopAddr("test");
        shop.setShopName("test店铺");
        shop.setShopDesc("test");
        shop.setShopImg("test");
        shop.setPhone("test");
        shop.setPriority(1);
        shop.setCreateTime(new Date());
        shop.setEnableStatus(EnableStatusEnum.AVAILABLE.getState());
        shop.setAdvice("审核中");
        int effectNum = shopDao.insertShop(shop);
        System.out.println("effectNum：" + effectNum);
    }


	@Test
	public void testUpdateShop() {
		Shop shop = new Shop();
		shop.setShopId(1L);
		shop.setShopAddr("test@111");
		shop.setShopName("@test@111");
		shop.setShopDesc("test111");
		shop.setShopImg("test111");
		shop.setPhone("test111");
		shop.setLastEditTime(new Date());
		int effectNum = shopDao.updateShop(shop);
		System.out.println("effectNum：" + effectNum);
	}

    @Test
    public void testQueryShop() {
        Shop shop = shopDao.selectByShopId(1);
        System.out.println("areaName:" + shop.getArea().getAreaName());
        System.out.println("shopCategoryName:" + shop.getShopCategory().getShopCategoryName());

        //这里是null
        //System.out.println(shop.getShopCategory().getCreateTime());

        //查询语句没有关联personInfo，所以是空指针
        // System.out.println(shop.getOwner().toString());
    }

    @Test
    public void testQueryShopList() {
        Shop shopCondition = new Shop();
        ShopCategory childCategory = new ShopCategory();
        ShopCategory parentCategory = new ShopCategory();
        parentCategory.setShopCategoryId(1L);
        childCategory.setParent(parentCategory);
        shopCondition.setShopCategory(childCategory);
        List<Shop> shopList = shopDao.selectShopList(shopCondition, 0, 3);
        System.out.println("查询店铺列表的大小：" + shopList.size());
        int shopCount = shopDao.selectShopCount(shopCondition);
        System.out.println("店铺列表总数大小：" + shopCount);
    }
}

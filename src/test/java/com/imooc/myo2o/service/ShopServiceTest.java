package com.imooc.myo2o.service;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Date;

import com.imooc.myo2o.BaseTest;
import com.imooc.myo2o.dto.ShopExecution;
import com.imooc.myo2o.entity.Area;
import com.imooc.myo2o.entity.PersonInfo;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.entity.ShopCategory;
import org.apache.commons.io.IOUtils;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.mock.web.MockMultipartFile;
import org.springframework.web.multipart.MultipartFile;

/**
 * @Description: 店铺业务测试
 *
 * @author isLch
 * @date 2018年4月15日
 */
public class ShopServiceTest extends BaseTest {

	@Autowired
	private ShopService shopService;

	@Test
	public void testModifyShop() throws IOException {
		Shop shop = new Shop();
		shop.setShopId(29L);
		shop.setShopName("修改店铺测试");
		String filePath = "D:\\皮皮猪\\180411.gif";
		shopService.modifyShop(shop, path2MultipartFile(filePath));
		System.out.println("修改后图片：" + shop.getShopImg());
	}

	@Test
	public void testAddShop() throws IOException {
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
		shop.setShopAddr("testService");
		shop.setShopName("test店铺Service2");
		shop.setShopDesc("testService");
		shop.setShopImg("testService");
		shop.setPhone("testService");
		shop.setPriority(1);
		shop.setCreateTime(new Date());
		shop.setAdvice("审核中");
		String filePath = "D:\\islch\\test.jpg";
		ShopExecution se = shopService.addShop(shop, path2MultipartFile(filePath));
		System.out.println("ShopExecution.state" + se.getState());
		System.out.println("ShopExecution.stateInfo" + se.getStateInfo());
	}

	/**
	 * filePath to MultipartFile
	 * 
	 * @param filePath
	 * @throws IOException
	 */
	private MultipartFile path2MultipartFile(String filePath) throws IOException {
		File file = new File(filePath);
		FileInputStream input = new FileInputStream(file);
		MultipartFile multipartFile = new MockMultipartFile("file", file.getName(), "text/plain",
				IOUtils.toByteArray(input));
		return multipartFile;
	}




	@Test
	public void testGetShopList() {
		Shop shopCondition = new Shop();
		PersonInfo personInfo = new PersonInfo();
		personInfo.setUserId(1L);

		shopCondition.setOwner(personInfo);
		//shopCondition.setShopName("畅仔");

		ShopExecution se = shopService.getShopList(shopCondition, 2, 2);
		System.out.println("查询得到店铺数：" + se.getShopList().size());
		System.out.println("店铺总数：" + se.getCount());
		se = shopService.getShopList(shopCondition, 2, 2);
		System.out.println("查询得到店铺数：" + se.getShopList().size());
		System.out.println("店铺总数：" + se.getCount());
	}
}

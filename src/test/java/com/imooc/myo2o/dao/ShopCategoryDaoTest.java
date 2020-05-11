package com.imooc.myo2o.dao;

import java.util.Date;
import java.util.List;

import com.imooc.myo2o.BaseTest;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.entity.ShopCategory;
import com.imooc.myo2o.util.ImageUtil;
import com.imooc.myo2o.util.PathUtil;
import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;


/**
 * @Description: 店铺类别测试
 *
 * @author isLch
 * @date 2018年5月27日
 */
public class ShopCategoryDaoTest extends BaseTest {

	@Autowired
	private ShopCategoryDao shopCategoryDao;

	@Test
	public void testInsertShopCategory() throws Exception {
		ShopCategory shopCategory = new ShopCategory();
		shopCategory.setCreateTime(new Date());
		shopCategory.setPriority(4);
		shopCategory.setShopCategoryName("外套");
		shopCategory.setShopCategoryDesc("男装");
		String filePath = "D:\\islch\\test.jpg";
		MultipartFile multipartFile = ImageUtil.path2MultipartFile(filePath);
		String dest = PathUtil.getShopCategoryImagePath();
		String generateHeadImg = ImageUtil.generateShopCategoryImg(multipartFile, dest);
		shopCategory.setShopCategoryImg(generateHeadImg);
		ShopCategory parentShopCategory = new ShopCategory();
		parentShopCategory.setShopCategoryId(1L);
		shopCategory.setParent(parentShopCategory);
		int effectNum = shopCategoryDao.insertShopCategory(shopCategory);
		System.out.println("effectNum:" + effectNum);
	}

	@Test
	public void testModifyShopCategory() throws Exception {
		ShopCategory currShopCategory = new ShopCategory();
		currShopCategory.setLastEditTime(new Date());
		currShopCategory.setShopCategoryId(10L);
		// 删除原有图片
		ShopCategory origShopCategory = shopCategoryDao.selectShopCategoryById(10L);
		ImageUtil.deleteFileOrPath(origShopCategory.getShopCategoryImg());
		currShopCategory.setPriority(4);
		currShopCategory.setShopCategoryName("短袖");
		currShopCategory.setShopCategoryDesc("男装");
		String filePath = "D:\\eclipse\\pic\\短袖.jpg";
		MultipartFile multipartFile = ImageUtil.path2MultipartFile(filePath);
		String dest = PathUtil.getShopCategoryImagePath();
		String generateHeadImg = ImageUtil.generateShopCategoryImg(multipartFile, dest);
		currShopCategory.setShopCategoryImg(generateHeadImg);
		ShopCategory parentShopCategory = new ShopCategory();
		parentShopCategory.setShopCategoryId(4L);
		currShopCategory.setParent(parentShopCategory);
		int effectNum = shopCategoryDao.updateShopCategory(currShopCategory);
		System.out.println("effectNum:" + effectNum);
	}

	@Test
	public void testQueryShopCategory() {
		List<ShopCategory> shopCategoryList = shopCategoryDao.selectShopCategory(new ShopCategory());
		System.out.println(shopCategoryList.size());
		ShopCategory testCategory = new ShopCategory();
		ShopCategory parentCategory = new ShopCategory();
		parentCategory.setShopCategoryId(1L);
		testCategory.setParent(parentCategory);
		shopCategoryList = shopCategoryDao.selectShopCategory(testCategory);
		System.out.println(shopCategoryList.get(0).getShopCategoryName());
	}

	@Test
	public void testQueryShopCategory2() {
		//List<ShopCategory> shopCategoryList = shopCategoryDao.selectShopCategory(new ShopCategory());
		List<ShopCategory> shopCategoryList = shopCategoryDao.selectShopCategory(null);
		System.out.println("shopCategoryList.size():" + shopCategoryList.size());
	}
}

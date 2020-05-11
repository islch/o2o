package com.imooc.myo2o.service;

import java.io.IOException;
import java.util.ArrayList;
import java.util.Date;
import java.util.List;

import org.junit.Ignore;
import org.junit.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.multipart.MultipartFile;

import com.imooc.myo2o.BaseTest;
import com.imooc.myo2o.dto.ProductExecution;
import com.imooc.myo2o.entity.Product;
import com.imooc.myo2o.entity.ProductCategory;
import com.imooc.myo2o.entity.Shop;
import com.imooc.myo2o.enums.EnableStatusEnum;
import com.imooc.myo2o.util.ImageUtil;

/**
 * 
 * @Description: 商品业务测试
 *
 * @author: tyron
 * @date: 2018年11月11日
 */
public class ProductServiceTest extends BaseTest {

	@Autowired
	private ProductService productService;

	@Test
	public void testAddShop() throws IOException {
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(1L);
		product.setShop(shop);
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryId(1L);
		product.setProductCategory(productCategory);
		product.setProductName("测试商品1");
		product.setProductDesc("测试商品1描述");
		product.setPriority(11);
		product.setEnableStatus(EnableStatusEnum.AVAILABLE.getState());
		product.setLastEditTime(new Date());
		product.setCreateTime(new Date());
		String filePath0 = "D:\\islch\\test1.gif";
		List<MultipartFile> productImgList = new ArrayList<>();
		String filePath1 = "D:\\islch\\test2.gif";
		MultipartFile productImg1 = ImageUtil.path2MultipartFile(filePath1);
		productImgList.add(productImg1);
		String filePath2 = "D:\\islch\\test3.gif";
		MultipartFile productImg2 = ImageUtil.path2MultipartFile(filePath2);
		productImgList.add(productImg2);
		ProductExecution se = productService.addProduct(product, ImageUtil.path2MultipartFile(filePath0),
				productImgList);
		System.out.println("ProductExecution.state" + se.getState());
		System.out.println("ProductExecution.stateInfo" + se.getStateInfo());
	}

	@Test
	public void testModifyShop() throws IOException {
		Product product = new Product();
		Shop shop = new Shop();
		shop.setShopId(1L);
		product.setShop(shop);
		ProductCategory productCategory = new ProductCategory();
		productCategory.setProductCategoryId(2L);
		product.setProductId(3L);
		product.setProductCategory(productCategory);
		product.setProductName("测试商品2");
		product.setProductDesc("测试商品2描述");
		product.setPriority(22);
		product.setEnableStatus(EnableStatusEnum.AVAILABLE.getState());
		product.setLastEditTime(new Date());
		product.setCreateTime(new Date());
		String filePath0 = "D:\\eclipse\\pic\\1.JPG";
		List<MultipartFile> productImgList = new ArrayList<>();
		String filePath1 = "D:\\eclipse\\pic\\2.JPG";
		MultipartFile productImg1 = ImageUtil.path2MultipartFile(filePath1);
		productImgList.add(productImg1);
		String filePath2 = "D:\\eclipse\\pic\\3.JPG";
		MultipartFile productImg2 = ImageUtil.path2MultipartFile(filePath2);
		productImgList.add(productImg2);
		ProductExecution se = productService.modifyProduct(product, ImageUtil.path2MultipartFile(filePath0),
				productImgList);
		System.out.println("ProductExecution.state" + se.getState());
		System.out.println("ProductExecution.stateInfo" + se.getStateInfo());
	}
}

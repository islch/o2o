package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.Shop;
import org.apache.ibatis.annotations.Param;

import java.util.List;

public interface ShopDao {
    /**
     * 新增店铺
     *
     * @param shop
     * @return effectedNum
     */

    int insertShop(Shop shop);
    /**
     * 更新店铺
     *
     * @param shop
     * @return
     */
    int updateShop(Shop shop);

    /**
     * 根据shopId查询shop
     *
     * @param shopId
     * @return
     */
    Shop selectByShopId(long shopId);

    /**
     *
     * 带有分页功能的查询商铺列表 。 可输入的查询条件：商铺名（要求模糊查询） 区域Id 商铺状态 商铺类别 owner
     * (注意在sqlmapper中按照前端入参拼装不同的查询语句)
     *
     * @param shopCondition
     * @param rowIndex：从第几行开始取
     * @param pageSize：返回多少行数据（页面上的数据量）
     *            比如 rowIndex为1,pageSize为5 即为 从第一行开始取，取5行数据
     * @return
     */
    List<Shop> selectShopList(@Param("shopCondition") Shop shopCondition, @Param("rowIndex") int rowIndex,
                              @Param("pageSize") int pageSize);

    /**
     * 按照条件查询 符合前台传入的条件的商铺的总数
     *
     * @param shopCondition
     * @return
     */
    int selectShopCount(@Param("shopCondition") Shop shopCondition);
}

package com.imooc.myo2o.dao;

import com.imooc.myo2o.entity.Shop;

public interface ShopDao {
    /**
     * 新增店铺
     *
     * @param shop
     * @return effectedNum
     */

    int insertShop(Shop shop);


}

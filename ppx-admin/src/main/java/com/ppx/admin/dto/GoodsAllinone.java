package com.ppx.admin.dto;

import com.ppx.ppxlitemalldb.domain.LitemallGoods;
import com.ppx.ppxlitemalldb.domain.LitemallGoodsAttribute;
import com.ppx.ppxlitemalldb.domain.LitemallGoodsProduct;
import com.ppx.ppxlitemalldb.domain.LitemallGoodsSpecification;

public class GoodsAllinone {
    LitemallGoods goods;
    LitemallGoodsSpecification[] specifications;
    LitemallGoodsAttribute[] attributes;
    LitemallGoodsProduct[] products;

    public LitemallGoods getGoods() {
        return goods;
    }

    public void setGoods(LitemallGoods goods) {
        this.goods = goods;
    }

    public LitemallGoodsProduct[] getProducts() {
        return products;
    }

    public void setProducts(LitemallGoodsProduct[] products) {
        this.products = products;
    }

    public LitemallGoodsSpecification[] getSpecifications() {
        return specifications;
    }

    public void setSpecifications(LitemallGoodsSpecification[] specifications) {
        this.specifications = specifications;
    }

    public LitemallGoodsAttribute[] getAttributes() {
        return attributes;
    }

    public void setAttributes(LitemallGoodsAttribute[] attributes) {
        this.attributes = attributes;
    }

}

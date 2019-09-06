package com.ppx.ppxlitemalldb.dao;

import org.apache.ibatis.annotations.Param;
import com.ppx.ppxlitemalldb.domain.LitemallOrderGoods;
import com.ppx.ppxlitemalldb.domain.LitemallOrderGoodsExample;

import java.util.List;

public interface LitemallOrderGoodsMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    long countByExample(LitemallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    int insert(LitemallOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    int insertSelective(LitemallOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    LitemallOrderGoods selectOneByExample(LitemallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    LitemallOrderGoods selectOneByExampleSelective(@Param("example") LitemallOrderGoodsExample example, @Param("selective") LitemallOrderGoods.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    List<LitemallOrderGoods> selectByExampleSelective(@Param("example") LitemallOrderGoodsExample example, @Param("selective") LitemallOrderGoods.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    List<LitemallOrderGoods> selectByExample(LitemallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    LitemallOrderGoods selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallOrderGoods.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    LitemallOrderGoods selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    LitemallOrderGoods selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallOrderGoods record, @Param("example") LitemallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallOrderGoods record, @Param("example") LitemallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallOrderGoods record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LitemallOrderGoodsExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_order_goods
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}
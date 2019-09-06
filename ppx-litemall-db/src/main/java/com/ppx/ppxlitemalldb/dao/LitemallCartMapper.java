package com.ppx.ppxlitemalldb.dao;

import org.apache.ibatis.annotations.Param;
import com.ppx.ppxlitemalldb.domain.LitemallCart;
import com.ppx.ppxlitemalldb.domain.LitemallCartExample;

import java.util.List;

public interface LitemallCartMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    long countByExample(LitemallCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    int insert(LitemallCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    int insertSelective(LitemallCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    LitemallCart selectOneByExample(LitemallCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    LitemallCart selectOneByExampleSelective(@Param("example") LitemallCartExample example, @Param("selective") LitemallCart.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    List<LitemallCart> selectByExampleSelective(@Param("example") LitemallCartExample example, @Param("selective") LitemallCart.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    List<LitemallCart> selectByExample(LitemallCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    LitemallCart selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallCart.Column... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    LitemallCart selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    LitemallCart selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallCart record, @Param("example") LitemallCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallCart record, @Param("example") LitemallCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallCart record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    int logicalDeleteByExample(@Param("example") LitemallCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     */
    int logicalDeleteByPrimaryKey(Integer id);
}
package com.ppx.ppxwxapp.db.dao;

import com.ppx.ppxwxapp.db.domain.LitemallCart;
import com.ppx.ppxwxapp.db.domain.LitemallCartExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

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
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallCart selectOneByExample(LitemallCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallCart selectOneByExampleSelective(@Param("example") LitemallCartExample example, @Param("selective") LitemallCart.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<LitemallCart> selectByExampleSelective(@Param("example") LitemallCartExample example, @Param("selective") LitemallCart.Column ... selective);

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
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallCart selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallCart.Column ... selective);

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
     * @project https://github.com/itfsw/mybatis-generator-plugin
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
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") LitemallCartExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_cart
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}
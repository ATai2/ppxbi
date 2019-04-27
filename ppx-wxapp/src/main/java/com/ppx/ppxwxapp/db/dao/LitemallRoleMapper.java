package com.ppx.ppxwxapp.db.dao;

import com.ppx.ppxwxapp.db.domain.LitemallRole;
import com.ppx.ppxwxapp.db.domain.LitemallRoleExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface LitemallRoleMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     */
    long countByExample(LitemallRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     */
    int deleteByExample(LitemallRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     */
    int insert(LitemallRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     */
    int insertSelective(LitemallRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallRole selectOneByExample(LitemallRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallRole selectOneByExampleSelective(@Param("example") LitemallRoleExample example, @Param("selective") LitemallRole.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    List<LitemallRole> selectByExampleSelective(@Param("example") LitemallRoleExample example, @Param("selective") LitemallRole.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     */
    List<LitemallRole> selectByExample(LitemallRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallRole selectByPrimaryKeySelective(@Param("id") Integer id, @Param("selective") LitemallRole.Column ... selective);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     */
    LitemallRole selectByPrimaryKey(Integer id);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    LitemallRole selectByPrimaryKeyWithLogicalDelete(@Param("id") Integer id, @Param("andLogicalDeleted") boolean andLogicalDeleted);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     */
    int updateByExampleSelective(@Param("record") LitemallRole record, @Param("example") LitemallRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     */
    int updateByExample(@Param("record") LitemallRole record, @Param("example") LitemallRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKeySelective(LitemallRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(LitemallRole record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByExample(@Param("example") LitemallRoleExample example);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table litemall_role
     *
     * @mbg.generated
     * @project https://github.com/itfsw/mybatis-generator-plugin
     */
    int logicalDeleteByPrimaryKey(Integer id);
}
package net.sealin.test.distribtx.dao;

import java.util.List;
import net.sealin.test.distribtx.entity.TabUser;
import org.apache.ibatis.annotations.Param;

public interface TabUserMapper {
    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbg.generated
     */
    int deleteByPrimaryKey(@Param("id") Integer id, @Param("name") String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbg.generated
     */
    int insert(TabUser record);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbg.generated
     */
    TabUser selectByPrimaryKey(@Param("id") Integer id, @Param("name") String name);

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbg.generated
     */
    List<TabUser> selectAll();

    /**
     * This method was generated by MyBatis Generator.
     * This method corresponds to the database table tab_user
     *
     * @mbg.generated
     */
    int updateByPrimaryKey(TabUser record);
}
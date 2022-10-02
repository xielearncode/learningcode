package com.ibm.learning.dao;

import com.ibm.learning.entity.Brand;
import org.apache.ibatis.annotations.*;

import java.util.List;

/**
 * @Author 谢飞
 * @Date 2022/9/29 18:58
 */
public interface BrandMapper {

    @Select("select * from tb_brand")
    @ResultMap("brandResultMap")
    List<Brand> selectAll();

    @Insert("insert into tb_brand values (null,#{brandName},#{companyName},#{ordered},#{description},#{status})")
    @ResultMap("brandResultMap")
    void add(Brand brand);

    @Select("select * from tb_brand where id = #{id}")
    @ResultMap("brandResultMap")
    Brand selectById(int id);

    @Update("update tb_brand set brand_name = #{brandName}, company_name = #{companyName},ordered = #{ordered},status = #{status} where id = #{id}")
    @ResultMap("brandResultMap")
    void update(Brand brand);

    @Update("delete from tb_brand where id = #{id}")
    void deleteById(int id);
}

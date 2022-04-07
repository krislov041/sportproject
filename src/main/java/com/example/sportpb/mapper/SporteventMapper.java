package com.example.sportpb.mapper;

import com.example.sportpb.entity.Sportevent;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;
@Component
//数据库查询接口 专门用来和数据库进行交互
@Mapper
//@Mapper实现把SporteventMapper这个bean注入springboot
public interface SporteventMapper {
    /**
     *
     * 显示所有表数据 返回一个List
     * @Select select语句查询表
     * */
    @Select("select * from sportevent")
    List<Sportevent> findAll();

    @Insert("insert into sportevent(s_Name,s_Time,s_Result)VALUES(#{s_Name},#{s_Time},#{s_Result})")
    int insert(Sportevent sportevent);

    int update(Sportevent sportevent);

    @Delete("delete from sportevent where s_id=#{s_id}")
    Integer deleteById(@Param("s_id") Integer s_id);

    @Select("SELECT * from sportevent where s_Name =#{s_Name}")
    List<Sportevent> selectName(String s_Name);

    @Select("SELECT * from sportevent limit #{pageNum},#{pageSize}")
    List<Sportevent> selectPage(Integer pageNum,Integer pageSize);

    @Select("select count(*) from sportevent")
    Integer selectTotal();
}

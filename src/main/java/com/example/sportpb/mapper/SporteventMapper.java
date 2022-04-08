package com.example.sportpb.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import com.example.sportpb.entity.Sportevent;
import org.apache.ibatis.annotations.*;
import org.springframework.stereotype.Component;

import java.sql.ResultSet;
import java.util.List;
@Component
//数据库查询接口 专门用来和数据库进行交互
//@Mapper
//@Mapper实现把SporteventMapper这个bean注入springboot
public interface SporteventMapper extends BaseMapper<Sportevent> {

    /**
     * 显示所有表数据 返回一个List
     * @Select select语句查询表
     * */
    @Select("select * from sportevent")
    List<Sportevent> findAll();

    @Insert("insert into sportevent(s_Name,s_Time,s_Result)" +
            "VALUES(#{sName},#{sTime},#{sResult})")
    int insert(Sportevent sportevent);

    int update(Sportevent sportevent);

    @Delete("delete from sportevent where s_id=#{s_id}")
    Integer deleteById(@Param("s_id") Integer s_id);

    @Select("SELECT * from sportevent where s_Name =#{s_Name}")
    List<Sportevent> selectName(String s_Name);

//    @Select("SELECT * from sportevent limit #{pageNum},#{pageSize}") 这个需要注释掉，如果不注释掉的话，Service执行selectPage的时候会跳转到这个函数上导致报错
//    List<Sportevent> selectPage(Integer pageNum,Integer pageSize);

    @Select("select count(*) from sportevent")
    Integer selectTotal();
}

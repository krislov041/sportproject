package com.example.sportpb.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.example.sportpb.entity.Sportevent;
import com.example.sportpb.mapper.SporteventMapper;
import com.example.sportpb.service.SporteventService;
import com.mysql.cj.xdevapi.JsonArray;
import lombok.extern.java.Log;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import java.sql.ResultSet;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

@RestController
//标识 SporteventController 是一个接口
@RequestMapping("/sportevent")
//统一给接口加前缀
public class SporteventController {


    /**
     * @Autowired 注入其他类的一个注解
     * 使得mapper接口类可以被springboot识别到
     */
//    @Autowired
//    private SporteventMapper sporteventMapper;

    @Autowired
    private SporteventService sporteventService;


    /**
     * service save实现新增和更新功能
     * */
    @PostMapping("/save")//post请求进行增删
    public boolean save(@RequestBody Sportevent sportevent){
    //@RequestBody  前台传入一个json对象的时候可以把 json 映射成sportevent
//        return sporteventService.save(sportevent);mybatis写法
          return sporteventService.savese(sportevent);//mybatis-plus

    }
    /**
     * 获取列表所有数据
     * */
    @GetMapping("/all")
//  查询接收数据，依赖于 @RestController RequestMapping 的url和 GETmapping url的拼接得到最后的url
    public List<Sportevent> findAll() {

//      return sporteventMapper.findAll();mybatis写法
        return sporteventService.list();//mybatis-plus

    }
    /**根据id删除数据
     * */
    @DeleteMapping("/{s_id}")
    public boolean delete(@PathVariable Integer s_id){//@PathVariable  表示url参数

//        return sporteventMapper.deleteById(s_id);mybatis写法
        return sporteventService.removeById(s_id);//mybatis-plus

    }
    /**
     * 根据名字查询对应表数据*/
//    @GetMapping("/name")
//    public List<Sportevent> findName(@RequestParam String s_Name){
//        return sporteventMapper.selectName(s_Name);
////        return sporteventService.getObj()
//    }

    /**分页查询接口
     * 接口路径 /sportevent/page
     * @ReqyestParam 接受pageNum&pageSize
     * 分页查询重点
     * 确定 select * from table limit begin,num 中每页的起始位置 begin
     * begin=（pageNum-1）*pageSize
     */

    /**
    public Map<String,Object> findPage(@RequestParam Integer pageNum,@RequestParam Integer pageSize){
        pageNum=(pageNum-1)*pageSize;
        List<Sportevent> data=sporteventMapper.selectPage(pageNum,pageSize);
        Integer total=sporteventMapper.selectTotal();
        Map<String,Object> res=new HashMap<>();
        res.put("data",data);
        res.put("total",total);
        return res;

    }*/
    /**
     * 分页查询mybatis-plus实现
     * */
    @GetMapping("/page")
    public IPage<Sportevent> findPageQuery(@RequestParam Integer pageNum, @RequestParam Integer pageSize,@RequestParam(defaultValue = "") String sName){
        IPage page = new Page<>(pageNum,pageSize);
        QueryWrapper<Sportevent> queryWrapper = new QueryWrapper<>();
        queryWrapper.like("s_Name",sName);
        IPage<Sportevent> sporteventIPage=sporteventService.page(page,queryWrapper);
        return sporteventIPage;
    }
//    @GetMapping("/page")
//    public IPage<Sportevent> findPage(@RequestParam Integer pageNum, @RequestParam Integer pageSize){
//        IPage page = new Page<>(pageNum,pageSize);
////        QueryWrapper<Sportevent> queryWrapper = new QueryWrapper<>();
////        queryWrapper.like("s_Name",sName);
//        IPage<Sportevent> sporteventIPage=sporteventService.page(page);
//        return sporteventIPage;
//    }



}

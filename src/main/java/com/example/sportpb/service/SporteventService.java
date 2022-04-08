package com.example.sportpb.service;

import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import com.example.sportpb.entity.Sportevent;
import com.example.sportpb.mapper.SporteventMapper;
import jdk.jfr.Threshold;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

@Service
//把这个类注入springboot容器
public class SporteventService extends ServiceImpl<SporteventMapper, Sportevent> {
    public boolean savese(Sportevent sportevent) {
        return saveOrUpdate(sportevent);
    }


    /***
     * mybatis 版本实现
     * @param sportevent
     * @return
     * @Autowired
     * private SporteventMapper sporteventMapper;
     * public int save(Sportevent sportevent){
            if(sportevent.getSId() == null){ //数据表中无此id，新增数据
                sporteventMapper.insert(sportevent);
            }else{ //否则进行更新
                sporteventMapper.update(sportevent);
            }
            return 1;
        }
     */


}


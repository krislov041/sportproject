package com.example.sportpb.entity;
//实体定义
import lombok.Data;

@Data
//用来代替getset方法的,简化代码

public class Sportevent {
    private Integer s_id;
    private String s_Name;
    private String s_Time;
    private String s_Result;

}

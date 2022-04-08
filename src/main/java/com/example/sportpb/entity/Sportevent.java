package com.example.sportpb.entity;
//实体定义
import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;
import com.baomidou.mybatisplus.annotation.TableName;
import lombok.Data;

@Data
//用来代替getset方法的,简化代码
@TableName(value = "sportevent")
//指定表格名
public class Sportevent {
    @TableId
    private Integer sId;
    private String sName;
    private String sTime;
    @TableField(value = "s_Result")//这样写就可以不用限定列名和实体名  也可以限定不用驼峰规则
    private String sResult;

}

package com.bby.ants.dao;

import com.bby.ants.entity.Component;
import com.bby.ants.entity.ComponentExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface ComponentMapper {
    int countByExample(ComponentExample example);

    int deleteByExample(ComponentExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Component record);

    int insertSelective(Component record);

    List<Component> selectByExample(ComponentExample example);

    Component selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Component record, @Param("example") ComponentExample example);

    int updateByExample(@Param("record") Component record, @Param("example") ComponentExample example);

    int updateByPrimaryKeySelective(Component record);

    int updateByPrimaryKey(Component record);
}
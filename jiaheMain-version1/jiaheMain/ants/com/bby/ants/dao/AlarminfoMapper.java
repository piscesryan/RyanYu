package com.bby.ants.dao;

import com.bby.ants.entity.Alarminfo;
import com.bby.ants.entity.AlarminfoExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AlarminfoMapper {
    int countByExample(AlarminfoExample example);

    int deleteByExample(AlarminfoExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Alarminfo record);

    int insertSelective(Alarminfo record);

    List<Alarminfo> selectByExample(AlarminfoExample example);

    Alarminfo selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Alarminfo record, @Param("example") AlarminfoExample example);

    int updateByExample(@Param("record") Alarminfo record, @Param("example") AlarminfoExample example);

    int updateByPrimaryKeySelective(Alarminfo record);

    int updateByPrimaryKey(Alarminfo record);
}
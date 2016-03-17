package com.bby.ants.dao;

import com.bby.ants.entity.Monitorpoints;
import com.bby.ants.entity.MonitorpointsExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitorpointsMapper {
    int countByExample(MonitorpointsExample example);

    int deleteByExample(MonitorpointsExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Monitorpoints record);

    int insertSelective(Monitorpoints record);

    List<Monitorpoints> selectByExample(MonitorpointsExample example);

    Monitorpoints selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Monitorpoints record, @Param("example") MonitorpointsExample example);

    int updateByExample(@Param("record") Monitorpoints record, @Param("example") MonitorpointsExample example);

    int updateByPrimaryKeySelective(Monitorpoints record);

    int updateByPrimaryKey(Monitorpoints record);
}
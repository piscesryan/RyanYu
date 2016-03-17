package com.bby.ants.dao;

import com.bby.ants.entity.Monitordata;
import com.bby.ants.entity.MonitordataExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface MonitordataMapper {
    int countByExample(MonitordataExample example);

    int deleteByExample(MonitordataExample example);

    int deleteByPrimaryKey(Long id);

    int insert(Monitordata record);

    int insertSelective(Monitordata record);

    List<Monitordata> selectByExample(MonitordataExample example);

    Monitordata selectByPrimaryKey(Long id);

    int updateByExampleSelective(@Param("record") Monitordata record, @Param("example") MonitordataExample example);

    int updateByExample(@Param("record") Monitordata record, @Param("example") MonitordataExample example);

    int updateByPrimaryKeySelective(Monitordata record);

    int updateByPrimaryKey(Monitordata record);
}
package com.bby.ants.dao;

import com.bby.ants.entity.Gateway;
import com.bby.ants.entity.GatewayExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface GatewayMapper {
    int countByExample(GatewayExample example);

    int deleteByExample(GatewayExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Gateway record);

    int insertSelective(Gateway record);

    List<Gateway> selectByExample(GatewayExample example);

    Gateway selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Gateway record, @Param("example") GatewayExample example);

    int updateByExample(@Param("record") Gateway record, @Param("example") GatewayExample example);

    int updateByPrimaryKeySelective(Gateway record);

    int updateByPrimaryKey(Gateway record);
}
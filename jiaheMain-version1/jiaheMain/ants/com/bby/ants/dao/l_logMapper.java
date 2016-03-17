package com.bby.ants.dao;

import com.bby.ants.entity.l_log;
import com.bby.ants.entity.l_logExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface l_logMapper {
    int countByExample(l_logExample example);

    int deleteByExample(l_logExample example);

    int deleteByPrimaryKey(Long logId);

    int insert(l_log record);

    int insertSelective(l_log record);

    List<l_log> selectByExample(l_logExample example);

    l_log selectByPrimaryKey(Long logId);

    int updateByExampleSelective(@Param("record") l_log record, @Param("example") l_logExample example);

    int updateByExample(@Param("record") l_log record, @Param("example") l_logExample example);

    int updateByPrimaryKeySelective(l_log record);

    int updateByPrimaryKey(l_log record);
}
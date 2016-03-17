package com.bby.ants.dao;

import com.bby.ants.entity.Adduserlog;
import com.bby.ants.entity.AdduserlogExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface AdduserlogMapper {
    int countByExample(AdduserlogExample example);

    int deleteByExample(AdduserlogExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(Adduserlog record);

    int insertSelective(Adduserlog record);

    List<Adduserlog> selectByExample(AdduserlogExample example);

    Adduserlog selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") Adduserlog record, @Param("example") AdduserlogExample example);

    int updateByExample(@Param("record") Adduserlog record, @Param("example") AdduserlogExample example);

    int updateByPrimaryKeySelective(Adduserlog record);

    int updateByPrimaryKey(Adduserlog record);
}
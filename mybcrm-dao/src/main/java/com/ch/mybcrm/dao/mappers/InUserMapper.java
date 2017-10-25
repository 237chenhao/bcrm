package com.ch.mybcrm.dao.mappers;

import com.ch.mybcrm.dao.model.InUser;
import com.ch.mybcrm.dao.model.InUserExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InUserMapper {
    int countByExample(InUserExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InUser record);

    int insertSelective(InUser record);

    List<InUser> selectByExample(InUserExample example);

    InUser selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InUser record, @Param("example") InUserExample example);

    int updateByExample(@Param("record") InUser record, @Param("example") InUserExample example);

    int updateByPrimaryKeySelective(InUser record);

    int updateByPrimaryKey(InUser record);
}
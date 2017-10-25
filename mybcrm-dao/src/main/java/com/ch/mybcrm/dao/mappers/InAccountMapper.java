package com.ch.mybcrm.dao.mappers;

import com.ch.mybcrm.dao.model.InAccount;
import com.ch.mybcrm.dao.model.InAccountExample;
import java.util.List;
import org.apache.ibatis.annotations.Param;

public interface InAccountMapper {
    int countByExample(InAccountExample example);

    int deleteByPrimaryKey(Integer id);

    int insert(InAccount record);

    int insertSelective(InAccount record);

    List<InAccount> selectByExample(InAccountExample example);

    InAccount selectByPrimaryKey(Integer id);

    int updateByExampleSelective(@Param("record") InAccount record, @Param("example") InAccountExample example);

    int updateByExample(@Param("record") InAccount record, @Param("example") InAccountExample example);

    int updateByPrimaryKeySelective(InAccount record);

    int updateByPrimaryKey(InAccount record);
}
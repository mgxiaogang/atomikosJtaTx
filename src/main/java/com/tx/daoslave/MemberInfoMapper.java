package com.tx.daoslave;

import com.tx.entity.MemberInfo;

public interface MemberInfoMapper {
    int deleteByPrimaryKey(Integer id);

    int insert(MemberInfo record);

    int insertSelective(MemberInfo record);

    MemberInfo selectByPrimaryKey(Integer id);

    int updateByPrimaryKeySelective(MemberInfo record);

    int updateByPrimaryKey(MemberInfo record);
}
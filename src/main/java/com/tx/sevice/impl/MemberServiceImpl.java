package com.tx.sevice.impl;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tx.daoslave.MemberInfoMapper;
import com.tx.daomaster.MemberMapper;
import com.tx.entity.Member;
import com.tx.entity.MemberInfo;
import com.tx.sevice.MemberService;

@Service("memberService")
public class MemberServiceImpl implements MemberService {
	
	//log
	private static final Logger LOG = LoggerFactory.getLogger(MemberServiceImpl.class);
	
	@Autowired
	private MemberMapper memberMapper;
	@Autowired
	private MemberInfoMapper memberInfoMapper;
	@Override
	public boolean registerMember(Member member, MemberInfo memberInfo) {
		boolean resRegister = false;

		int k = 4, i;
		StringBuilder sb = new StringBuilder();
		try {
			if(memberMapper.insert(member) != 1){
				throw new RuntimeException("注册用户:Member表数据插入不一致.");
			}
			if(memberInfoMapper.insert(memberInfo) != 1){
				throw new RuntimeException("注册用户:MemberInfo表数据插入不一致.");
			}
			resRegister = true;
		} catch (Exception e) {
			LOG.info("注册用户:数据库保存异常." + e.getMessage(), e);
			throw new RuntimeException("注册用户:数据库保存异常");
		}
		return resRegister;
	}

}

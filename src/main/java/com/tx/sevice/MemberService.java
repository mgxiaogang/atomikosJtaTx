package com.tx.sevice;

import com.tx.entity.Member;
import com.tx.entity.MemberInfo;

public interface MemberService {
	boolean registerMember(Member member, MemberInfo memberInfo);
}

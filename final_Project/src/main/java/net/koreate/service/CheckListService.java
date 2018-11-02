package net.koreate.service;

import net.koreate.vo.ListVo;
import net.koreate.vo.MemberVo;

public interface CheckListService {

	Object STEP1Search(MemberVo vo) throws Exception;
	
	Object STEP2Search(MemberVo vo) throws Exception;
	
	Object STEP3Search(MemberVo vo) throws Exception;
	
	Object STEP4Search(MemberVo vo) throws Exception;

	void STEP1Save(ListVo vo) throws Exception;
	
	void STEP2Save(ListVo vo) throws Exception;
	
	void STEP3Save(ListVo vo) throws Exception;
	
	void STEP4Save(ListVo vo) throws Exception;

	void STEP1Edit(ListVo vo) throws Exception;
	
	void STEP2Edit(ListVo vo) throws Exception;
	
	void STEP3Edit(ListVo vo) throws Exception;
	
	void STEP4Edit(ListVo vo) throws Exception;

}
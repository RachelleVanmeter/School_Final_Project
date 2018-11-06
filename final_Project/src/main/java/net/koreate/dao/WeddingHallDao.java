package net.koreate.dao;

import java.util.List;

import net.koreate.vo.WeddingHallVo;
import net.koreate.vo.WeddingStudioVo;

public interface WeddingHallDao {

	// 2018/10/29
	List<WeddingHallVo> SearchArea(WeddingHallVo vo) throws Exception;

	// 2018/10/30
	List<WeddingHallVo> SearchAllhall(WeddingHallVo vo) throws Exception;

	List<WeddingStudioVo> SearchAllstudio(WeddingStudioVo vo) throws Exception;

	void hallAdd(WeddingHallVo vo) throws Exception;

	void studioAdd(WeddingStudioVo vo) throws Exception;

	WeddingHallVo getHallByHNO(int hall_hno) throws Exception;

	WeddingStudioVo getStudioByHNO(int studio_hno) throws Exception;

	void hallEdit(WeddingHallVo vo) throws Exception;

	void studioEdit(WeddingStudioVo vo) throws Exception;

	void hallDeleteByHNO(int hall_hno) throws Exception;

	void studioDeleteByHNO(int studio_hno) throws Exception;
	
	// 2018/11/06
	WeddingHallVo SearchAreaHallDetail(WeddingHallVo vo) throws Exception;

}

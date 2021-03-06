package net.koreate.service;

import java.util.List;

import javax.inject.Inject;

import org.mindrot.jbcrypt.BCrypt;
import org.springframework.stereotype.Service;

import net.koreate.dao.MemberDao;
import net.koreate.dto.LoginDto;
import net.koreate.vo.MemberVo;

@Service
public class MemberServiceImpl implements MemberService {
	
	@Inject
	MemberDao dao;

	@Override
	public String register(MemberVo vo) throws Exception {
		String result = "FAIL";

		final String memberID = vo.getMwid();
		final String memberPW = vo.getMwpw();
		
		final String hash = memberID + "/" + memberPW;
		
		final String passwordHash = BCrypt.hashpw(hash, BCrypt.gensalt(15));
		
		vo.setMwpw(passwordHash);
		
		final MemberVo voBefor = dao.registerBefor(vo);
		
		if(voBefor == null || !voBefor.getMwid().equals(memberID)) { dao.register(vo); result = "SUCCESS"; }
		else { dao.updateRegister(vo); result = "SUCCESS"; }
		
		return result;
	}

	@Override
	public String login(MemberVo vo) throws Exception {
		String result = "FAIL";
		
		MemberVo voBefor = dao.login(vo);
		
		if(voBefor != null) { result = "SUCCESS"; }
		
		return result;
	}

	@Override
	public MemberVo getUserByUNO(String mwid) throws Exception {
		return dao.getUserByUNO(mwid);
	}

	@Override
	public MemberVo signIn(LoginDto dto) throws Exception {
		return dao.signIn(dto);
	}

	@Override
	public MemberVo getUserByID(String mwid) throws Exception {
		return dao.getUserByID(mwid);
	}

	// 2018/10/26
	@Override
	public MemberVo loginDto(LoginDto dto) throws Exception {
		return dao.loginDto(dto);
	}

	@Override
	public MemberVo memberSearch(LoginDto dto) throws Exception {
		return dao.memberSearch(dto);
	}

	@Override
	public void editInfo(MemberVo vo) throws Exception {
		final String memberID = vo.getMwid();
		final String memberPW = vo.getMwpw();
		
		final String hash = memberID + "/" + memberPW;
		
		if (memberPW != null) {
			final String passwordHash = BCrypt.hashpw(hash, BCrypt.gensalt(15));
			
			vo.setMwpw(passwordHash);
			dao.editInfo(vo);
		} else {
			final String passwordHash = this.getPasswordHashByID(memberID);
			
			vo.setMwpw(passwordHash);
			dao.editInfo(vo);
		}
	}

	@Override
	public MemberVo getUserByVO(MemberVo vo) throws Exception {
		return dao.getUserByVO(vo);
	}

	@Override
	public List<MemberVo> memberAllSearch() throws Exception {
		return dao.memberAllSearch();
	}

	@Override
	public void infoDeleteByID(String mwid) throws Exception {
		dao.infoDeleteByID(mwid);
	}

	@Override
	public void infoUpdateByVO(MemberVo vo) throws Exception {
		final String memberID = vo.getMwid();
		final String memberPW = vo.getMwpw();
		
		final String hash = memberID + "/" + memberPW;
		
		if (memberPW != null && !memberPW.equals("")) {
			final String passwordHash = BCrypt.hashpw(hash, BCrypt.gensalt(15));
			
			vo.setMwpw(passwordHash);
			dao.infoUpdateByVO(vo);
		} else {
			final String passwordHash = this.getPasswordHashByID(memberID);
			
			vo.setMwpw(passwordHash);
			dao.infoUpdateByVO(vo);
		}
	}

	// 2018/11/01
	@Override
	public MemberVo searchByNO(int mwno) throws Exception {
		// TODO Auto-generated method stub
		return dao.searchByNO(mwno);
	}

	@Override
	public int isMasterSearch() throws Exception {
		// TODO Auto-generated method stub
		return dao.isMasterSearch();
	}

	// 2018/11/06
	@Override
	public List<MemberVo> searchID() throws Exception {
		// TODO Auto-generated method stub
		return dao.searchID();
	}
	
	// 2018/12/02
	@Override
	public void deleteInfo(MemberVo obj) throws Exception {
		// TODO Auto-generated method stub
		dao.deleteInfo(obj);
	}

	// 2018/12/08
	@Override
	public String getPasswordHashByID(String memberID) throws Exception {
		// TODO Auto-generated method stub
		return dao.getPasswordHashByID(memberID);
	}

	/*@Override
	public Object getMember(MemberVo mvo) throws Exception {
		// TODO Auto-generated method stub
		return dao.getMember(mvo);
	}*/
	
}

package himedia.myportal.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import himedia.myportal.repositories.GuestbookDao;
import himedia.myportal.repositories.vo.GuestbookVo;

@Service
public class GuestbookServiceImpl implements GuestbookService {
	@Autowired
	GuestbookDao guestbookDaoImpl;
	
	@Override
	public List<GuestbookVo> getMessageList() {
		List<GuestbookVo> list = guestbookDaoImpl.selectAll();
		
		return list;
	}

	
	// boolean -> 성공인가 실패인가로 나누고 싶으니까 (게시물 업로드가 성공이냐 실패냐)
	@Override
	public boolean writeMessage(GuestbookVo vo) {
		int insertedCount = guestbookDaoImpl.insert(vo);
		return 1 == insertedCount;
	}

	
	
	@Override
	public boolean deleteMessage(GuestbookVo vo) {
		int deletedCount = guestbookDaoImpl.delete(vo);
		return 1 == deletedCount;
	}
	
}
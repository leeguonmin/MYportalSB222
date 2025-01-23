package himedia.myportal.repositories;


import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exception.GuestbookDaoException;
import himedia.myportal.mappers.GuestbookMapper;
import himedia.myportal.repositories.vo.GuestbookVo;

@Repository
public class GuestbookDaoImpl 
	implements GuestbookDao {
//	@Autowired
//	SqlSession sqlSession;
	@Autowired
	private GuestbookMapper guestbookMapper;
	
	@Override
	public List<GuestbookVo> selectAll() {
//		List<GuestbookVo> list = sqlSession.selectList("guestbook.selectAll");
//		return list;
		return guestbookMapper.selectAll();
	}

	@Override
	public int insert(GuestbookVo vo) {
		int insertedCount = 0;
		// 초기화 -> 정보를 저장하고 나면 다시 0이 되는거쥬? 기본이 0 인거쥬.
		// 그러니까 만약 저장에 실패하면, 0이 저장되는거쥬
		
		try {
			// insertedCount에 guestMapper 인터페이스의 insert 메서드를 불러와 
			insertedCount = guestbookMapper.insert(vo);
		} catch (Exception e) {
			throw new GuestbookDaoException("게시판 저장 중에 오류가 생겼음");
			
		}
		
		
//		try {
//			insertedCount = 
//					sqlSession.insert("guestbook.insert", vo);
//			// PersistenceException or SQLException
//		} catch (Exception e) {
//			//	예외 전환
//			throw new GuestbookDaoException("방명록 기록중 에러 발생", vo);
//		}
		return insertedCount;
	}

	@Override
	public int delete(GuestbookVo vo) {
		int deletedCount = 0;
//		try {
//			deletedCount = sqlSession.delete("guestbook.delete", vo);
//		} catch (Exception e) {
//			throw new GuestbookDaoException("방명록 삭제중 에러 발생", vo);
//		}
		
		try {
			deletedCount = guestbookMapper.delete(vo);
		} catch (Exception e) {
			throw new GuestbookDaoException("삭제 중 오류 생김");
		}
		
		return deletedCount;
	}

}
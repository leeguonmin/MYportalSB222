package himedia.myportal.repositories;


import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import himedia.myportal.exception.UserDaoException;
import himedia.myportal.mappers.UserMapper;
import himedia.myportal.repositories.vo.UserVo;

@Repository
public class UserDaoImpl implements UserDao {
//	@Autowired
//	SqlSession sqlSession;
	@Autowired
	UserMapper userMapper;
	
	
	@Override
	public int insert(UserVo vo) {
//		try {
//			return sqlSession.insert("user.insert", vo);
//		} catch (Exception e) {
//			throw new UserDaoException("회원가입 중 오류", vo);
//		}
		int count=0;
		
		try {
			count = userMapper.insert(vo);
		} catch (Exception e) {
			throw new UserDaoException("회원가입 중 오류 발생", vo);
		}
		return count;
	}

	// 중복 체크용 
	@Override
	public UserVo selectUser(String email) {
//		UserVo vo = 
//				sqlSession.selectOne("user.selectUserByEmail", email);
		
		// UserVo 받아와야 하니까
		UserVo vo = userMapper.selectUserByEmail(email);
		
		// 전달받은 vo 객체를 리턴
		return vo;
	}

	// 로그인용
	@Override
	public UserVo selectUser(String email, String password) {
//		Map<String, String> userMap 
//			= new HashMap<>();
//		userMap.put("email", email);
//		userMap.put("password", password);
//		
//		UserVo vo = 
//			sqlSession.selectOne("user.selectUserByEmailAndPassword", 
//					userMap);
		
		Map<String, String> userMap = new HashMap<>();
		userMap.put("email", email);
		userMap.put("password", password);
		
		UserVo vo = userMapper.selectUserByEmailAndPassword(userMap);
		return vo;
		
		// 얜 잘 모르겠으니까 나중에 꼭 챗지피티한테 물어봐라 
	}

}
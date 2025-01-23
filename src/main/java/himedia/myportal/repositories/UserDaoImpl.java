package himedia.myportal.repositories;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

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
		int insertedCount=0;
		
		try {
			
		}
		return insertedCount;
	}

	@Override
	public UserVo selectUser(String email) {
//		UserVo vo = 
//				sqlSession.selectOne("user.selectUserByEmail", email);
		return null;
	}

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
		return null;
	}

}
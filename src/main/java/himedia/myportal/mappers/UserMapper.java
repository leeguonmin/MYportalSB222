package himedia.myportal.mappers;

import java.util.Map;

import himedia.myportal.repositories.vo.UserVo;

public interface UserMapper {
	
// <insert id="insert" parameterType="userVo">
	int insert(UserVo vo);
	
	
//	<select id="selectUserByEmailAndPassword" parameterType="map" resultType="userVo">
	UserVo selectUserByEmailAndPassword(Map<String, String> map);
	// passwork를 map에다 실어줘야함
	// 왜 String이 두개인지 모르겠는데 => 아 이메일이랑 패스워드니까 ㅇㅋ
	
	
//	<select id="selectUserByEmail" parameterType="string" resultType="userVo">
	UserVo selectUserByEmail(String email);
	
}

package himedia.myportal.mappers;

import java.util.List;

import org.apache.ibatis.annotations.Mapper;

import himedia.myportal.repositories.vo.GuestbookVo;

@Mapper
public interface GuestbookMapper {
	
//	<select id="selectAll" resultType="guestbookVo">	
	List<GuestbookVo> selectAll();
	
	int insert(GuestbookVo vo);
	
	int delete(GuestbookVo vo);

}






// mapper 인터페이스

/* 설명
 * 
 * - List<GuestbookVo>
 * : SQL 쿼리의 결과가 여러 행이라면 각각의 행이 
 *   GuestbookVo 객체로 매핑되고, 이 객체들이 **리스트(List)**로 반환
 * : 결과가 여러 행일 때는 반드시 리스트나 컬렉션 형태로 받아야함
 *   (단일 행이면 GuestbookVo 하나로 받으면 됨요)
 *   
 * - 메서드 이름 selectAll
 * : 이 메서드 이름은 XML의 <select> 태그의 id 속성과 1:1로 매칭
 * : 즉, GuestbookMapper.selectAll()을 호출하면 이 SQL이 실행되는 구조
 * 
 * 
 */

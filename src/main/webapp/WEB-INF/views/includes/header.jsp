<%-- <%@page import="himedia.kdt.myhome.vo.UserVo"%> --%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session="true" %>
<%@ taglib uri="http://java.sun.com/jsp/jstl/core" 
	prefix="c" %>
	<div id="header">
      <h1>My Homepage</h1>
      <ul>
      <c:choose>
      	<c:when test="${empty authUser }">
      		<li><a href="<c:url value="/users/join" />">회원가입</a><li>
      		<li><a href="<c:url value="/users/login" />">로그인</a></li>
      	</c:when>
      	<c:otherwise>
      		<li>${sessionScope.authUser.name }님, 안녕하세요 ^^</li>
      		<li><a href="<c:url value="/users/logout" />">로그아웃</a></li>
      	</c:otherwise>
      </c:choose>
      </ul>
    </div> <!-- /header -->






<%-- <%@page import="himedia.kdt.myhome.vo.UserVo"%>
<%@ page language="java" contentType="text/html; charset=UTF-8"
    pageEncoding="UTF-8"%>
<%@ page session = "true" %>

<%@ taglib uri = "http://java.sun.com/jsp/jstl/core" 
prefix="c" %>

<%
UserVo authUser = (UserVo)session.getAttribute("authUser");
%> (이거 지웠으니)

	<div id="header">
      <h1>My Homepage</h1>
      <!-- <p>authUser: < %= authUser %> -->
      <ul>
      <% if (authUser == null) { %> (얘도 수정)
     <c:choose>
     	<c:when test="${empty authUser }">
      												<li><a href="<%= request.getContextPath() %>/users?a=joinform">회원가입</a><li>
      		<li><a href="<c:url value="/users?a=joinform" />">회원가입</a><li>
      		 <li><a href="<c:url value='/users'>">
            <c:param name="a" value="loginform" />
        	</c:url>로그인</a></li>
      	</c:when>
      	<c:otherwise>
      												<!-- <li>  < %= authUser.getName() % >님, 안녕하세요 :) </li> -->
      		<li> ${sessionScope.authUser.name }님, 안녕하세요 :) </li>
      												<li><a href="<%= request.getContextPath() %>/users?a=logout">로그아웃</a></li>
      		<li><a href="<c:url value="/users?a=logout" />">로그아웃</a></li>
      	</c:otherwise>
      </c:choose>
      </ul>
    </div> <!-- /header --> --%>
    
    
    
    
    
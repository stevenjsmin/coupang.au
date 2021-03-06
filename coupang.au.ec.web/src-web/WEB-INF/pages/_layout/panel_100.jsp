<%@ page language="java" contentType="text/html; charset=UTF-8" pageEncoding="UTF-8"%>
<%@ taglib prefix="tiles" uri="http://tiles.apache.org/tags-tiles"%>

<!-- 
	화면 상.하로 Header와 Footer가 없는 간단한 레이아웃이다.
	
	주로 팝업페이지와 같이, 에더와 풋터가 필요없이, 간단한 화면제목과 내용만 필요한 경우 사용되어지는 레이아웃이다.
 -->
 
<html lang="en">
<head>
<title><tiles:getAsString name="title" /></title>
<tiles:insertAttribute name="resource" />
<tiles:insertAttribute name="commonhtml" />
</head>
<body>
     <span class="popup-subtitle"><tiles:getAsString name="title" /></span>
     <hr class="popup-subtitle"/>
                    
     <div class="content" id="contentsDiv">
          <tiles:insertAttribute name="body" />
     </div>
</body>
</html>
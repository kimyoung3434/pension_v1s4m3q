<%@ page contentType="text/html; charset=UTF-8" %>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dev.mvc.room.RoomVO" %>

<%
// request.setAttribute("blogVO", blogVO);
RoomVO roomVO = (RoomVO)request.getAttribute("roomVO");
%>

<!DOCTYPE html> 
<html lang="ko"> 
<head> 
<meta charset="UTF-8"> 
<title></title> 
 
<link href="../css/style.css" rel="Stylesheet" type="text/css">
<script type="text/JavaScript"
          src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript" src="../js/jquery.cookie.js"></script>
<script type="text/javascript" src="../ckeditor/ckeditor.js"></script>

<script type="text/javascript" src="../js/tool.js"></script>
 
<script type="text/javascript">
$(function(){
    CKEDITOR.replace('content');  // <TEXTAREA>태그 id 값 
 });
</script>
 
</head> 
<!-- ----------------------------------------- -->
<body leftmargin="0" topmargin="0">
<jsp:include page="/menu/top.jsp" flush='false' />
<!-- ----------------------------------------- -->

<div class='content_menu'>
  <A href='./list.do'>게시판</A>｜새글 등록
</div> 
<DIV class='content' style='width: 80%;'>
<FORM name='frm' method='POST' action='./create.do'
           enctype="multipart/form-data">
    <ul>
      <li>
        <label for='title'>제목</label>
        <input type='text' name='title' id='title' size='70' value='봄' required="required">
      </li>
      <li>
        <textarea name='content' id='content'  rows='7' style='width: 100%;'>추위끝</textarea>
      </li>
      <li>
        <label class='label' for='fileMF'>Thumb 파일</label>
        <input type="file" name='fileMF' id='fileMF' >
      </li>
      <li>
        <label class='label' for='file1MF'>업로드 파일1</label>
        <input type="file" name='file1MF' id='file1MF' >
      </li>
            <li>
        <label class='label' for='file2MF'>업로드 파일2</label>
        <input type="file" name='file2MF' id='file2MF' >
      </li>
            <li>
        <label class='label' for='file3MF'>업로드 파일3</label>
        <input type="file" name='file3MF' id='file3MF' >
      </li>
      <li>
        <label class='label' for='roomno'>카테고리 번호</label>
        <input type="text" name='roomno' id='roomno' value='<%=roomVO.getRoomno() %>'>
      </li>
      <li class='right'>
        <button type="submit">등록</button>
      </li>         
    </ul>
</FORM>
</DIV>
 
<!-- -------------------------------------------- -->
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
<!-- -------------------------------------------- -->
</html> 


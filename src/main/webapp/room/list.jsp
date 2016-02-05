<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="java.util.ArrayList" %>
<%@ page import="dev.mvc.room.RoomVO" %>
<%@ page import="web.tool.Tool" %>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>

<link href="../css/style.css" rel="Stylesheet" type="text/css">
<script type="text/javascript" src="../js/tool.js"></script>
<script type="text/JavaScript" 
          src="http://ajax.googleapis.com/ajax/libs/jquery/1.11.3/jquery.min.js"></script>
<script type="text/javascript">
$(function(){
});
</script>

<script type="text/javascript">
</script>
</head>

<%-- body 시작 --%>
<body>
<jsp:include page="/menu/top.jsp" flush='false' />
<%-- ---------------------------------------------------------------------------------------------- --%>
  <% ArrayList<RoomVO> list = (ArrayList<RoomVO>)request.getAttribute("list"); %>
  
  <div class='content_menu' style='width: 90%;'>
    <A href='../room/list.do'>전체 게시판 목록</A> ｜
    <A href='./list.do'>게시판</A>｜
    <A href='./create.do'>등록</A>｜
    <A href="javascript:location.reload();">새로고침</A>
  </div>
  <div class="content" style='width: 90%;'>
    <table class="table" style='width: 100%;'>
      <colgroup>
  
        <col style="width: 10%;"></col>
        <col style="width: 5%;"></col>
        <col style="width: 10%;"></col>
        <col style="width: 10%;"></col>
        <col style="width: 10%;"></col>
        <col style="width: 8%;"></col>
        <col style="width: 8%;"></col>
        <col style="width: 5%;"></col>

        <col style="width: 5%;"></col>
      </colgroup>
          
      <%-- table 컬럼 --%>
      <thead>
        <tr>
         
          <th class="th">객실명</th>
          <th class="th">최대인원</th>
          <th class="th">구조</th>
          <th class="th">타입</th>
          <th class="th">구비시설</th>
          <th class="th">비수기</th>
          <th class="th">성수기</th>
          <th class="th">사진</th>
    
      
          <th class="th">기타</th>

        </tr>
      
      </thead>
      
      <%-- table 내용 --%>
      <tbody>
        <%
          for(int index = 0; index < list.size(); index++){
            RoomVO vo = list.get(index);
            int roomno = vo.getRoomno();
          %>
          <tr>
          <%--   <td class="td"><%=roomno %></td> --%>
            <td class="td">
              <a href="./read.do?roomno=<%=roomno %>"><%=Tool.textLength(10, vo.getRoom_name())%></a> 
            </td>
            <%-- <td class="td"><%=vo.getRoom_name() %></td> --%>
            <td class="td"><%=vo.getPerson_max() %></td>
            <td class="td"><%=vo.getStructure() %></td>
            <td class="td"><%=vo.getRoom_type() %></td>
            <td class="td">
            <%=Tool.textLength(10, vo.getEquipment())%>
            </td>
            <td class="td"><%=vo.getMoney1() %></td>
            <td class="td"><%=vo.getMoney3() %></td>
            <td class="td">
            <label for="file" class="label"> </label>
           <img src='./storage/<%=vo.getFile() %>' ><br>
            </td>
   
   
            <td class="td">
              <a href="./update.do?roomno=<%=roomno%>"><img src="./images/update.png" title="수정" /></a>
              <a href="./delete.do?roomno=<%=roomno %>"><img src="./images/delete.png" title="삭제" /></a>
           <%--    <%=vo.getBlogcategoryno() %> --%>
            </td>
          </tr>
          <% 
        }
        %>
      </tbody>
    </table>
    <br><br>
  </div>
  
  <DIV class='bottom'>
    <button type='button' onclick="location.href='./create.do'">등록</button>
  <button type='button' onclick="location.reload();">새로 고침</button>
  </DIV>
<%-- ---------------------------------------------------------------------------------------------- --%>
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
<%-- body 종료 --%>
</html>



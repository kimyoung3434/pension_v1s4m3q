<%@ page contentType="text/html; charset=UTF-8"%>
<%@ page import="dev.mvc.room.RoomVO" %>
<%@ page import="web.tool.Tool" %>

<% 
RoomVO roomVO = (RoomVO)request.getAttribute("roomVO");  
%>

<!DOCTYPE html>
<html lang="ko">
<head>
<meta charset="UTF-8">
<title></title>

<link href="../css/style.css" rel="Stylesheet" type="text/css">

</head>
<!-- ----------------------------------------- -->
<body leftmargin="0" topmargin="0">
  <jsp:include page="/menu/top.jsp" flush='false' />
  <!-- ----------------------------------------- -->

  <DIV class='content'>
    <FORM name='frm' method="get" action='./update.do'>
      <input type="hidden" name="roomno" value="<%=roomVO.getRoomno() %>">
     
      <fieldset class="fieldset">
        <ul>

          <li>
            <label for='room_name' class="label" style="width:150px;">객실명 : </label>
            <span><%=roomVO.getRoom_name()%></span><br>
          </li>
          <li>
            <label for='person_max' class="label" style="width:150px;">최대인원 : </label>
            <span><%=roomVO.getPerson_max() %>명</span>
          </li>
          <li>
            <label for="structure" class="label" style="width:150px;">구조 : </label>
            <span><%=roomVO.getStructure()%></span>
          </li>
           <li>
            <label for="room_type" class="label" style="width:150px;">타입 : </label>
            <span><%=roomVO.getRoom_type()%></span>
          </li>
           <li>
            <label for="equipment" class="label" style="width:150px;">구비시설 : </label>
            <span><%=roomVO.getEquipment()%></span>
          </li>
           <li>
            <label for="money1" class="label" style="width:150px;">비수기 : </label>
            <span><%=roomVO.getMoney1()%>원</span>
          </li>
           <li>
            <label for="money3" class="label" style="width:150px;">성수기 : </label>
            <span><%=roomVO.getMoney3()%>원</span>
          </li>
          <br>
          <li>
            <label for="file" class="label" style="width:150px;"> </label>
            <img src='./storage/<%=roomVO.getFile() %>' ><br>
          </li>
       
          <li>
            <label for="file1" class="label" style="width:150px;"> </label>
            <div>
              <img src='./storage/<%=roomVO.getFile1() %>' ><br>
            </div>
          </li>
          <li>
            <label for="file2" class="label" style="width:150px;"> </label>
            <div>
              <img src='./storage/<%=roomVO.getFile2() %>' ><br>
            </div>
          </li>
           <li>
            <label for="file3" class="label" style="width:150px;"> </label>
            <div>
               <img src='./storage/<%=roomVO.getFile3() %>' ><br>
            </div>
          </li>
           <li>
            <label for="file4" class="label" style="width:150px;"> </label>
            <div>
               <img src='./storage/<%=roomVO.getFile4() %>' ><br>
            </div>
          </li>
           <li>
            <label for="file5" class="label" style="width:150px;"> </label>
            <div>
               <img src='./storage/<%=roomVO.getFile5() %>' ><br>
            </div>
          </li> 
          
          <li class='right'>
           <button type="button" onclick="location.href='./list.do?roomno=<%=roomVO.getRoomno() %>'">목록</button>
        <button type="submit">수정</button>
        <button type="button" onclick="location.href='./delete.do?roomno=<%=roomVO.getRoomno() %>'">삭제</button>
       
        </ul>
      </fieldset>
    </FORM>
  </DIV>


  <!-- -------------------------------------------- -->
  <jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
<!-- -------------------------------------------- -->
</html>


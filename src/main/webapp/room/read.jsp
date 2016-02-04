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
            <span><%=roomVO.getPerson_max() %></span>
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
            <label for="equipment" class="label" style="width:150px;">시설 : </label>
            <span><%=roomVO.getEquipment()%></span>
          </li>
           <li>
            <label for="money1" class="label" style="width:150px;">비수기 : </label>
            <span><%=roomVO.getMoney1()%></span>
          </li>
           <li>
            <label for="money3" class="label" style="width:150px;">성수기 : </label>
            <span><%=roomVO.getMoney3()%></span>
          </li>
          <li>
            <label for="file" class="label" style="width:150px;">Thumb 파일 : </label>
            <%=roomVO.getFile() %><br>
          </li>
          <li>
            <label for="file1" class="label" style="width:150px;">업로드 파일1: </label>
            <div>
              <%=roomVO.getFile1() %><br>
            </div>
          </li>
          <li>
            <label for="file2" class="label" style="width:150px;">업로드 파일2: </label>
            <div>
              <%=roomVO.getFile2() %><br>
            </div>
          </li>
           <li>
            <label for="file3" class="label" style="width:150px;">업로드 파일3: </label>
            <div>
              <%=roomVO.getFile3() %><br>
            </div>
          </li>
           <li>
            <label for="file4" class="label" style="width:150px;">업로드 파일4: </label>
            <div>
              <%=roomVO.getFile4() %><br>
            </div>
          </li>
           <li>
            <label for="file5" class="label" style="width:150px;">업로드 파일5: </label>
            <div>
              <%=roomVO.getFile5() %><br>
            </div>
          </li>
          
        </ul>
      </fieldset>
    </FORM>
  </DIV>

  <!-- -------------------------------------------- -->
  <jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
<!-- -------------------------------------------- -->
</html>


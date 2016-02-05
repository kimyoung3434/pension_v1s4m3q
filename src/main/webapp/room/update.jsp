<%@ page contentType="text/html; charset=UTF-8" %> 
<%@ page import="dev.mvc.room.RoomVO" %>
<%@ page import="web.tool.Tool" %>

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
function fileUpdate(file){
  // alert(file);
  var win_file = window.open('./update.jsp?file=' + file, '파일 변경', 'width=500px, height=440px, scrollbars=no')
  // alert(screen.width + "/" + screen.height);
  var x = (screen.width - 500) / 2;
  var y = (screen.height - 440) / 2;
  
  win_file.moveTo(x, y); // 화면 이동
}
</script>
 
</head> 
<!-- ----------------------------------------- -->
<body leftmargin="0" topmargin="0">
<jsp:include page="/menu/top.jsp" flush='false' />
<!-- ----------------------------------------- -->
<%  
RoomVO roomVO = (RoomVO)request.getAttribute("roomVO");
// System.out.println("-->blogVO.getBlogno:" + blogVO.getBlogno());     
%>

<DIV class='content' style='width: 80%;'>
  <FORM name='frm' method='POST' action='./update.do'
             enctype="multipart/form-data">
    <input type='hidden' name='roomno' id='roomno' value='<%=roomVO.getRoomno() %>'>
    
  
    <ul>
      <li>
        <label for='room_name'>객실명</label>
        <input type='text' name='room_name' id='room_name' size='20' value='<%=roomVO.getRoom_name() %>' required="required">
      </li>
       <li>
        <label for='person_max'>최대인원</label>
        <input type='number' name='person_max' id='person_max' min='0' max='8' value='<%=roomVO.getPerson_max() %>' required="required">
      </li>
            <li>
        <label for='structure'>구조</label>
        <input type='text' name='structure' id='structure' size='20' value='<%=roomVO.getStructure() %>' required="required">
      </li>
       <li>
        <label for='room_type'>타입</label>
        <input type='text' name='room_type' id='room_type' size='10' value='<%=roomVO.getRoom_type() %>' required="required">
      </li>
      <li>
      <label for='equipment'>구비시설</label>
        <textarea name='equipment' id='equipment'  rows='4'  value='<%=roomVO.getEquipment() %>' style='width: 100%;'></textarea>
      </li>
        <li>
        <label for='money1'>비수기</label>
        <input type='number' name='money1' id='money1' size='10' value='<%=roomVO.getMoney1() %>' required="required">
      </li>
        <li>
        <label for='money3'>성수기</label>
        <input type='number' name='money3' id='money3' size='10' value='<%=roomVO.getMoney3() %>' required="required">
      </li>
      
      <li>
        <label for='fileMF'>Thumb 파일</label>
        <span id='fileMF'> 
        <A href="javascript: fileUpdate('<%=roomVO.getFile()%>')"><IMG src='./storage/<%=roomVO.getFile() %>' width='150px'></A>
        <input type="file" name='fileMF' id='fileMF' value=''>
        </span>
      </li>
 
      <li>
        <label for='file1MF'>업로드 파일1</label>
        <span id='file1MF'> 
        <A href="javascript: fileUpdate('<%=roomVO.getFile1()%>')"><IMG src='./storage/<%=roomVO.getFile1() %>' width='150px'></A>
        <input type="file" name='file1MF' id='file1MF' value=''>
        </span>
      </li>
            <li>
        <label for='file2MF'>업로드 파일2</label>
         <span id='file2MF'> 
        <A href="javascript: fileUpdate('<%=roomVO.getFile2()%>')"><IMG src='./storage/<%=roomVO.getFile2() %>' width='150px'></A>
        <input type="file" name='file2MF' id='file2MF' value=''>
        </span>
      </li>
       <li>
        <label for='file3MF'>업로드 파일3</label>
         <span id='file3MF'> 
        <A href="javascript: fileUpdate('<%=roomVO.getFile3()%>')"><IMG src='./storage/<%=roomVO.getFile3() %>' width='150px'></A>
        <input type="file" name='file3MF' id='file3MF' value=''>
        </span>
      </li>
       <li>
        <label for='file4MF'>업로드 파일4</label>
         <span id='file4MF'> 
        <A href="javascript: fileUpdate('<%=roomVO.getFile4()%>')"><IMG src='./storage/<%=roomVO.getFile4() %>' width='150px'></A>
        <input type="file" name='file4MF' id='file4MF' value=''>
        </span>
      </li>
       <li>
        <label for='file5MF'>업로드 파일5</label>
         <span id='file5MF'> 
        <A href="javascript: fileUpdate('<%=roomVO.getFile5()%>')"><IMG src='./storage/<%=roomVO.getFile5() %>' width='150px'></A>
        <input type="file" name='file5MF' id='file5MF' value=''>
        </span>
      </li>
<%-- <li>
        <label class='label' for='roomno'>카테고리 번호</label>
        <input type="text" name='roomno' id='roomno' value='<%=roomVO.getRoomno() %>'>
      </li> --%>
          
      <li class='right'>
        <button type="submit">수정</button>
        <button type="button" onclick="location.href='./list.do?roomno=<%=roomVO.getRoomno() %>'">목록</button>
      </li>         
    </ul>
  </FORM>
</DIV>
 
<!-- -------------------------------------------- -->
<jsp:include page="/menu/bottom.jsp" flush='false' />
</body>
<!-- -------------------------------------------- -->
</html> 

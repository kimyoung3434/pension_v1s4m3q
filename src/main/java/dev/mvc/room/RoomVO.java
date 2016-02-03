package dev.mvc.room;

import org.springframework.web.multipart.MultipartFile;

public class RoomVO {
 /*CREATE TABLE room(
    roomno                           MEDIUMINT    NOT NULL  PRIMARY KEY AUTO_INCREMENT COMMENT '객실번호',
    room_name                       VARCHAR(20)     NOT NULL COMMENT '객실명',
    person_min                          MEDIUMINT     NOT NULL COMMENT '인원기준',
    person_max                      MEDIUMINT     NOT NULL COMMENT '인원최대',
    structure                             VARCHAR(20)     NOT NULL  COMMENT '구조',
    room_type                         VARCHAR(20)     NOT NULL COMMENT '타입',
    equipment                         VARCHAR(100)      NOT NULL COMMENT '시설',
    money1                          MEDIUMINT     NOT NULL  COMMENT 'money1',
    money2                          MEDIUMINT     NOT NULL COMMENT 'money2',
    money3                          MEDIUMINT     NOT NULL  COMMENT 'money3',
    file                          VARCHAR(20)     NULL  COMMENT  'file',
    file1                         VARCHAR(20)     NULL  COMMENT  'file1',
    file2                         VARCHAR(20)     NULL  COMMENT  'file2',
    file3                         VARCHAR(20)     NULL  COMMENT  'file3',
    file4                         VARCHAR(20)     NULL  COMMENT  'file4',
    file5                         VARCHAR(20)     NULL  COMMENT  'file5'
) COMMENT='상품정보';
*/

  private int  roomno;
  private String  room_name;
  private int  person_min;
  private int  person_max;
  private String  structure;
  private String  room_type;
  private String  equipment;
  private int  money1;
  private int  money2;
  private int  money3;
  private String  file;
  private String  file1;
  private String  file2;
  private String  file3;
  private String  file4;
  private String  file5;
  

  /* Framework에서 자동 주입되는 Thumb 파일 객체 */
  private MultipartFile fileMF;
  /* Framework에서 자동 주입되는 파일 객체 */  
  private MultipartFile file1MF;
  private MultipartFile file2MF;
  private MultipartFile file3MF;
  private MultipartFile file4MF;
  private MultipartFile file5MF;
  
  
  public MultipartFile getFile2MF() {
    return file2MF;
  }
  public String getFile5() {
    return file5;
  }
  public void setFile5(String file5) {
    this.file5 = file5;
  }
  public MultipartFile getFile5MF() {
    return file5MF;
  }
  public void setFile5MF(MultipartFile file5mf) {
    file5MF = file5mf;
  }
  public void setFile2MF(MultipartFile file2mf) {
    file2MF = file2mf;
  }
  public MultipartFile getFile3MF() {
    return file3MF;
  }
  public void setFile3MF(MultipartFile file3mf) {
    file3MF = file3mf;
  }
  public MultipartFile getFile4MF() {
    return file4MF;
  }
  public void setFile4MF(MultipartFile file4mf) {
    file4MF = file4mf;
  }
  public MultipartFile getFileMF() {
    return fileMF;
  }
  public void setFileMF(MultipartFile fileMF) {
    this.fileMF = fileMF;
  }
  public MultipartFile getFile1MF() {
    return file1MF;
  }
  public void setFile1MF(MultipartFile file1mf) {
    file1MF = file1mf;
  }
  public int getRoomno() {
    return roomno;
  }
  public void setRoomno(int roomno) {
    this.roomno = roomno;
  }
  public String getRoom_name() {
    return room_name;
  }
  public void setRoom_name(String room_name) {
    this.room_name = room_name;
  }
  public int getPerson_min() {
    return person_min;
  }
  public void setPerson_min(int person_min) {
    this.person_min = person_min;
  }
  public int getPerson_max() {
    return person_max;
  }
  public void setPerson_max(int person_max) {
    this.person_max = person_max;
  }
  public String getStructure() {
    return structure;
  }
  public void setStructure(String structure) {
    this.structure = structure;
  }
  public String getRoom_type() {
    return room_type;
  }
  public void setRoom_type(String room_type) {
    this.room_type = room_type;
  }
  public String getEquipment() {
    return equipment;
  }
  public void setEquipment(String equipment) {
    this.equipment = equipment;
  }
  public int getMoney1() {
    return money1;
  }
  public void setMoney1(int money1) {
    this.money1 = money1;
  }
  public int getMoney2() {
    return money2;
  }
  public void setMoney2(int money2) {
    this.money2 = money2;
  }
  public int getMoney3() {
    return money3;
  }
  public void setMoney3(int money3) {
    this.money3 = money3;
  }
  public String getFile() {
    return file;
  }
  public void setFile(String file) {
    this.file = file;
  }
  public String getFile1() {
    return file1;
  }
  public void setFile1(String file1) {
    this.file1 = file1;
  }
  public String getFile2() {
    return file2;
  }
  public void setFile2(String file2) {
    this.file2 = file2;
  }
  public String getFile3() {
    return file3;
  }
  public void setFile3(String file3) {
    this.file3 = file3;
  }
  public String getFile4() {
    return file4;
  }
  public void setFile4(String file4) {
    this.file4 = file4;
  }
  
}

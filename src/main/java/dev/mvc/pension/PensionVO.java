package dev.mvc.pension;

public class PensionVO {
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
    photo1                          VARCHAR(200)      NULL  COMMENT  'photo1',
    photo2                          VARCHAR(200)      NULL  COMMENT  'photo2',
    photo3                          VARCHAR(200)      NULL  COMMENT  'photo3',
    photo4                          VARCHAR(200)      NULL  COMMENT  'photo4',
    photo5                          VARCHAR(200)      NULL  COMMENT  'photo5'
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
  private String  photo1;
  private String  photo2;
  private String  photo3;
  private String  photo4;
  private String  photo5;
  
  
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
  public String getPhoto1() {
    return photo1;
  }
  public void setPhoto1(String photo1) {
    this.photo1 = photo1;
  }
  public String getPhoto2() {
    return photo2;
  }
  public void setPhoto2(String photo2) {
    this.photo2 = photo2;
  }
  public String getPhoto3() {
    return photo3;
  }
  public void setPhoto3(String photo3) {
    this.photo3 = photo3;
  }
  public String getPhoto4() {
    return photo4;
  }
  public void setPhoto4(String photo4) {
    this.photo4 = photo4;
  }
  public String getPhoto5() {
    return photo5;
  }
  public void setPhoto5(String photo5) {
    this.photo5 = photo5;
  }
  
}

package dev.mvc.pension;

public class PensionVO {
 /* CREATE TABLE reservation(
      reservationo                      MEDIUMINT    NOT NULL    PRIMARY KEY AUTO_INCREMENT COMMENT '�����ȣ',
       rdate                             DATETIME     NOT NULL COMMENT '��¥',
       day                            VARCHAR(30)     NOT NULL COMMENT '�Ⱓ',
       men                             MEDIUMINT DEFAULT 0  NOT NULL COMMENT '����',
       child                             MEDIUMINT DEFAULT 0  NOT NULL COMMENT '�Ҿ�',
       baby                             MEDIUMINT DEFAULT 0  NOT NULL COMMENT '����',
       roomno                        MEDIUMINT  NULL COMMENT '���ǹ�ȣ',
    FOREIGN KEY (roomno) REFERENCES room (roomno)
  ) COMMENT='��ǿ���';
*/

  private int  reservationo;
  private String  rdate;
  private String  day;
  private int  men;
  private int  child;
  private int  baby;
  private int  roomno;
  
  
  
  public int getReservationo() {
    return reservationo;
  }
  public void setReservationo(int reservationo) {
    this.reservationo = reservationo;
  }
  public String getRdate() {
    return rdate;
  }
  public void setRdate(String rdate) {
    this.rdate = rdate;
  }
  public String getDay() {
    return day;
  }
  public void setDay(String day) {
    this.day = day;
  }
  public int getMen() {
    return men;
  }
  public void setMen(int men) {
    this.men = men;
  }
  public int getChild() {
    return child;
  }
  public void setChild(int child) {
    this.child = child;
  }
  public int getBaby() {
    return baby;
  }
  public void setBaby(int baby) {
    this.baby = baby;
  }
  public int getRoomno() {
    return roomno;
  }
  public void setRoomno(int roomno) {
    this.roomno = roomno;
  }

  
}

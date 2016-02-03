/**********************************/
/* Table Name: 펜션예약 */
/**********************************/
DROP TABLE reservation;

CREATE TABLE reservation(
    reservationo                      MEDIUMINT    NOT NULL    PRIMARY KEY AUTO_INCREMENT COMMENT '예약번호',
     rdate                             DATETIME     NOT NULL COMMENT '날짜',
     day                            VARCHAR(30)     NOT NULL COMMENT '기간',
     men                             MEDIUMINT DEFAULT 0  NOT NULL COMMENT '성인',
     child                             MEDIUMINT DEFAULT 0  NOT NULL COMMENT '소아',
     baby                             MEDIUMINT DEFAULT 0  NOT NULL COMMENT '유아',
     roomno                        MEDIUMINT  NULL COMMENT '객실번호',
  FOREIGN KEY (roomno) REFERENCES room (roomno)
) COMMENT='펜션예약';



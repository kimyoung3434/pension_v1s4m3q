/**********************************/
/* Table Name: ��ǿ��� */
/**********************************/
DROP TABLE reservation;

CREATE TABLE reservation(
    reservationo                      MEDIUMINT    NOT NULL    PRIMARY KEY AUTO_INCREMENT COMMENT '�����ȣ',
     rdate                             DATETIME     NOT NULL COMMENT '��¥',
     day                            VARCHAR(30)     NOT NULL COMMENT '�Ⱓ',
     men                             MEDIUMINT DEFAULT 0  NOT NULL COMMENT '����',
     child                             MEDIUMINT DEFAULT 0  NOT NULL COMMENT '�Ҿ�',
     baby                             MEDIUMINT DEFAULT 0  NOT NULL COMMENT '����',
     roomno                        MEDIUMINT  NULL COMMENT '���ǹ�ȣ',
  FOREIGN KEY (roomno) REFERENCES room (roomno)
) COMMENT='��ǿ���';



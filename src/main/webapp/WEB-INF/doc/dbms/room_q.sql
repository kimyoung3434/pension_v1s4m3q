/**********************************/
/* Table Name: ��ǰ���� */
/**********************************/

DROP TABLE room; 

CREATE TABLE room(
		roomno                       		 MEDIUMINT    NOT NULL  PRIMARY KEY AUTO_INCREMENT COMMENT '���ǹ�ȣ',
		room_name                    		VARCHAR(20)		  NOT NULL COMMENT '���Ǹ�',
		person_min                      		MEDIUMINT		  NOT NULL COMMENT '�ο�����',
		person_max                   		MEDIUMINT		  NOT NULL COMMENT '�ο��ִ�',
		structure                     				VARCHAR(20)		  NOT NULL  COMMENT '����',
		room_type                      		VARCHAR(20)     NOT NULL COMMENT 'Ÿ��',
		equipment                      		VARCHAR(80)		  NOT NULL COMMENT '�ü�',
		money1                      		MEDIUMINT		  NOT NULL  COMMENT 'money1',
		money2                      		MEDIUMINT		  NOT NULL COMMENT 'money2',
		money3                      		MEDIUMINT		  NOT NULL  COMMENT 'money3',
		photo1                      		VARCHAR(200)		  NULL  COMMENT  'photo1',
		photo2                      		VARCHAR(200)		  NULL  COMMENT  'photo2',
		photo3                      		VARCHAR(200)		  NULL  COMMENT  'photo3',
		photo4                      		VARCHAR(200)		  NULL  COMMENT  'photo4',
		photo5                      		VARCHAR(200)		  NULL  COMMENT  'photo5'
) COMMENT='��ǰ����';

2. ���

INSERT INTO room(roomno,room_name,person_min,person_max,structure,room_type,equipment,money1,
										money2,money3,photo1,photo2,photo3,photo4,photo5)
VALUES(1, '��������',2,2,������,����,ħ��,70000,100000,100000,'spring.jpg','summer.jpg','autumn.jpg','winter.jpg','rain.jpg');

INSERT INTO room(roomno,room_name,person_min,person_max,structure,room_type,equipment,money1,
										money2,money3,photo1,photo2,photo3,photo4,photo5)
VALUES(2, '����',4,6,�ѽ�,Ŀ��,TV,160000,230000,230000,'spring.jpg','summer.jpg','autumn.jpg','winter.jpg','rain.jpg');

INSERT INTO room(roomno,room_name,person_min,person_max,structure,room_type,equipment,money1,
										money2,money3,photo1,photo2,photo3,photo4,photo5)
VALUES(3, '������',6,8,����,��ü,�����,70000,100000,100000,'spring.jpg','summer.jpg','autumn.jpg','winter.jpg','rain.jpg');

SELECT * FROM blog;
/**********************************/
/* Table Name: 상품정보 */
/**********************************/

DROP TABLE room; 

CREATE TABLE room(
		roomno                       		 MEDIUMINT    NOT NULL  PRIMARY KEY AUTO_INCREMENT COMMENT '객실번호',
		room_name                    		VARCHAR(20)		  NOT NULL COMMENT '객실명',
		person_min                      		MEDIUMINT		  NOT NULL COMMENT '인원기준',
		person_max                   		MEDIUMINT		  NOT NULL COMMENT '인원최대',
		structure                     				VARCHAR(20)		  NOT NULL  COMMENT '구조',
		room_type                      		VARCHAR(20)     NOT NULL COMMENT '타입',
		equipment                      		VARCHAR(100)		  NOT NULL COMMENT '시설',
		money1                      		MEDIUMINT		  NOT NULL  COMMENT 'money1',
		money2                      		MEDIUMINT		  NOT NULL COMMENT 'money2',
		money3                      		MEDIUMINT		  NOT NULL  COMMENT 'money3',
	  file                      		VARCHAR(30)		  NULL  COMMENT  'file',
		file1                      		VARCHAR(30)		  NULL  COMMENT  'file1',
	  file2                      		VARCHAR(30)		  NULL  COMMENT  'file2',
		file3                      		VARCHAR(30)		  NULL  COMMENT  'file3',
		file4                      		VARCHAR(30)		  NULL  COMMENT  'file4',
		file5                      		VARCHAR(30)		  NULL  COMMENT  'file5'
) COMMENT='상품정보';

2. 등록

INSERT INTO room(room_name, person_min, person_max, structure, room_type,equipment,money1,money2,money3,file,file1,file2,file3,file4,file5)
VALUES('삶은감자',2,2,'원룸형/침대','가족','침대',70000,100000,100000,'spring.jpg','summer.jpg','autumn.jpg','winter.jpg','rain.jpg','abc.jpg');

INSERT INTO room(room_name, person_min, person_max, structure, room_type,equipment,money1,money2,money3,file,file1,file2,file3,file4,file5)
VALUES('생감자',4,6,'원룸형/한실','커플','TV',100000,140000,140000,'spring.jpg','summer.jpg','autumn.jpg','winter.jpg','rain.jpg','abc.jpg');

INSERT INTO room(room_name, person_min, person_max, structure, room_type,equipment,money1,money2,money3,file,file1,file2,file3,file4,file5)
VALUES('왕감자',6,8,'원룸형/복층','단체','냉장고',120000,120000,160000,'spring.jpg','summer.jpg','autumn.jpg','winter.jpg','rain.jpg','abc.jpg');

SELECT * FROM room;

3.목록

SELECT roomno, room_name, person_min, person_max, structure, room_type,equipment,money1,money2,money3,file,file1,file2,file3,file4,file5
FROM room
ORDER BY roomno DESC;

4) 조회
SELECT roomno, room_name, person_min, person_max, structure, room_type,equipment,money1,money2,money3,file,file1,file2,file3,file4,file5
FROM room
WHERE roomno=2;

5) 수정
UPDATE room
SET room_name='', person_min='2', person_max='2', structure='', room_type='',equipment='',money1='100000',money2='120000',money3='120000',file='',file1='',file2=''
WHERE roomno=2;


6) 삭제
DELETE FROM room
WHERE roomno=1;








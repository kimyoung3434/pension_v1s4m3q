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
		photo1                      		VARCHAR(200)		  NULL  COMMENT  'photo1',
		photo2                      		VARCHAR(200)		  NULL  COMMENT  'photo2',
		photo3                      		VARCHAR(200)		  NULL  COMMENT  'photo3',
		photo4                      		VARCHAR(200)		  NULL  COMMENT  'photo4',
		photo5                      		VARCHAR(200)		  NULL  COMMENT  'photo5'
) COMMENT='상품정보';

2. 등록

INSERT INTO room(room_name, person_min, person_max, structure, room_type,equipment,money1,money2,money3,photo1,photo2,photo3,photo4,photo5)
VALUES('삶은감자',2,2,'원룸형/침대','가족','침대',70000,100000,100000,'spring.jpg','summer.jpg','autumn.jpg','winter.jpg','rain.jpg');

INSERT INTO room(room_name, person_min, person_max, structure, room_type,equipment,money1,money2,money3,photo1,photo2,photo3,photo4,photo5)
VALUES('생감자',4,6,'원룸형/한실','커플','TV',100000,140000,140000,'spring.jpg','summer.jpg','autumn.jpg','winter.jpg','rain.jpg');

INSERT INTO room(room_name, person_min, person_max, structure, room_type,equipment,money1,money2,money3,photo1,photo2,photo3,photo4,photo5)
VALUES('왕감자',6,8,'원룸형/복층','단체','냉장고',120000,120000,160000,'spring.jpg','summer.jpg','autumn.jpg','winter.jpg','rain.jpg');

SELECT * FROM room;

3.목록

SELECT roomno, room_name, person_min, person_max, structure, room_type,equipment,money1,money2,money3,photo1,photo2,photo3,photo4,photo5
FROM room
ORDER BY roomno DESC;

4) 조회
SELECT roomno, room_name, person_min, person_max, structure, room_type,equipment,money1,money2,money3,photo1,photo2,photo3,photo4,photo5
FROM room
WHERE roomno=2;

5) 수정
UPDATE room
SET room_name='', person_min='2', person_max='2', structure='', room_type='',equipment='',money1='100000',money2='120000',money3='120000',photo1=''
WHERE roomno=2;


6) 삭제
DELETE FROM room
WHERE roomno=1;








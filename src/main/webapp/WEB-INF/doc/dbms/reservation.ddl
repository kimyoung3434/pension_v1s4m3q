/**********************************/
/* Table Name: 펜션예약 */
/**********************************/
CREATE TABLE reservation(
		reservationo                  		MEDIUMINT		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT COMMENT '목록번호',
		pay                           		MEDIUMINT		 NOT NULL COMMENT '객실요금',
		have                          		VARCHAR		 NOT NULL COMMENT '예약하기',
		empty                         		VARCHAR		 NOT NULL COMMENT '잔여객실안내',
		money                         		MEDIUMINT		 NOT NULL COMMENT '환불안내'
) COMMENT='펜션예약';


/**********************************/
/* Table Name: ��ǿ��� */
/**********************************/
CREATE TABLE reservation(
		reservationo                  		MEDIUMINT		 NOT NULL		 PRIMARY KEY AUTO_INCREMENT COMMENT '��Ϲ�ȣ',
		pay                           		MEDIUMINT		 NOT NULL COMMENT '���ǿ��',
		have                          		VARCHAR		 NOT NULL COMMENT '�����ϱ�',
		empty                         		VARCHAR		 NOT NULL COMMENT '�ܿ����Ǿȳ�',
		money                         		MEDIUMINT		 NOT NULL COMMENT 'ȯ�Ҿȳ�'
) COMMENT='��ǿ���';


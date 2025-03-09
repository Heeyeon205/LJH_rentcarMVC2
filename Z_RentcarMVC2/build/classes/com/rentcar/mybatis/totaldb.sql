-- drop table if exists user;
create database mvc2rentcarDB;
SHOW TABLES FROM mvc2rentcarDB;
use mvc2rentcarDB;

-- 유저 테이블
select* from user;
-- drop table if exists user;
create table user(
  num int auto_increment primary key,		-- 유저 고유 번호
  name varchar(30) not null,				-- 유저 이름
  userid varchar(30) unique key not null,	-- 유저 아이디
  pwd varchar(30) not null,					-- 유저 비밀번호
  email varchar(30) not null,				-- 유저 이메일
  phone varchar(30) not null				-- 유저 연락처
);

-- 렌터카 테이블
select* from rentcar;
-- drop table if exists rentcar;
CREATE TABLE rentcar(
	num INT auto_increment primary key, -- 렌트카 고유 번호 
    name VARCHAR(20), 					-- 차량 이름
    category INT, 						-- 차량 종류 
    price INT, 							-- 렌트 가격
    usepeople INT, 						-- 승차 인원
	total_qty int, 						-- 렌트카 총 수량 
    company VARCHAR(50), 				-- 차량 회사 정보
    img VARCHAR(50), 					-- 차량 이미지 
    info VARCHAR(500) 					-- 차량 정보 
);

-- 예약 테이블
select* from reservation; 
-- drop table if exists reservation;
CREATE TABLE reservation(
	reserve_seq int auto_increment primary key,	-- 예약 고유 번호
    num INT,									-- 렌터카 번호
    userid VARCHAR(50),							-- 예약자 유저 아이디
    qty INT,									-- 렌트한 수량
    dday INT,									-- 대여 기간
    rday VARCHAR(50),							-- 대여일
    usein INT,									-- 운전자 보험 여부
    usewifi INT,						 		-- 인터넷 여부
    usenavi INT,								-- 네비게이션 대여 여부
    useseat INT,								-- 베이비 시트 적용
	CONSTRAINT fk_num FOREIGN KEY(num) REFERENCES rentcar(num) ON DELETE CASCADE on update cascade,
	CONSTRAINT fk_id FOREIGN KEY(userid) REFERENCES user(userid) ON DELETE CASCADE on update cascade
);


-- 기본 유저 데이터
INSERT INTO user (name, userid, pwd, email, phone)
VALUES
  ('관리자', 'admin', 'admin', 'admin@example.com', '010-555-1234'),
  ('테스트1', 'qwer', '1234', 'qwer@example$ㅖ{.com', '010-555-5678'),
  ('테스트2', 'abcd', '1234', 'abcd@example.com', '010-555-9012');


-- 기본 렌터카 데이터
INSERT INTO rentcar VALUES (1, '아반테', 1,  2000, 4, 10,'기아', '1.jpg' , '아반테 자동차 입니다.');
INSERT INTO rentcar VALUES (2, 'BMW', 3,  6000, 4, 1, 'BMW', '2.jpg' , 'BMW 자동차 입니다.');
INSERT INTO rentcar VALUES (3, '카니발', 1,  4000, 7, 3,'기아', '3.jpg' , '카니발 자동차 입니다.');
INSERT INTO rentcar VALUES (4, '카렌스', 2,  2500, 4, 0,'기아', '4.jpg' , '카렌스 자동차 입니다.');
INSERT INTO rentcar VALUES (5, '코란도', 1,  3000, 4, 5,'현대', '5.jpg' , '코란도 자동차 입니다.');
INSERT INTO rentcar VALUES (6, '에쿠스', 3,  6000, 4, 2,'BMW', '6.jpg' , '에쿠스 자동차 입니다.');
INSERT INTO rentcar VALUES (7, '제네시스', 1,  3000, 4, 4,'기아', '7.jpg' , '제네시스 자동차 입니다.');
INSERT INTO rentcar VALUES (8, '그랜져', 1,  2400	, 4, 10,'현대', '8.jpg' , '그랜져 자동차 입니다.');
INSERT INTO rentcar VALUES (9, 'k3', 1,  2700, 4, 2,'현대', '9.jpg' , 'k3 자동차 입니다.');
INSERT INTO rentcar VALUES (10, 'k5', 2,  5000, 4, 3,'기아', '10.jpg' , 'k5 자동차 입니다.');
INSERT INTO rentcar VALUES (11, 'k9', 1,  6000, 4, 2,'현대', '11.jpg' , 'k9 자동차 입니다.');
INSERT INTO rentcar VALUES (12, '라세티', 2,  2000, 5,4, '기아', '12.jpg' , '라세티 자동차 입니다.');
INSERT INTO rentcar VALUES (13, '소나타', 1,  2000, 4, 7,'현대', '13.jpg' , 'lf소나타 자동차 입니다.');
INSERT INTO rentcar VALUES (14, '말리부', 3,  2000, 4, 8,'BMW', '14.jpg' , '말리부 자동차 입니다.');
INSERT INTO rentcar VALUES (15, '모닝', 1,  23000, 4, 9,'현대', '15.jpg' , '모닝 자동차 입니다.');
INSERT INTO rentcar VALUES (16, '올라도', 3,  5000, 4, 10,'BMW', '16.jpg' , '올라도 자동차 입니다.');
INSERT INTO rentcar VALUES (17, '레이', 2,  4000, 4, 10,'현대', '17.jpg' , '레이 자동차 입니다.');
INSERT INTO rentcar VALUES (18, 'SM5', 1,  2700, 4, 10,'BMW', '18.jpg' , 'SM5 자동차 입니다.');


-- 기본 예약데이터
INSERT INTO reservation (num, userid, qty, dday, rday, usein, usewifi, usenavi, useseat) VALUES
(1, 'qwer', 1, 3, '2024-02-01', 1, 1, 0, 0),
(2, 'qwer', 1, 5, '2024-02-02', 0, 1, 1, 1),
(3, 'qwer', 1, 7, '2024-02-03', 1, 0, 1, 1),
(1, 'qwer', 1, 4, '2024-02-04', 1, 1, 0, 0),
(4, 'qwer', 1, 6, '2024-02-04', 0, 0, 1, 1),
(2, 'qwer', 1, 8, '2024-02-02', 0, 1, 1, 1);


CREATE TABLE board (
    no INT AUTO_INCREMENT PRIMARY KEY,  -- 게시글 번호 (기본 키)
    writer VARCHAR(50) NOT NULL,        -- 작성자
    reg_date DATETIME DEFAULT CURRENT_TIMESTAMP, -- 등록 날짜 (기본값: 현재 시간)
    subject VARCHAR(255) NOT NULL,      -- 제목
    contents TEXT NOT NULL              -- 내용
);

INSERT INTO board (writer, reg_date, subject, contents)
VALUES 
('user1', NOW(), '렌터카 요금 문의', '렌터카 요금이 하루 기준으로 얼마인가요?'),
('user2', NOW(), '운전면허 조건', '렌터카를 대여하려면 몇 년 이상 운전면허가 있어야 하나요?'),
('user3', NOW(), '차량 반납 시간', '반납 시간이 늦어질 경우 추가 요금이 부과되나요?'),
('user4', NOW(), '보험 포함 여부', '렌터카 대여 시 보험이 포함되어 있나요?'),
('user5', NOW(), '차량 옵션 문의', '네비게이션과 블랙박스가 기본 제공되나요?'),
('user6', NOW(), '예약 취소 정책', '예약 후 취소하면 환불이 가능한가요?'),
('user7', NOW(), '장기 렌트 할인', '일주일 이상 렌트 시 할인이 적용되나요?'),
('user8', NOW(), '렌터카 종류', 'SUV 차량도 대여 가능한가요?'),
('user9', NOW(), '연료 규정', '반납 시 연료를 가득 채워야 하나요?'),
('user10', NOW(), '공항 픽업 서비스', '공항에서 렌터카를 픽업할 수 있나요?');

select * from user;
select * from rentcar;
select * from reservation;
select * from board;




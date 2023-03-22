CREATE TABLE student (
                         id INT NOT NULL Primary Key AUTO_INCREMENT,
                         username VARCHAR(20),
                         univ VARCHAR(20),
                         birth DATE,
                         email VARCHAR(40)
);

ALTER TABLE student ADD(tel VARCHAR(30) NOT NULL);
ALTER TABLE student ALTER username VARCHAR(10);
ALTER TABLE student DROP PRIMARY KEY;

SHOW COLUMNS FROM student;

DROP TABLE student;

INSERT INTO student(username, univ, birth, email)
VALUES ('김길동', 'AA대학교', '1999-10-21', 'kim@aa.com');
INSERT INTO student(username, univ, birth, email)
VALUES ('박사랑', 'BB대학교', '2001-1-21', 'park@bb.com');
INSERT INTO student(username, univ, birth, email)
VALUES ('나최고', 'CC대학교', '1998-7-11', 'na@cc.com');
INSERT INTO student(username, univ, birth, email)
VALUES ('김길동', 'BB대학교', '1999-03-10', 'kim@bb.com');
INSERT INTO student(username, univ, birth, email)
VALUES ('홍길동', 'AA대학교', '1999-12-10', 'hong@aa.com');

SELECT * FROM student;
SELECT username, email FROM student;

SELECT * FROM student WHERE username = '김길동';
SELECT * FROM student WHERE username = '김길동' AND univ = 'AA대학교';
SELECT * FROM student WHERE univ = 'AA대학교' OR univ = 'CC대학교';
-- '김'으로 시작하는 모든 데이터 조회
SELECT * FROM student WHERE username LIKE '김%';

-- 이름을 내림차순으로 정렬
SELECT * FROM student ORDER BY username DESC;
-- 학생이름은 오름차순으로 대학은 내림차순으로 정렬
SELECT * FROM student ORDER BY username ASC, univ DESC;

-- 중복된 이름은 하나만 가져옴
SELECT DISTINCT username FROM student;
-- 이름과 대학의 조합으로 중복 제거
SELECT DISTINCT username, univ FROM student;

CREATE TABLE student(id INT PRIMARY KEY AUTO_INCREMENT,NAME VARCHAR(20),gender VARCHAR(2));

DESC student;

DROP TABLE student;

-- 插入记录
INSERT INTO student(NAME,gender) VALUES('张三','男');

-- 查询
SELECT * FROM student;

-- 更新
UPDATE student SET NAME='王五' WHERE id=1;

DELETE FROM student WHERE id=1;


-- 模拟用户登录
-- 用户表
CREATE TABLE users(
	id INT PRIMARY KEY AUTO_INCREMENT,
	NAME VARCHAR(20),
	PASSWORD VARCHAR(20)
)

INSERT INTO users(NAME,PASSWORD) VALUES('eric','123456');
INSERT INTO users(NAME,PASSWORD) VALUES('rose','654321');

SELECT * FROM users;

-- 登录成功：用户输入的用户名和密码和users表的某条记录匹配
-- 登录失败：  找不到匹配的数据
SELECT * FROM users WHERE NAME='eric' AND PASSWORD='123456';

SELECT * FROM users;

SELECT * FROM users WHERE 1=1; -- 1=1 表示恒成立(永远成立，永远真)

-- sql注入
SELECT * FROM users WHERE NAME='eric' OR 1=1 -- 'and password='123456';


-- SELECT * FROM users WHERE NAME='eric';
-- SELECT * FROM users WHERE 1=1;

-- 创建存储过程

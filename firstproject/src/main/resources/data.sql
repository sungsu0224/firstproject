INSERT INTO Article(ID, TITLE, CONTENT) VALUES (1,'가가가가', '1111');
INSERT INTO Article(ID, TITLE, CONTENT) VALUES (2,'나나나나', '2222');
INSERT INTO Article(ID, TITLE, CONTENT) VALUES (3,'다다다다', '3333');

INSERT INTO Article(ID, TITLE, CONTENT) VALUES (4,'당신의 인생 영화는?', '댓글 고');
INSERT INTO Article(ID, TITLE, CONTENT) VALUES (5,'당신의 소울 푸드는?', '댓글 고고');
INSERT INTO Article(ID, TITLE, CONTENT) VALUES (6,'당신의 취미는?', '댓글 고고고');

INSERT INTO COMMENT(ID, ARTICLE_ID, NICKNAME, BODY) VALUES (1,4,'KIM', '가영화');
INSERT INTO COMMENT(ID, ARTICLE_ID, NICKNAME, BODY) VALUES (2,4,'PARK', '나영화');
INSERT INTO COMMENT(ID, ARTICLE_ID, NICKNAME, BODY) VALUES (3,4,'CHOI', '다영화');

INSERT INTO COMMENT(ID, ARTICLE_ID, NICKNAME, BODY) VALUES (4,5,'KIM', '가음식');
INSERT INTO COMMENT(ID, ARTICLE_ID, NICKNAME, BODY) VALUES (5,5,'PARK', '나음식');
INSERT INTO COMMENT(ID, ARTICLE_ID, NICKNAME, BODY) VALUES (6,5,'CHOI', '다음식');

INSERT INTO COMMENT(ID, ARTICLE_ID, NICKNAME, BODY) VALUES (7,6,'KIM', '가취미');
INSERT INTO COMMENT(ID, ARTICLE_ID, NICKNAME, BODY) VALUES (8,6,'PARK', '나취미');
INSERT INTO COMMENT(ID, ARTICLE_ID, NICKNAME, BODY) VALUES (9,6,'CHOI', '다취미');

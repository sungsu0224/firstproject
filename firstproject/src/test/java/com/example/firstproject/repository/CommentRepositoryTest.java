package com.example.firstproject.repository;

import com.example.firstproject.entity.Article;
import com.example.firstproject.entity.Comment;
import org.junit.jupiter.api.DisplayName;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.autoconfigure.orm.jpa.DataJpaTest;

import java.util.Arrays;
import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@DataJpaTest // JPA와 연동한 Test
class CommentRepositoryTest {

    @Autowired CommentRepository commentRepository;

    @Test
    @DisplayName("특정 게시글의 모든 댓글 조회")
    void findByArticleId() {
        /* Case 1 : 4번 게시글의 모든 댓글 조회*/
        {
            //입력 데이터 준비
            Long articleId = 4L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 예상하기
            Article article = new Article(4L, "당신의 인생 영화는?", "댓글 고");
            Comment a = new Comment(1L,article,"KIM", "가영화");
            Comment b = new Comment(2L,article,"PARK", "나영화");
            Comment c = new Comment(3L,article,"CHOI", "다영화");
            List <Comment> expected = Arrays.asList(a,b,c);

            //검증
            assertEquals(expected.toString(), comments.toString(),"4번 댓글");
        }
        /* Case 2 : 5번 게시글의 모든 댓글 조회*/
        {
            //입력 데이터 준비
            Long articleId = 5L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 예상하기
            Article article = new Article(5L, "당신의 소울 푸드는?", "댓글 고고");
            Comment a = new Comment(4L,article,"KIM", "가음식");
            Comment b = new Comment(5L,article,"PARK", "나음식");
            Comment c = new Comment(6L,article,"CHOI", "다음식");
            List <Comment> expected = Arrays.asList(a,b,c);

            //검증
            assertEquals(expected.toString(), comments.toString());
        }
        /* Case 1 : 4번 게시글의 모든 댓글 조회*/
        {
            //입력 데이터 준비
            Long articleId = 6L;

            // 실제 수행
            List<Comment> comments = commentRepository.findByArticleId(articleId);

            // 예상하기
            Article article = new Article(6L, "당신의 취미는?", "댓글 고고고");
            Comment a = new Comment(7L,article,"KIM", "가취미");
            Comment b = new Comment(8L,article,"PARK", "나취미");
            Comment c = new Comment(9L,article,"CHOI", "다취미");
            List <Comment> expected = Arrays.asList(a,b,c);

            //검증
            assertEquals(expected.toString(), comments.toString());
        }

    }

    @Test
    @DisplayName("특정 닉네임의 모든 댓글 조회")
    void findByNickname() {
        /* Case 1: "Park"의 모든 댓글 조회 */
        {
            //입렉 데이터 준비
            String nickname ="PARK";
            //실제 수행
            List<Comment> comments = commentRepository.findByNickname(nickname);
            //예상하기
            Comment a = new Comment(2L,new Article(4L,"당신의 인생 영화는?", "댓글 고"),nickname,"나영화" );
            Comment b = new Comment(5L,new Article(5L,"당신의 소울 푸드는?", "댓글 고고"),nickname,"나음식" );
            Comment c = new Comment(8L,new Article(6L,"당신의 취미는?", "댓글 고고고"),nickname,"나취미" );
            List <Comment> expected = Arrays.asList(a,b,c);

            //검증
            assertEquals(expected.toString(), comments.toString());
        }
    }
}
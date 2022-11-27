package com.example.firstproject.service;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.entity.Article;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@SpringBootTest //해당 클래스는 스프링 부트와 연동되어 테스트 된다!
class ArticleServiceTest {

    @Autowired
    ArticleService articleService;

    @Test
    void index() {
        //예상

        //실제
        List<Article> articles = articleService.index();

        //비교
    }

    @Test
    void show_성공__존재하는_id_입력() {
        //예상
        Long id = 1L;
        Article expected = new Article(id,"가가가가","1111");

        //실제
        Article article = articleService.show(id);

        //입력
        assertEquals(expected.toString(),article.toString());


    }

    @Test
    void show_실패__존재하지않는_id_입력() {
        //예상
        Long id = 1L;
        Article expected = null;

        //실제
        Article article = articleService.show(id);

        //입력
        assertEquals(expected,article.toString());
    }

    @Test
    void create_성공__title과_content만_있는_dto입력(){
        //예상
        String title = "";
        String content = "";
        ArticleForm dto = new ArticleForm(title,content);
        Article expected = new Article();


        //실제
        Article article = articleService.create(dto);

        //입력

    }
    @Test
    void create_실패__(){

    }
}
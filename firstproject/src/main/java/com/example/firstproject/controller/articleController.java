package com.example.firstproject.controller;

import com.example.firstproject.dto.ArticleForm;
import com.example.firstproject.dto.CommentDto;
import com.example.firstproject.entity.Article;
import com.example.firstproject.repository.ArticleRepository;
import com.example.firstproject.service.CommentService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;

import javax.persistence.GeneratedValue;
import java.util.List;


@Controller
@Slf4j // 로깅을 위한 어노테이션
public class articleController {


    @Autowired // 스프링 부트가 미리 생성해놓은 객체를 가져다가 자동 연걸!
    private ArticleRepository articleRepository;
    @Autowired
    private CommentService commentService;
    @GetMapping("/articles/new")
    public String newArticleForm (){
        return "articles/new";
    }

    @PostMapping("/articles/create")
    public String createArticle(ArticleForm form) {
        //System.out.println(form.toString()); ->로깅기능으로 대체!
        log.info(form.toString());

        //1. Dto를 변환! Entity!
        Article article = form.toEntity();
        //System.out.println(article.toString());
        log.info(article.toString());
        //2, Repository에게 Entity를 DB안에 저장하게 함! id를 자동 생성함..
        Article saved = articleRepository.save(article);
        //System.out.println(saved.toString());
        log.info(saved.toString());
        return "redirect:/articles/" + saved.getId();

    }

    @GetMapping("/articles/{id}")
    public String show(@PathVariable Long id, Model model) {
        log.info("id =" + id);

        //1. id를 데이터로 가져옴
        Article articleEntity = articleRepository.findById(id).orElse(null);
        List<CommentDto> commentDtos = commentService.comments(id);

        //2. 가져온 데이터를 모델에 등록
        model.addAttribute("articles",articleEntity);
        model.addAttribute("commentDtos", commentDtos);
        //3. 보여줄 페이지를 설정
        return "articles/show";
    }

    @GetMapping("/articles")
    public String index(Model model){
        //1, 모든 article을 가져온다.
        List<Article> articleEntityList = articleRepository.findAll();

        //2. 가져온 article 묶음을 view로 전달
        model.addAttribute("articleList",articleEntityList);

        //3. 뷰 페이지 설정
        return "articles/index";
    }

    @GetMapping("/articles/{id}/edit")
    public String edit(@PathVariable Long id, Model model){
        // 수정할 데이터를 가져오기
        Article articleEntity = articleRepository.findById(id).orElse(null);
        // 뷰 페이지 설정!
        model.addAttribute("article",articleEntity);
        return "articles/edit";
    }

    @GetMapping("/articles/{id}/delete")
    public String delete(@PathVariable Long id, RedirectAttributes rttr){
        log.info("삭제 요청이 들어왔습니다!");

        //1. 삭제 대상을 가져온다

        Article target = articleRepository.findById(id).orElse(null);
        log.info(target.toString());
        //2. 대상을 삭제한다.
        if(target != null){
            articleRepository.delete(target);
            rttr.addFlashAttribute("msg","삭제가 완료되었습니다!");

        }

        //3. 결과 페이지로 리다이렉트

        return "redirect:/articles";
    }
}

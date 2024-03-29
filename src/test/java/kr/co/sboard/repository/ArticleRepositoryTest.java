package kr.co.sboard.repository;

import jakarta.transaction.Transactional;
import kr.co.sboard.entity.Article;
import lombok.extern.slf4j.Slf4j;
import org.junit.jupiter.api.Test;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;

import java.util.List;

import static org.junit.jupiter.api.Assertions.*;

@Slf4j
@SpringBootTest
class ArticleRepositoryTest {

    @Autowired
    private ArticleRepository articleRepository;

    @Test
    @Transactional
    public void getBoardListWithNick(){

        Pageable pageable = PageRequest.of(0, 10, Sort.by("no").descending());

        Page<Article> articles = articleRepository.findByParentAndCate(0, "notice", pageable);

        for(Article article: articles){
            log.info("article : " + article);
        }




    }



}
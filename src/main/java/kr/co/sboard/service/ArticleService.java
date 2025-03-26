package kr.co.sboard.service;

import com.querydsl.core.Tuple;
import kr.co.sboard.dao.ArticleMapper;
import kr.co.sboard.dto.ArticleDTO;
import kr.co.sboard.entity.Article;
import kr.co.sboard.repository.ArticleRepository;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.stereotype.Service;

import javax.swing.text.html.parser.Entity;
import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Component
public class ArticleService {

    private final ArticleRepository articleRepository;
    private final ArticleMapper articleMapper;
    private final ModelMapper modelMapper;


    public List<ArticleDTO> findAll() {
        List<Tuple> articles = articleRepository.selectAllForList();
        log.info("articles : {}", articles);
        // Article Entity 리스트를 ArticleDTO 리스트로 변환

        List<ArticleDTO> articleDTOList = articles.stream().map(tuple -> {

            Article article = tuple.get(0, Article.class);
            String nick = tuple.get(1, String.class);

            ArticleDTO articleDTO = modelMapper.map(article, ArticleDTO.class);
            articleDTO.setNick(nick);

            return articleDTO;

        }).toList();

        return articleDTOList;
    }


    public int register(ArticleDTO articleDTO){

        // 엔티티 변환
        Article article = modelMapper.map(articleDTO, Article.class);
        log.info("article : {}", article);

        // JPA 저장
        //Article savedArticle = articleRepository.save(article);
        // 저장한 글번호 반환
        //return savedArticle.getNo();

        // Mybatis 저장
        articleMapper.insertArticle(articleDTO);

        // 매개변수로 전달되는 articleDTO의 no 속성에 mybatis가 INSERT한 데이터의 pk값을 반환
        int no = articleDTO.getNo();

        return no;
    }

}

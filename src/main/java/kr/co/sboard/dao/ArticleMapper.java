package kr.co.sboard.dao;

import kr.co.sboard.dto.ArticleDTO;
import org.apache.ibatis.annotations.Mapper;

@Mapper
public interface ArticleMapper {

    public void insertArticle(ArticleDTO articleDTO);

}

package kr.co.sboard.repository.custom;

import com.querydsl.core.Tuple;
import kr.co.sboard.entity.Article;

import java.util.List;


public interface ArticleRepositoryCustom {

    public List<Tuple> selectAllForList();



}

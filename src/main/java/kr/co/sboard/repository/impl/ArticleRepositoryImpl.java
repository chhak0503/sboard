package kr.co.sboard.repository.impl;

import com.querydsl.core.Tuple;
import com.querydsl.jpa.impl.JPAQueryFactory;
import kr.co.sboard.entity.QArticle;
import kr.co.sboard.entity.QUser;
import kr.co.sboard.repository.custom.ArticleRepositoryCustom;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Repository;

import java.util.List;

@Slf4j
@RequiredArgsConstructor
@Repository
public class ArticleRepositoryImpl implements ArticleRepositoryCustom {

    private final JPAQueryFactory queryFactory;
    private QArticle qArticle = QArticle.article;
    private QUser qUser = QUser.user;

    @Override
    public List<Tuple> selectAllForList() {

        List<Tuple> tupleList = queryFactory
                                        .select(qArticle, qUser.nick)
                                        .from(qArticle)
                                        .join(qUser)
                                        .on(qArticle.writer.eq(qUser.uid))
                                        .orderBy(qArticle.no.desc())
                                        .fetch();

        return tupleList;
    }
}

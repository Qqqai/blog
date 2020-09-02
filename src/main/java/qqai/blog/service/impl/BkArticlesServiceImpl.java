package qqai.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import qqai.blog.entity.*;
import qqai.blog.interceptor.UserInterceptor;
import qqai.blog.mapper.BkArticlesMapper;
import qqai.blog.service.*;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import qqai.blog.vo.ArticlesInfoVo;
import qqai.blog.vo.ArticlesVo;
import qqai.blog.vo.CommentInfoVo;
import qqai.blog.vo.PublishVo;

import java.util.ArrayList;
import java.util.Date;
import java.util.List;
import java.util.stream.Collectors;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qqai
 * @since 2020-08-29
 */
@Service
public class BkArticlesServiceImpl extends ServiceImpl<BkArticlesMapper, BkArticles> implements BkArticlesService {

    @Autowired
    private BkLinkService bkLinkService;

    @Autowired
    private BkCommentsService bkCommentsService;

    @Autowired
    private BkUserSubjectRelationService bkUserSubjectRelationService;

    @Override
    public void publish(PublishVo vo) {
        BkUsers me = UserInterceptor.local.get();

        //初始化博文表内容
        BkArticles articles = new BkArticles();
        articles.setUserId(me.getUserId());
        articles.setArticleTitle(vo.getTitle());
        articles.setArticleContent(vo.getContent());
        articles.setArticleDate(new Date());
        articles.setArticleCommentCount(0L);
        articles.setArticleLikeCount(0L);
        articles.setArticleViews(0L);
        articles.setSubjectId(vo.getSubId());
        articles.setArticleType(vo.getType());
        //保存
        this.save(articles);
    }

    /**
     * 获取当前分类下的所有文章  按时间降序排序
     *
     * @param articlesId
     * @return
     */
    @Override
    public ArticlesInfoVo articles(Long articlesId) {
        ArticlesInfoVo vo = new ArticlesInfoVo();

        BkArticles articles = this.getOne(new QueryWrapper<BkArticles>().eq("article_id", articlesId));

        BkUserSubjectRelation subjectRelation = bkUserSubjectRelationService.getOne(new QueryWrapper<BkUserSubjectRelation>().eq("subject_id", articles.getSubjectId()));

        vo.setSubId(subjectRelation.getSubjectId());
        vo.setSubjectName(subjectRelation.getSubjectName());
        vo.setArticles(articles);

        List<CommentInfoVo> infoVos = bkCommentsService.getCommentInfoByArticlesId(articlesId);

        vo.setInfoVos(infoVos);

        return vo;
    }

    /**
     * 获取当前用户的所有文章
     */
    @Override
    public ArticlesVo articlesForUserId(Long userId) {
        ArticlesVo articlesVo = new ArticlesVo();
        List<BkArticles> list = this.list(new QueryWrapper<BkArticles>().eq("user_id", userId));
        articlesVo.setVos(list);
        List<BkLink> links = bkLinkService.list(null);
        List<BkLink> type0 = new ArrayList<>();
        List<BkLink> type1 = new ArrayList<>();
        for (BkLink link : links) {
            if (link.getBkLinkType() == 0) {
                type0.add(link);
            } else {
                type1.add(link);
            }
        }
        articlesVo.setType0Links(type0);
        articlesVo.setType1Links(type1);
        return articlesVo;
    }


}

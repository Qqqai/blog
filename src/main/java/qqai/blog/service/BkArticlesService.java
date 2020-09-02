package qqai.blog.service;

import qqai.blog.entity.BkArticles;
import com.baomidou.mybatisplus.extension.service.IService;
import qqai.blog.vo.ArticlesInfoVo;
import qqai.blog.vo.ArticlesVo;
import qqai.blog.vo.PublishVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qqai
 * @since 2020-08-29
 */
public interface BkArticlesService extends IService<BkArticles> {

    void publish(PublishVo vo);

    ArticlesInfoVo articles(Long articlesId);

    ArticlesVo articlesForUserId(Long userId);
}

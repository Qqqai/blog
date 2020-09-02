package qqai.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.*;

import qqai.blog.entity.BkArticles;
import qqai.blog.service.BkArticlesService;
import qqai.blog.service.BkCommentsService;
import qqai.blog.utils.R;
import qqai.blog.vo.ArticlesInfoVo;
import qqai.blog.vo.ArticlesVo;
import qqai.blog.vo.PublishVo;

import java.util.List;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qqai
 * @since 2020-08-29
 */
@Controller
@RequestMapping("/blog/bk-articles")
public class BkArticlesController {

    @Autowired
    private BkArticlesService bkArticlesService;


    @GetMapping("/{articlesId}/articles")
//    @ResponseBody
    public String articles(@PathVariable Long articlesId, Model model) {
        ArticlesInfoVo articles = bkArticlesService.articles(articlesId);
        model.addAttribute("articles", articles);
//        return R.ok().setData(articles);
        return "blog";
    }

    /**
     * 发表文章
     */
    @PostMapping("/publish")
    public String publish(PublishVo vo) {
        bkArticlesService.publish(vo);
        return "index";
    }


}


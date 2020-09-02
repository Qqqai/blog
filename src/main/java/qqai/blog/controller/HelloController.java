package qqai.blog.controller;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import qqai.blog.constant.UserConstant;
import qqai.blog.entity.BkUserSubjectRelation;
import qqai.blog.entity.BkUsers;
import qqai.blog.service.BkArticlesService;
import qqai.blog.service.BkUserSubjectRelationService;
import qqai.blog.service.BkUsersService;
import qqai.blog.vo.ArticlesVo;

import javax.servlet.http.HttpServletResponse;
import javax.servlet.http.HttpSession;
import java.io.IOException;
import java.util.List;

/**
 * 描述：
 *
 * @author qqai
 * @createTime 2020-08-29 17:01
 */

@Controller
public class HelloController {

    @Autowired
    private BkUsersService bkUsersService;

    @Autowired
    private BkUserSubjectRelationService bkUserSubjectRelationService;

    @Autowired
    private BkArticlesService bkArticlesService;

    @GetMapping({"/", "/index.html"})
    public String hello(HttpSession session, Model model) {
        BkUsers me = bkUsersService.getById(1);
        List<BkUserSubjectRelation> relation = bkUserSubjectRelationService.list(new QueryWrapper<BkUserSubjectRelation>().eq("user_id", me.getUserId()));
        me.setRelations(relation);
        session.setAttribute(UserConstant.SESSION_USER_ID, me);
        ArticlesVo vo = bkArticlesService.articlesForUserId(me.getUserId());
        model.addAttribute("vo", vo);
        return "index";
    }

    @PostMapping("/auth")
    public String auth(HttpSession session, String authword, Model model) {
        if (!StringUtils.isEmpty(authword)) {
            if (authword.equals(UserConstant.USER_AUTH_PASSWORD)) {
                session.setAttribute("ok", "ok");
            } else {
                model.addAttribute("msg", " 认证失败 请重新尝试");
            }
        } else {
            model.addAttribute("msg", " 认证失败 请重新尝试");
        }
        BkUsers me = (BkUsers) session.getAttribute(UserConstant.SESSION_USER_ID);
        ArticlesVo vo = bkArticlesService.articlesForUserId(me.getUserId());
        model.addAttribute("vo", vo);
        return "index";
    }

    @GetMapping("/blog/input")
    public String blogInput(Model model) {
        return "blogs-input";
    }


    /**
     * 下载简历
     */
    @GetMapping("/down/resume/excel")
    public void downResumeExcel(HttpServletResponse response) throws IOException {
        bkUsersService.download(response);
//        return R.ok();
    }

}

package qqai.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.util.StringUtils;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import qqai.blog.service.BkUserSubjectRelationService;
import qqai.blog.vo.SubVo;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qqai
 * @since 2020-08-29
 */
@Controller
@RequestMapping("/blog/bk-user-subject-relation")
public class BkUserSubjectRelationController {

    @Autowired
    private BkUserSubjectRelationService bkUserSubjectRelationService;

    @PostMapping("/add/subject")
    public String addSubject(SubVo vo) {
        if (StringUtils.isEmpty(vo.getSubName()) || StringUtils.isEmpty(vo.getSchedule())) {
        } else {
            bkUserSubjectRelationService.addSubject(vo);
        }
        return "redirect:/index.html";
    }

}


package qqai.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.mvc.support.RedirectAttributes;
import qqai.blog.entity.BkLink;
import qqai.blog.service.BkLinkService;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qqai
 * @since 2020-09-01
 */
@Controller
@RequestMapping("/blog/bk-link")
public class BkLinkController {

    @Autowired
    private BkLinkService bkLinkService;

    @PostMapping("/add/link")
    public String addLink(BkLink link, RedirectAttributes redirectAttributes) {
        try {
            bkLinkService.save(link);
        } catch (RuntimeException e) {
            redirectAttributes.addFlashAttribute("msg", "添加失败");
        }
        return "redirect:/index.html";
    }
}


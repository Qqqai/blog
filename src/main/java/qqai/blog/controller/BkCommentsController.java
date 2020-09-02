package qqai.blog.controller;


import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;

import org.springframework.web.bind.annotation.RestController;
import qqai.blog.service.BkCommentsService;
import qqai.blog.utils.R;
import qqai.blog.vo.CommentVO;

/**
 * <p>
 * 前端控制器
 * </p>
 *
 * @author qqai
 * @since 2020-08-29
 */
@RestController
@RequestMapping("/blog/bk-comments")
public class BkCommentsController {

    @Autowired
    private BkCommentsService bkCommentsService;

    @PostMapping("/comment")
    public R comment(@RequestBody CommentVO vo) {
        bkCommentsService.comment(vo);
        return R.ok();
    }

}


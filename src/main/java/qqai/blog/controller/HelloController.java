package qqai.blog.controller;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import qqai.blog.utils.R;

/**
 * 描述：
 *
 * @author qqai
 * @createTime 2020-08-29 17:01
 */

@RestController
public class HelloController {

    @GetMapping("/")
    public R hello() {
        return R.ok().setData("hhhhh，想不到啊");
    }

}

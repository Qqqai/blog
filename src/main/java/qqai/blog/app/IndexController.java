package qqai.blog.app;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;
import qqai.blog.entity.BkUserSubjectRelation;
import qqai.blog.entity.BkUsers;
import qqai.blog.service.BkUserSubjectRelationService;
import qqai.blog.utils.R;

import javax.servlet.http.HttpSession;

/**
 * 描述：json数据首页
 *
 * @author qqai
 * @createTime 2020-08-29 21:28
 */

@RestController
public class IndexController {

    @Autowired
    private BkUserSubjectRelationService bkUserSubjectRelationService;

    /**
     * 首页技术属性进度条的内容
     *
     * @param session
     * @return
     */
    @GetMapping("/subject/info")
    public R getSubjectInfo(HttpSession session) {
        BkUsers me = (BkUsers) session.getAttribute("me");
        Long userId = me.getUserId();
        BkUserSubjectRelation relation = bkUserSubjectRelationService.getOne(new QueryWrapper<BkUserSubjectRelation>().eq("user_id", userId));
        return R.ok().setData(relation);
    }

}

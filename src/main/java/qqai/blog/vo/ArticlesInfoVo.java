package qqai.blog.vo;

import lombok.Data;
import qqai.blog.entity.BkArticles;
import qqai.blog.entity.BkComments;
import qqai.blog.entity.BkUserFriends;

import java.util.List;

/**
 * 描述：某个博文详细信息
 *
 * @author qqai
 * @createTime 2020-08-31 13:21
 */

@Data
public class ArticlesInfoVo {
    private Long subId;

    private String subjectName;

    private BkArticles articles;

    private List<CommentInfoVo> infoVos;
}

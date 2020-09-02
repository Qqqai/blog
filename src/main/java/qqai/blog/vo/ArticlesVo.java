package qqai.blog.vo;

import lombok.Data;
import qqai.blog.entity.BkArticles;
import qqai.blog.entity.BkLink;

import java.util.List;

/**
 * 描述：某一个分类下的所有文章
 *
 * @author qqai
 * @createTime 2020-08-30 14:47
 */

@Data
public class ArticlesVo {

    private Long subId;

    private String subjectName;

    private List<BkArticles> vos;

    private List<BkLink> type0Links;

    private List<BkLink> type1Links;
}

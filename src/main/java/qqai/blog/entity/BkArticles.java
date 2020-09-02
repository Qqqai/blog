package qqai.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;

import lombok.Data;
import lombok.EqualsAndHashCode;

/**
 * <p>
 *
 * </p>
 *
 * @author qqai
 * @since 2020-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BkArticles implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "article_id", type = IdType.AUTO)
    private Long articleId;

    private Long userId;

    private String articleTitle;

    private String articleContent;

    private Long articleViews;

    private Long articleCommentCount;

    private Date articleDate;

    private Long articleLikeCount;

    private Long subjectId;

    private int articleType;


}

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

public class BkComments implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "comment_id", type = IdType.AUTO)
    private Long commentId;

    private Long userId;

    private Long articleId;

    private Long commentLikeCount;

    private Date commentDate;

    private String commentContent;

    private Long parentCommentId;


}

package qqai.blog.vo;

import lombok.Data;

/**
 * 描述：发布评论vo
 *
 * @author qqai
 * @createTime 2020-08-31 15:03
 */

@Data
public class CommentVO {

    //  articleId: articleId,
    //  comment: comment,
    //  userName: userName,
    //  userEmail: userEmail
    private Long articleId;
    private String comment;
    private String userName;
    private String userEmail;

}

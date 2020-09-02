package qqai.blog.vo;

import lombok.Data;

import java.util.Date;

/**
 * 描述：评论详细信息vo
 *
 * @author qqai
 * @createTime 2020-08-31 20:45
 */

@Data
public class CommentInfoVo {

    private String userName;

    private String userEmail;

    private Long userId;

    private Long commentId;

    private Date commentDate;

    private String commentContent;

}

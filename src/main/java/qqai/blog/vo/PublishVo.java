package qqai.blog.vo;

import lombok.Data;

/**
 * 描述：文章vo
 *
 * @author qqai
 * @createTime 2020-08-30 14:06
 */

@Data
public class PublishVo {

    private Long subId;

    private String title;

    private int type;

    private String content;

}

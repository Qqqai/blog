package qqai.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;
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
 * @since 2020-09-01
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BkLink implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 链接地址的标题
     */
    @TableId(value = "bk_link_title", type = IdType.ID_WORKER_STR)
    private String bkLinkTitle;

    /**
     * 链接地址
     */
    private String bkLinkUrl;

    private int BkLinkType;


}

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
 * @since 2020-08-31
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BkUserFriends implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 标识ID
     */
      @TableId(value = "id", type = IdType.AUTO)
    private Long id;

    /**
     * 用户名
     */
    private String userName;

    /**
     * 用户邮箱
     */
    private String userEmail;


}

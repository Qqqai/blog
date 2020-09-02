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
 * @since 2020-08-29
 */
@Data
@EqualsAndHashCode(callSuper = false)
public class BkSetArtitleSort implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "article_id", type = IdType.INPUT)
    private Long articleId;
    private Long subjectId;


}

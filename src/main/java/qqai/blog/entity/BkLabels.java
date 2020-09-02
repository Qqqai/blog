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
public class BkLabels implements Serializable {

    private static final long serialVersionUID = 1L;

      @TableId(value = "label_id", type = IdType.AUTO)
    private Long labelId;

    private String labelName;

    private String labelAlias;

    private String labelDescription;


}

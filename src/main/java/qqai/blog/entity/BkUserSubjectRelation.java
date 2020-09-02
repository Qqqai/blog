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
public class BkUserSubjectRelation implements Serializable {

    private static final long serialVersionUID = 1L;

    /**
     * 用户所展示的科目id
     */
      @TableId(value = "subject_id", type = IdType.AUTO)
    private Long subjectId;

    /**
     * 用户id
     */
    private Long userId;

    /**
     * 用户所展示的科目名字
     */
    private String subjectName;

    /**
     * 用户所展示的科目的学习进度
     */
    private Integer subjectSchedule;


}

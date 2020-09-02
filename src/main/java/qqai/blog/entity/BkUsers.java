package qqai.blog.entity;

import com.baomidou.mybatisplus.annotation.IdType;

import java.util.Date;

import com.baomidou.mybatisplus.annotation.TableField;
import com.baomidou.mybatisplus.annotation.TableId;

import java.io.Serializable;
import java.util.List;

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
public class BkUsers implements Serializable {

    private static final long serialVersionUID = 1L;

    @TableId(value = "user_id", type = IdType.AUTO)
    private Long userId;

    private String userIp;

    private String userName;

    private String userPassword;

    private String userEmail;

    private String userProfilePhoto;

    private Date userRegistrationTime;

    private Date userBirthday;

    private Integer userAge;

    private String userTelephoneNumber;

    private String userNickname;

    private String userDescription;

    private String userKeywords;

    private String userGithubAddress;

    private String userHtmlTitle;

    @TableField(exist = false)
    private List<BkUserSubjectRelation> relations;


}

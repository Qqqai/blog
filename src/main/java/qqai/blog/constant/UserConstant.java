package qqai.blog.constant;

import lombok.Data;
import org.springframework.beans.factory.InitializingBean;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.boot.context.properties.EnableConfigurationProperties;
import org.springframework.stereotype.Component;

/**
 * 描述：常量
 *
 * @author qqai
 * @createTime 2020-08-30 14:20
 */

@Component
public class UserConstant implements InitializingBean {

    public static String SESSION_USER_ID = "me";

    @Value("${user.auth.admin.password}")
    private String password = "..ai0301";

    public static String USER_AUTH_PASSWORD;

    @Override
    public void afterPropertiesSet() throws Exception {
        USER_AUTH_PASSWORD = this.password;
    }
}

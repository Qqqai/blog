package qqai.blog.config;

import org.mybatis.spring.annotation.MapperScan;
import org.springframework.context.annotation.Configuration;

/**
 * 描述：MybatisPlus配置
 *
 * @author qqai
 * @createTime 2020-08-29 19:46
 */

@Configuration
@MapperScan(basePackages = "qqai.blog.mapper")
public class MybatisPlusConfig {



}

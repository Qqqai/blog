package qqai.blog.service;

import qqai.blog.entity.BkUsers;
import com.baomidou.mybatisplus.extension.service.IService;

import javax.servlet.http.HttpServletResponse;
import java.io.IOException;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qqai
 * @since 2020-08-29
 */
public interface BkUsersService extends IService<BkUsers> {

    void download(HttpServletResponse response) throws IOException;

}

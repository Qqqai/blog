package qqai.blog.service.impl;

import org.springframework.beans.factory.annotation.Autowired;
import qqai.blog.entity.BkUsers;
import qqai.blog.mapper.BkUsersMapper;
import qqai.blog.service.BkUserSubjectRelationService;
import qqai.blog.service.BkUsersService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;

import javax.servlet.http.HttpServletResponse;
import java.io.*;
import java.net.URLEncoder;
import java.nio.file.Files;
import java.nio.file.Paths;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qqai
 * @since 2020-08-29
 */
@Service
public class BkUsersServiceImpl extends ServiceImpl<BkUsersMapper, BkUsers> implements BkUsersService {

    @Autowired
    private BkUserSubjectRelationService bkUserSubjectRelationService;


    @Override
    public void download(HttpServletResponse response) throws IOException {
        File file = new File("src/main/resources/static/jianli/陈爱全 简历.doc");
        if (!file.exists()) {
            throw new RuntimeException("文件不存在");
        }
//        response.setContentType("application/force-download");
        response.addHeader("Content-Disposition", "attachment;fileName=" + URLEncoder.encode(file.getName(), "UTF-8"));
        // 设置Headers
        // response.setContentType("application/force-download");
        response.setHeader("Content-Type", "application/octet-stream;charset=utf-8"); // 告诉浏览器输出内容为流
//        FileUtil.download(file, response);

        Files.copy(Paths.get(file.getAbsolutePath()), response.getOutputStream());
    }


}

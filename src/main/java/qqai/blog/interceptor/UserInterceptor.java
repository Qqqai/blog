package qqai.blog.interceptor;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Component;
import org.springframework.util.AntPathMatcher;
import org.springframework.web.servlet.HandlerInterceptor;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;
import qqai.blog.constant.UserConstant;
import qqai.blog.entity.BkUserSubjectRelation;
import qqai.blog.entity.BkUsers;
import qqai.blog.service.BkUserSubjectRelationService;
import qqai.blog.service.BkUsersService;

import javax.servlet.http.HttpServletRequest;
import javax.servlet.http.HttpServletResponse;
import java.util.List;

/**
 * 描述：拦截器  给每一个请求加上这个拦截器之后可以更快速的获取用户信息
 *
 * @author qqai
 * @createTime 2020-08-30 14:10
 */

@Component
public class UserInterceptor implements HandlerInterceptor {
    public static ThreadLocal<BkUsers> local = new ThreadLocal<>();

    @Autowired
    private BkUsersService bkUsersService;

    @Autowired
    private BkUserSubjectRelationService bkUserSubjectRelationService;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        String requestURI = request.getRequestURI();  //请求路径 不带服务器地址
        boolean match = new AntPathMatcher().match("/**", requestURI);
        if (match) {
            BkUsers me = (BkUsers) request.getSession().getAttribute(UserConstant.SESSION_USER_ID);
            if (me == null) {
                me = bkUsersService.getById(1);
                List<BkUserSubjectRelation> relation = bkUserSubjectRelationService.list(new QueryWrapper<BkUserSubjectRelation>().eq("user_id", me.getUserId()));
                me.setRelations(relation);
                request.getSession().setAttribute(UserConstant.SESSION_USER_ID, me);
            }
            local.set(me);
            return true;
        }
        return true;
    }


}

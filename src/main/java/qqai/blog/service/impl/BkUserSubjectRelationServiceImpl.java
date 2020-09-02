package qqai.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import qqai.blog.entity.BkUserSubjectRelation;
import qqai.blog.entity.BkUsers;
import qqai.blog.interceptor.UserInterceptor;
import qqai.blog.mapper.BkUserSubjectRelationMapper;
import qqai.blog.service.BkUserSubjectRelationService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import qqai.blog.vo.SubVo;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qqai
 * @since 2020-08-29
 */
@Service
public class BkUserSubjectRelationServiceImpl extends ServiceImpl<BkUserSubjectRelationMapper, BkUserSubjectRelation> implements BkUserSubjectRelationService {

    @Override
    public void addSubject(SubVo vo) {
        BkUserSubjectRelation one = this.getOne(new QueryWrapper<BkUserSubjectRelation>().eq("subject_name", vo.getSubName()));
        if (one != null) {
            //修改
            one.setSubjectSchedule(vo.getSchedule());
            this.updateById(one);
        } else {
            BkUsers me = UserInterceptor.local.get();
            BkUserSubjectRelation relation = new BkUserSubjectRelation();
            relation.setUserId(me.getUserId());
            relation.setSubjectName(vo.getSubName());
            relation.setSubjectSchedule(vo.getSchedule());
            this.save(relation);
        }
    }
}

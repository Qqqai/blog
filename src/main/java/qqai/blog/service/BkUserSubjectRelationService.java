package qqai.blog.service;

import qqai.blog.entity.BkUserSubjectRelation;
import com.baomidou.mybatisplus.extension.service.IService;
import qqai.blog.vo.SubVo;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qqai
 * @since 2020-08-29
 */
public interface BkUserSubjectRelationService extends IService<BkUserSubjectRelation> {

    void addSubject(SubVo vo);
}

package qqai.blog.service;

import qqai.blog.entity.BkComments;
import com.baomidou.mybatisplus.extension.service.IService;
import qqai.blog.vo.CommentInfoVo;
import qqai.blog.vo.CommentVO;

import java.util.List;

/**
 * <p>
 *  服务类
 * </p>
 *
 * @author qqai
 * @since 2020-08-29
 */
public interface BkCommentsService extends IService<BkComments> {

    void comment(CommentVO vo);

    List<BkComments> getCommentByArtilclesId(Long articlesId);

    List<CommentInfoVo> getCommentInfoByArticlesId(Long articlesId);
}

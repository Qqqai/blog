package qqai.blog.mapper;

import org.apache.ibatis.annotations.Param;
import qqai.blog.entity.BkComments;
import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import qqai.blog.vo.CommentInfoVo;

import java.util.List;

/**
 * <p>
 *  Mapper 接口
 * </p>
 *
 * @author qqai
 * @since 2020-08-29
 */
public interface BkCommentsMapper extends BaseMapper<BkComments> {

    List<CommentInfoVo> getCommentInfoByArticlesId(@Param("articlesId") Long articlesId);
}

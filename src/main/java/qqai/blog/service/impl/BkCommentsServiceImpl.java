package qqai.blog.service.impl;

import com.baomidou.mybatisplus.core.conditions.query.QueryWrapper;
import org.springframework.beans.factory.annotation.Autowired;
import qqai.blog.entity.BkComments;
import qqai.blog.entity.BkUserFriends;
import qqai.blog.mapper.BkCommentsMapper;
import qqai.blog.service.BkCommentsService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import qqai.blog.service.BkUserFriendsService;
import qqai.blog.vo.CommentInfoVo;
import qqai.blog.vo.CommentVO;

import java.util.Date;
import java.util.List;

/**
 * <p>
 * 服务实现类
 * </p>
 *
 * @author qqai
 * @since 2020-08-29
 */
@Service
public class BkCommentsServiceImpl extends ServiceImpl<BkCommentsMapper, BkComments> implements BkCommentsService {

    @Autowired
    private BkUserFriendsService bkUserFriendsService;

    @Override
    public void comment(CommentVO vo) {

        BkUserFriends one = bkUserFriendsService.getOne(new QueryWrapper<BkUserFriends>().eq("user_name", vo.getUserName())
                .eq("user_email", vo.getUserEmail()));
        BkUserFriends friends = null;
        if (one != null) {
            friends = one;
        } else {
            friends = new BkUserFriends();
            friends.setUserName(vo.getUserName());
            friends.setUserEmail(vo.getUserEmail());
            bkUserFriendsService.save(friends);
        }
        BkComments bkComments = new BkComments();
        bkComments.setArticleId(vo.getArticleId());
        bkComments.setCommentContent(vo.getComment());
        bkComments.setCommentDate(new Date());
        bkComments.setCommentLikeCount(0L);
        bkComments.setUserId(friends.getId());
        this.save(bkComments);
    }

    @Override
    public List<BkComments> getCommentByArtilclesId(Long articlesId) {

        return this.list(new QueryWrapper<BkComments>().eq("article_id", articlesId));
    }

    @Override
    public List<CommentInfoVo> getCommentInfoByArticlesId(Long articlesId) {
        return this.baseMapper.getCommentInfoByArticlesId(articlesId);
    }
}

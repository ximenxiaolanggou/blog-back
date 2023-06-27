package center.helloworld.blog.app.blog.service;

import center.helloworld.blog.common.base.PageResult;
import com.baomidou.mybatisplus.extension.service.IService;
import center.helloworld.blog.app.blog.entity.BlogArticle;
import center.helloworld.blog.app.blog.vo.BlogArticleSearchVO;

/**
 * <p>
 *
 * </p>
 *
 * @author zhishun.cai
 * @since 2022/5/9 16:09
 */
public interface BlogArticleService extends IService<BlogArticle> {

    /**
     * 分页
     * @param pageNumber
     * @param pageSize
     * @param searchVO
     * @return
     */
    PageResult page(Integer pageNumber, Integer pageSize, BlogArticleSearchVO searchVO);

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    BlogArticle findById(Integer id);
}

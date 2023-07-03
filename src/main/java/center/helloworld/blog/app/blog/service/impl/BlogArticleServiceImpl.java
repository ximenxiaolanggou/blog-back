package center.helloworld.blog.app.blog.service.impl;

import center.helloworld.blog.app.blog.mapper.BlogArticleMapper;
import center.helloworld.blog.app.blog.service.BlogArticleService;
import center.helloworld.blog.common.base.PageResult;
import cn.hutool.http.HtmlUtil;
import com.baomidou.mybatisplus.core.metadata.IPage;
import com.baomidou.mybatisplus.extension.plugins.pagination.Page;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.apache.commons.lang3.StringUtils;
import org.pegdown.PegDownProcessor;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import center.helloworld.blog.app.blog.entity.BlogArticle;
import center.helloworld.blog.app.blog.vo.BlogArticleSearchVO;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author zhishun.cai
 * @since 2022/5/9 16:10
 */
@Service
public class BlogArticleServiceImpl extends ServiceImpl<BlogArticleMapper, BlogArticle> implements BlogArticleService {

    @Autowired
    private BlogArticleMapper articleMapper;

    /**
     * 分页
     * @param pageNumber
     * @param pageSize
     * @param searchVO
     * @return
     */
    @Override
    public PageResult page(Integer pageNumber, Integer pageSize, BlogArticleSearchVO searchVO) {
        PegDownProcessor processor = new PegDownProcessor(Integer.MAX_VALUE);
        Page<BlogArticle> pageInfo = new Page<>(pageNumber, pageSize);
        IPage<BlogArticle> pr = articleMapper.page(pageInfo,searchVO);
        List<BlogArticle> articles = pr.getRecords();
        for (BlogArticle article : articles) {
            if(StringUtils.isNotBlank(article.getContent())) {
                article.setContent(HtmlUtil.cleanHtmlTag(processor.markdownToHtml(article.getContent())));
            }
        }
        return new PageResult(pr.getTotal(), articles);
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @Override
    public BlogArticle findById(Integer id) {
        return articleMapper.findById(id);
    }
}


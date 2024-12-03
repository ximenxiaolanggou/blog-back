package center.helloworld.blog.app.blog.web;

import center.helloworld.blog.app.blog.entity.BlogArticle;
import center.helloworld.blog.app.blog.entity.BlogCategory;
import center.helloworld.blog.app.blog.service.BlogArticleService;
import center.helloworld.blog.app.blog.service.BlogCategoryService;
import center.helloworld.blog.app.blog.vo.BlogArticleSearchVO;
import center.helloworld.blog.common.base.PageResult;
import center.helloworld.blog.common.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.List;

/**
 * 博客前端使用接口
 */

@RestController
@RequestMapping("blogPre")
public class BlogPreController {

    @Autowired
    private BlogArticleService articleService;

    @Autowired
    private BlogCategoryService categoryService;

    /**
     * 文章列表
     * @param pageNumber
     * @param pageSize
     * @param searchVO
     * @return
     */
    @GetMapping("articlePage/{pageNumber}/{pageSize}")
    public Result articlePage(@PathVariable("pageNumber") Integer pageNumber,
                       @PathVariable("pageSize") Integer pageSize,
                       BlogArticleSearchVO searchVO) {
        PageResult pr = articleService.page(pageNumber,pageSize,searchVO);
        return Result.ok(pr);
    }

    /**
     * 文章数量
     * @return
     */
    @GetMapping("articleCount")
    public Result articleCount() {
        long count = articleService.count();
        return Result.ok(count);
    }


    /**
     * 类别数量
     * @return
     */
    @GetMapping("categoryCount")
    public Result categoryCount() {
        long count = categoryService.count();
        return Result.ok(count);
    }

    /**
     * 详情
     * @param id
     * @return
     */
    @GetMapping("detail/{id}")
    public Result detail(@PathVariable("id") Integer id) {
        BlogArticle article = articleService.findById(id);
        return Result.ok(article);
    }

    /**
     * 获取各个类别文章数量
     * @return
     */
    @GetMapping("categoryArticleCount")
    public Result categoryArticleCount() {
        List<BlogCategory> categoryList = categoryService.categoryArticleCount();
        return Result.ok(categoryList);
    }
}

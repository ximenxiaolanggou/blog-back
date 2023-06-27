package center.helloworld.blog.app.blog.web;

import center.helloworld.blog.app.blog.properties.BlogProperties;
import center.helloworld.blog.app.blog.service.BlogArticleCategoryService;
import center.helloworld.blog.app.blog.service.BlogArticleService;
import center.helloworld.blog.app.blog.service.BlogArticleTagService;
import center.helloworld.blog.app.blog.vo.BlogArticleSearchVO;
import center.helloworld.blog.common.base.PageResult;
import center.helloworld.blog.common.base.Result;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.transaction.annotation.Transactional;
import org.springframework.web.bind.annotation.*;
import center.helloworld.blog.app.blog.entity.BlogArticle;

/**
 * <p>
 *
 * </p>
 *
 * @author zhishun.cai
 * @since 2022/5/9 15:50
 */
@RestController
@RequestMapping("blogArticle")
public class BlogArticleController {

    @Autowired
    private BlogProperties blogProperties;

    @Autowired
    private BlogArticleService articleService;

    @Autowired
    private BlogArticleTagService articleTagService;

    @Autowired
    private BlogArticleCategoryService articleCategoryService;

    /**
     * 添加
     * @param blogArticle
     * @return
     */
    @PostMapping("saveOrUpdate")
    @Transactional
    public Result add(@RequestBody BlogArticle blogArticle) {
        // 保存文章
        articleService.saveOrUpdate(blogArticle);
        // 删除文章类别关系
        articleCategoryService.deleteByArticleId(blogArticle.getId());
        // 保存文章类别关系
        articleCategoryService.save(blogArticle.getId(),blogArticle.getCategories());
        // 删除文章标签关系
        articleTagService.deleteByArticleId(blogArticle.getId());
        // 保存文章标签关系
        articleTagService.save(blogArticle.getId(),blogArticle.getTags());
        return Result.ok(blogArticle.getId());
    }

    /**
     * 分页
     * @param pageNumber
     * @param pageSize
     * @param searchVO
     * @return
     */
    @GetMapping("page/{pageNumber}/{pageSize}")
    public Result page(@PathVariable("pageNumber") Integer pageNumber,
                       @PathVariable("pageSize") Integer pageSize,
                       BlogArticleSearchVO searchVO) {
        PageResult pr = articleService.page(pageNumber,pageSize,searchVO);
        return Result.ok(pr);
    }

    /**
     * 根据ID查询
     * @param id
     * @return
     */
    @GetMapping("findById/{id}")
    public Result findById(@PathVariable("id") Integer id) {
        BlogArticle article = articleService.findById(id);
        return Result.ok(article);
    }


    /**
     * 删除
     * @param id
     * @return
     */
    @DeleteMapping("del/{id}")
    public Result del(@PathVariable("id") Integer id) {
        articleService.removeById(id);
        articleCategoryService.deleteByArticleId(id);
        articleTagService.deleteByArticleId(id);
        // TODO 删除相关图片和数据库表中记录
        return Result.ok();
    }
}

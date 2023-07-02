package center.helloworld.blog.app.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import center.helloworld.blog.app.blog.entity.BlogCategory;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author zhishun.cai
 * @since 2022/5/9 16:09
 */
public interface BlogCategoryService extends IService<BlogCategory> {

    /**
     * 列表
     * @param searchKey
     * @return
     */
    List<BlogCategory> list(String searchKey);

    /**
     * 获取各个类别关联的文章数量
     * @return
     */
    List<BlogCategory> categoryArticleCount();
}

package center.helloworld.blog.app.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import center.helloworld.blog.app.blog.entity.BlogArticleCategory;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhishun.cai
 * @since 2021-12-02
 */
@Mapper
public interface BlogArticleCategoryMapper extends BaseMapper<BlogArticleCategory> {
}

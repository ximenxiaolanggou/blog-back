package center.helloworld.blog.app.blog.mapper;

import com.baomidou.mybatisplus.core.mapper.BaseMapper;
import org.apache.ibatis.annotations.Mapper;
import center.helloworld.blog.app.blog.entity.BlogCategory;

import java.util.List;

/**
 * <p>
 * Mapper 接口
 * </p>
 *
 * @author zhishun.cai
 * @since 2021-12-02
 */
@Mapper
public interface BlogCategoryMapper extends BaseMapper<BlogCategory> {
    /**
     * 获取各个类别关联的文章数量
     * @return
     */
    List<BlogCategory> categoryArticleCount();
}

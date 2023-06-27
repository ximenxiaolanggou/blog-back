package center.helloworld.blog.app.blog.service;

import com.baomidou.mybatisplus.extension.service.IService;
import center.helloworld.blog.app.blog.entity.BlogTag;

import java.util.List;

/**
 * <p>
 *
 * </p>
 *
 * @author zhishun.cai
 * @since 2022/5/9 16:09
 */
public interface BlogTagService extends IService<BlogTag> {
    /**
     * 列表
     * @param searchKey
     * @return
     */
    List<BlogTag> list(String searchKey);
}

package center.helloworld.blog.app.blog.service.impl;

import center.helloworld.blog.app.blog.mapper.BlogUploadMapper;
import center.helloworld.blog.app.blog.service.BlogUploadService;
import com.baomidou.mybatisplus.extension.service.impl.ServiceImpl;
import org.springframework.stereotype.Service;
import center.helloworld.blog.app.blog.entity.BlogUpload;

/**
 * <p>
 *
 * </p>
 *
 * @author zhishun.cai
 * @since 2022/5/9 16:10
 */
@Service
public class BlogUploadServiceImpl extends ServiceImpl<BlogUploadMapper, BlogUpload> implements BlogUploadService {
}

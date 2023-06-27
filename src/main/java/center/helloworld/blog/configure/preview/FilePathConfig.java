package center.helloworld.blog.configure.preview;


import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.ResourceHandlerRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurerAdapter;
/**
 * @author zhishun.cai
 * @date 2021/5/11 18:45
 */

/**
 * 文件路径配置，可以直接访问
 * 映射的路径后面必须加/，否则访问不到
 */
@Configuration
public class FilePathConfig extends WebMvcConfigurerAdapter {


    @Override
    public void addResourceHandlers(ResourceHandlerRegistry registry) {
        registry.addResourceHandler("/upload/**").addResourceLocations("file:c:/upload/");
    }
}

package center.helloworld.blog.configure.satoken;

import cn.dev33.satoken.interceptor.SaRouteInterceptor;
import org.springframework.context.annotation.Configuration;
import org.springframework.web.servlet.config.annotation.InterceptorRegistry;
import org.springframework.web.servlet.config.annotation.WebMvcConfigurer;

@Configuration
public class SaTokenInterceptorConfirure implements WebMvcConfigurer {
    // 注册拦截器
    @Override
    public void addInterceptors(InterceptorRegistry registry) {
        // 注册Sa-Token的路由拦截器
        registry.addInterceptor(new SaRouteInterceptor())
                .addPathPatterns("/**")
                .excludePathPatterns(
                        "/ws/**",
                        "/auth/login",
                        "/blogArticle/findById/**",
                        "/blogArticle/page/**",
                        "/emq/client/publish",
                        "/blogPre/**",
                        "/mqtt/**");
    }
}

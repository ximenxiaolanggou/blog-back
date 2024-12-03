package center.helloworld.blog.configure.cross;

import jakarta.servlet.*;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Component
public class CrossFilter implements Filter {

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
    }

    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain)
            throws IOException, ServletException {
        HttpServletResponse resp = (HttpServletResponse) servletResponse;
        HttpServletRequest request = (HttpServletRequest) servletRequest;
        resp.setHeader("Access-Control-Allow-Origin", request.getHeader("Origin"));
        resp.setHeader("Access-Control-Allow-Methods", "POST,DELETE,OPTIONS,PUT,GET");
        resp.setHeader("Access-Control-Allow-Credentials", "true");
        resp.setHeader("Access-Control-Allow-Headers", "Content-Type,access-token,Authorization,x-requested-with");

        if (((HttpServletRequest) servletRequest).getMethod().toUpperCase().equals("OPTIONS")) {
            // options请求直接响应，其实这里应该使用拦截器来做
        } else {
            filterChain.doFilter(servletRequest, servletResponse);
        }
    }

    @Override
    public void destroy() {

    }
}

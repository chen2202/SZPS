package com.szps.framework.shiro.web.filter;

import java.io.IOException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.http.HttpServletRequest;

import com.szps.framework.web.domain.server.Sys;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

/**
 * * 跨站点请求伪造 CSRF攻击 *
 */
public class CSRFilter implements Filter {
    private static final Logger log = LoggerFactory.getLogger(CSRFilter.class);
    private String[] verifyReferer = null;
    private String[] csrfUrl = null;

    @Override
    public void destroy() {

    }

    @Override
    public void doFilter(ServletRequest request, ServletResponse response, FilterChain chain)
            throws IOException, ServletException {

        String referer = ((HttpServletRequest) request).getHeader("Referer");


        if (csrfUrl.length != 0) {
            if ((referer != null)) {

                boolean f = false;
                for (int i = 0; i < csrfUrl.length; i++) {
                    if (referer.trim().startsWith(csrfUrl[i])) {
                        f = true;
                        chain.doFilter(request, response);
                    }
                }

                if (f == false) {
                    log.error("疑似CSRF攻击，referer:" + referer);
                    request.getRequestDispatcher("/unauth").forward(request, response);
                }

            } else {

                String url = (((HttpServletRequest) request).getRequestURL()).toString();
                if (url.contains("http://localhost:8087/upload") || url.contains("https://vx.newground.cn:7000/upload")) {
                    chain.doFilter(request, response);
                } else {
                    //request.getRequestDispatcher("error.jsp").forward(request,response);
                    log.error("疑似CSRF攻击，referer:" + referer);
                    request.getRequestDispatcher("/unauth").forward(request, response);
                }
            }
        }

    }

    @Override

    public void init(FilterConfig filterConfig) throws ServletException {
        String referer = filterConfig.getInitParameter("referer");
        this.verifyReferer = referer.split(",");
    }

    public void setCsrfUrl(String csrfUrl) {
        this.csrfUrl = csrfUrl.split(";");
    }
}

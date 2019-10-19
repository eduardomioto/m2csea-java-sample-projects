package br.com.mioto.cloud.filter;

import java.io.IOException;
import java.sql.SQLException;

import javax.servlet.Filter;
import javax.servlet.FilterChain;
import javax.servlet.FilterConfig;
import javax.servlet.ServletException;
import javax.servlet.ServletRequest;
import javax.servlet.ServletResponse;
import javax.servlet.annotation.WebFilter;
import javax.servlet.http.HttpServletRequest;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.stereotype.Component;

import br.com.mioto.cloud.dao.ResponseTimeDAO;

@Component
@WebFilter("/*")
public class StatsFilter implements Filter {

    @Autowired
    private ResponseTimeDAO responseTimeDAO;

    @Value("${spring.application.name:empty}")
    private String appName;

    private static final Logger log = LoggerFactory.getLogger(StatsFilter.class);

    @Override
    public void init(FilterConfig filterConfig) throws ServletException {
        // empty
    }

    @Override
    public void doFilter(ServletRequest req, ServletResponse resp, FilterChain chain) throws IOException, ServletException {
        long time = System.currentTimeMillis();
        try {
            chain.doFilter(req, resp);
        } finally {
            time = System.currentTimeMillis() - time;
            log.trace("{}: {} ms ", ((HttpServletRequest) req).getRequestURI(),  time);
        }

        try {
            responseTimeDAO.storeResponseTime(appName, time);
        } catch (final SQLException e) {
            log.error("FilterError storeResponseTime: ", e);
        }
    }

    @Override
    public void destroy() {
        // empty
    }
}
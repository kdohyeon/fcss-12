package fast.campus.fcss12.filter;

import jakarta.servlet.*;
import lombok.extern.slf4j.Slf4j;
import org.springframework.security.web.csrf.CsrfToken;
import org.springframework.stereotype.Component;

import java.io.IOException;

@Slf4j
@Component
public class CsrfTokenLogger implements Filter {
    @Override
    public void doFilter(ServletRequest servletRequest, ServletResponse servletResponse, FilterChain filterChain) throws IOException, ServletException {
        CsrfToken csrf = (CsrfToken) servletRequest.getAttribute("_csrf");
        log.info("csrf token={}", csrf.getToken());
        filterChain.doFilter(servletRequest, servletResponse);
    }
}

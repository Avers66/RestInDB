package avers66.restinmemory.web.interceptors;

import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.servlet.HandlerInterceptor;

/**
 * ClientControllerInterceptor
 *
 * @Author Tretyakov Alexandr
 */


@Slf4j
public class ClientControllerInterceptor implements HandlerInterceptor {
    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        log.info("ClientControllerInterceptor: Запрос готовится к отправке в ClientController");
        return HandlerInterceptor.super.preHandle(request, response, handler);
    }
}

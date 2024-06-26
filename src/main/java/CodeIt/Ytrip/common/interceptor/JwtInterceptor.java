package CodeIt.Ytrip.common.interceptor;

import CodeIt.Ytrip.common.JwtUtils;
import CodeIt.Ytrip.common.reponse.StatusCode;
import CodeIt.Ytrip.common.exception.UserException;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;
import org.springframework.web.servlet.HandlerInterceptor;

@Slf4j
@RequiredArgsConstructor
@Component
public class JwtInterceptor implements HandlerInterceptor {

    private final JwtUtils jwtUtils;

    @Override
    public boolean preHandle(HttpServletRequest request, HttpServletResponse response, Object handler) throws Exception {
        System.out.println("request.getRequestURI() = " + request.getRequestURI());
        String token = jwtUtils.splitBearerToken(request.getHeader("Authorization"));
        if (jwtUtils.isValidToken(token)) {
            log.info("AccessToken = {}", token);
            return true;
        }
        throw new UserException(StatusCode.LOGIN_REQUIRED);
    }
}

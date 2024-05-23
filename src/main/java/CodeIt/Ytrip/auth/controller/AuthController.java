package CodeIt.Ytrip.auth.controller;

import CodeIt.Ytrip.auth.dto.request.LocalLoginRequest;
import CodeIt.Ytrip.auth.dto.request.RegisterRequest;
import CodeIt.Ytrip.auth.dto.response.KakaoLoginResponse;
import CodeIt.Ytrip.auth.dto.response.RegisterResponse;
import CodeIt.Ytrip.auth.service.AuthService;
import jakarta.servlet.http.HttpServletRequest;
import jakarta.servlet.http.HttpServletResponse;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.junit.Test;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.naming.AuthenticationException;
import java.util.Map;

@Slf4j
@RestController
@RequestMapping("/api/auth")
@RequiredArgsConstructor
public class AuthController {

    private final AuthService authService;
    @PostMapping("/kakao/login")
    public KakaoLoginResponse kakaoLogin(@RequestBody Map<String, String> request) {
        String code = request.get("code");
        return authService.kakaoLogin(code);
    }

    @PostMapping("/register")
    public RegisterResponse register(@RequestBody RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @PostMapping("/login")
    public Object localLogin(@RequestBody LocalLoginRequest localLoginRequest) {
        return authService.localLogin(localLoginRequest);
    }

    @RequestMapping("/test")
    public void test() {
        System.out.println("test");
    }

    @RequestMapping("/error")
    public ResponseEntity<?> tokenError(HttpServletRequest request) {
        String message = (String) request.getAttribute("message");
        String exception = (String) request.getAttribute("exception");
        System.out.println("exception = " + exception);
        System.out.println("message = " + message);
        if ("AuthenticationException".equals(exception)) {
            return ResponseEntity.ok(message);
        }
        return (ResponseEntity<?>) ResponseEntity.status(HttpStatus.BAD_REQUEST);
    }
}

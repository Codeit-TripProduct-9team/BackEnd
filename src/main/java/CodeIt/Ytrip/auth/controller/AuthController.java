package CodeIt.Ytrip.auth.controller;

import CodeIt.Ytrip.auth.dto.response.KakaoLoginResponse;
import CodeIt.Ytrip.auth.service.AuthService;
import lombok.RequiredArgsConstructor;
import lombok.extern.slf4j.Slf4j;
import org.springframework.web.bind.annotation.*;

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
}

package CodeIt.Ytrip.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum StatusCode {

    SUCCESS("2000", "성공"),
    TOKEN_EXPIRED("4000", "토큰이 만료되었습니다."),
    LOGIN_REQUIRED("4001", "로그인이 필요합니다."),
    DUPLICATE_EMAIL("4002", "중복된 이메일입니다."),
    USER_NOT_FOUND("4003", "존재하지 않는 USER 입니다.");

    private final String code;
    private final String message;
}

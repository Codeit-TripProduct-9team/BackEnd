package CodeIt.Ytrip.common.exception;

import lombok.Getter;
import lombok.RequiredArgsConstructor;

@Getter
@RequiredArgsConstructor
public enum TokenErrorStatus {
    EXPIRED("0001", "토큰이 만료되었습니다."),
    INVALID("0002", "유효하지 않은 토큰입니다.");

    private final String status;
    private final String message;

}

package CodeIt.Ytrip.auth.dto;

import lombok.AllArgsConstructor;
import lombok.Data;

@Data
@AllArgsConstructor
public class NaverUserInfoDto {
    private String nickName;
    private String email;
    private String accessToken;
    private String refreshToken;
}

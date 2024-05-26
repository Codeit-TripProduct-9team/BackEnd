package CodeIt.Ytrip.common.exception;

import CodeIt.Ytrip.common.reponse.ErrorResponse;
import CodeIt.Ytrip.common.reponse.SuccessResponse;
import lombok.extern.slf4j.Slf4j;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestControllerAdvice;

@Slf4j
@RestControllerAdvice
public class ApiExceptionHandler {

    @ExceptionHandler(UserException.class)
    public ResponseEntity<?> UserExceptionHandler(UserException e) {
        log.error("User Exception = {}, {}", e.getMessage(), e.getStatus());
        if (e.getStatus().equals("4003")) {
            return ResponseEntity.status(HttpStatus.NOT_FOUND).body(ErrorResponse.of(e.getStatus(), e.getMessage()));
        }
        return ResponseEntity.status(HttpStatus.UNAUTHORIZED).body(ErrorResponse.of(e.getStatus(), e.getMessage()));
    }


}

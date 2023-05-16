package main.exception;

import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.MethodArgumentNotValidException;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.context.request.WebRequest;

@ControllerAdvice
class ExceptionHandlerAdvice {

    @ExceptionHandler({EntityNotFoundException.class, MethodArgumentNotValidException.class})
    public final ResponseEntity handleException(Exception ex, WebRequest request) {
        HttpHeaders headers = new HttpHeaders();
        HttpStatus status;
        String message;
        if (ex instanceof EntityNotFoundException) {
            status = HttpStatus.NOT_FOUND;
            message = ex.getMessage();
        }
        else {
            status = HttpStatus.BAD_REQUEST;
            message = "Поле не может быть пустым";
        }
        return new ResponseEntity<>(message, headers, status);
    }

}
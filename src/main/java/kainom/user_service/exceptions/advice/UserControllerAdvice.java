package kainom.user_service.exceptions.advice;

import java.util.Date;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ControllerAdvice;
import org.springframework.web.bind.annotation.ExceptionHandler;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.kainom.dtos.ErrorDTO;
import com.kainom.err.UserNotFoundException;

@ControllerAdvice(basePackages = "kainom.user_service.controllers")
public class UserControllerAdvice {
    @ResponseBody
    @ResponseStatus(HttpStatus.NOT_FOUND)
    @ExceptionHandler(UserNotFoundException.class)
    public ErrorDTO handleUserNotFound(UserNotFoundException userNotFoundException) {
        String message = "Not found user";
        Integer status = HttpStatus.NOT_FOUND.value();

        ErrorDTO errorDTO = new ErrorDTO(status, message, new Date());
        return errorDTO;
    }

}

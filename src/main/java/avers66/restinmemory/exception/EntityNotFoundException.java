package avers66.restinmemory.exception;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * EntityNotFoundException
 *
 * @Author Tretyakov Alexandr
 */


//@ResponseStatus(HttpStatus.NOT_FOUND) //Вместо аннотации можно сделать в контроллере @ExceptionHandler
public class EntityNotFoundException extends RuntimeException{
    public EntityNotFoundException(String message) {
        super(message);
    }
}

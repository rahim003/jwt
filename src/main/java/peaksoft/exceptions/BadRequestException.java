package peaksoft.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

/**
 * ~ @created 10/03/2023
 * ~ @project_name jwt
 * ~ @author kurbanov
 **/
@ResponseStatus(HttpStatus.BAD_REQUEST)
public class BadRequestException extends Throwable {
    public BadRequestException(String message) {
        super(message);
    }
}

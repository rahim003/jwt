package peaksoft.exceptions.model;

import lombok.Getter;
import lombok.Setter;
import org.springframework.http.HttpStatus;

/**
 * ~ @created 10/03/2023
 * ~ @project_name jwt
 * ~ @author kurbanov
 **/
@Getter
@Setter
public class ExceptionResponse {
    private HttpStatus status;
    private String message;

}

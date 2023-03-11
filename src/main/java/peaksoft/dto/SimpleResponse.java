package peaksoft.dto;

import lombok.Builder;
import org.springframework.http.HttpStatus;

/**
 * ~ @created 10/03/2023
 * ~ @project_name jwt
 * ~ @author kurbanov
 **/
@Builder
public record SimpleResponse(
        HttpStatus httpStatus,
        String message
) {

}

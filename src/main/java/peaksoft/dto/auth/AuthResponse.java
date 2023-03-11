package peaksoft.dto.auth;

import lombok.Builder;

/**
 * ~ @created 10/03/2023
 * ~ @project_name jwt
 * ~ @author kurbanov
 **/
@Builder
public record AuthResponse(
        String token,
        String email
) {
}

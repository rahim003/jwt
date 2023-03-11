package peaksoft.servicies;

import peaksoft.dto.auth.AuthRequest;
import peaksoft.dto.auth.AuthResponse;
import peaksoft.dto.auth.RegisterRequest;

/**
 * ~ @created 10/03/2023
 * ~ @project_name jwt
 * ~ @author kurbanov
 **/
public interface AuthService {
    AuthResponse register(RegisterRequest registerRequest);

    AuthResponse authentication(AuthRequest authRequest);


}

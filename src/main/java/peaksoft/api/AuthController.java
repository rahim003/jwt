package peaksoft.api;

import jakarta.annotation.security.PermitAll;
import jakarta.validation.Valid;
import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.dto.auth.AuthRequest;
import peaksoft.dto.auth.AuthResponse;
import peaksoft.dto.auth.RegisterRequest;
import peaksoft.servicies.AuthService;

/**
 * ~ @created 10/03/2023
 * ~ @project_name jwt
 * ~ @author kurbanov
 **/
@RestController
@RequestMapping("/api/v1/auth")
@RequiredArgsConstructor
@PermitAll

public class AuthController {
    private final AuthService authService;

    @PostMapping("/register")
    @PreAuthorize("permitAll()")
    public AuthResponse register(@RequestBody @Valid RegisterRequest registerRequest) {
        return authService.register(registerRequest);
    }

    @PostMapping("/authenticate")
    @PreAuthorize("permitAll()")
    @PermitAll
    public AuthResponse auth(@RequestBody AuthRequest authRequest) {
        return authService.authentication(authRequest);
    }
}

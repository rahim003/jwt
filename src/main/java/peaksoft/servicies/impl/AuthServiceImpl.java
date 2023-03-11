package peaksoft.servicies.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.security.authentication.AuthenticationManager;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.dto.auth.AuthRequest;
import peaksoft.dto.auth.AuthResponse;
import peaksoft.dto.auth.RegisterRequest;
import peaksoft.enums.Role;
import peaksoft.exceptions.BadRequestException;
import peaksoft.jwt.JwtService;
import peaksoft.models.AuthInfo;
import peaksoft.repositories.AuthInfoRepository;
import peaksoft.servicies.AuthService;

/**
 * ~ @created 10/03/2023
 * ~ @project_name jwt
 * ~ @author kurbanov
 **/
@Service
@RequiredArgsConstructor
public class AuthServiceImpl implements AuthService {
    private final AuthInfoRepository authInfoRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtService jwtService;
    private final AuthenticationManager authenticationManager;

    @Override
    @SneakyThrows
    public AuthResponse register(RegisterRequest registerRequest) {
        var user = AuthInfo.builder()
                .userName(registerRequest.username())
                .email(registerRequest.email())
                .password(passwordEncoder.encode(registerRequest.password()))
                .role(Role.USER)
                .build();
        if (authInfoRepository.existsAuthInfoByEmail(registerRequest.email())) {
            throw new BadRequestException(String.format("This email %s exists", registerRequest.email()));
        }
        authInfoRepository.save(user);
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwtToken).email(registerRequest.email()).build();
    }

    @Override
    public AuthResponse authentication(AuthRequest authRequest) {
        System.err.println("Hello word");
        authenticationManager.authenticate(new UsernamePasswordAuthenticationToken(
                authRequest.email(), authRequest.password()));

        var user = authInfoRepository.findByEmail(authRequest.email()).orElseThrow();
        var jwtToken = jwtService.generateToken(user);
        return AuthResponse.builder().token(jwtToken).build();
    }

}

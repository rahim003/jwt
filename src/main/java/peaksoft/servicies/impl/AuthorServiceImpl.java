package peaksoft.servicies.impl;

import lombok.RequiredArgsConstructor;
import lombok.SneakyThrows;
import org.springframework.http.HttpStatus;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.author.AuthorRequest;
import peaksoft.dto.author.AuthorResponse;
import peaksoft.dto.converter.AuthorConverter;
import peaksoft.exceptions.BadRequestException;
import peaksoft.models.Author;
import peaksoft.repositories.AuthorRepository;
import peaksoft.servicies.AuthorService;

import java.util.List;

/**
 * ~ @created 11/03/2023
 * ~ @project_name jwt
 * ~ @author kurbanov
 **/
@Service
@RequiredArgsConstructor
public class AuthorServiceImpl implements AuthorService {
    private final AuthorRepository authorRepository;

    private final PasswordEncoder encoder;

    private final AuthorConverter authorConverter;


    @Override
    @SneakyThrows
    public SimpleResponse save(AuthorRequest authorRequest) {
        if (authorRepository.existsByAuthInfoEmail(authorRequest.email())) {
            throw new BadRequestException(String.format("This %s email exists ", authorRequest.email()));
        }
        final String passwordEncode = encoder.encode(authorRequest.password());
        final Author author = authorConverter.convert(authorRequest);
        assert author != null;
        author.getAuthInfo().setPassword(passwordEncode);
        authorRepository.save(author);
        return new SimpleResponse(HttpStatus.OK, String.format("%s  this author successfully save", author.getFirstName()));
    }

    @Override
    public List<AuthorResponse> findAll() {
        return null;
    }

    @Override
    public AuthorResponse deleteById(Long id) {
        return null;
    }

    @Override
    public AuthorResponse findById(Long id) {
        return null;
    }

    @Override
    public AuthorResponse update(Long id, AuthorRequest authorRequest) {
        return null;
    }
}

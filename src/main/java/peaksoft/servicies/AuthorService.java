package peaksoft.servicies;

import peaksoft.dto.SimpleResponse;
import peaksoft.dto.author.AuthorRequest;
import peaksoft.dto.author.AuthorResponse;

import java.util.List;

/**
 * ~ @created 10/03/2023
 * ~ @project_name jwt
 * ~ @author kurbanov
 **/
public interface AuthorService {
    SimpleResponse save(AuthorRequest authorRequest);

    List<AuthorResponse> findAll();

    AuthorResponse deleteById(Long id);

    AuthorResponse findById(Long id);

    AuthorResponse update(Long id, AuthorRequest authorRequest);
}

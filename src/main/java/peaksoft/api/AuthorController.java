package peaksoft.api;

import lombok.RequiredArgsConstructor;
import org.springframework.security.access.prepost.PreAuthorize;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import peaksoft.dto.SimpleResponse;
import peaksoft.dto.author.AuthorRequest;
import peaksoft.servicies.AuthorService;

/**
 * ~ @created 11/03/2023
 * ~ @project_name jwt
 * ~ @author kurbanov
 **/
@RestController
@RequiredArgsConstructor
@RequestMapping("/api/v1/authors")
public class AuthorController {
    private final AuthorService authorService;

    @PostMapping("/save")
    @PreAuthorize("permitAll()")
    public SimpleResponse save(@RequestBody AuthorRequest authorRequest) {
        return authorService.save(authorRequest);
    }


}

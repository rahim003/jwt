package peaksoft.dto.converter;

import org.springframework.core.convert.converter.Converter;
import org.springframework.stereotype.Component;
import peaksoft.dto.author.AuthorRequest;
import peaksoft.models.AuthInfo;
import peaksoft.models.Author;

/**
 * ~ @created 11/03/2023
 * ~ @project_name jwt
 * ~ @author kurbanov
 **/
@Component
public class AuthorConverter implements Converter<AuthorRequest, Author> {
    @Override
    public Author convert(AuthorRequest source) {
        Author author = new Author();
        author.setFirstName(source.firstName());
        author.setGender(source.gender());
        author.setPhoneNumber(source.phoneNumber());
        AuthInfo authInfo = new AuthInfo();
        authInfo.setEmail(source.email());
        authInfo.setPassword(source.password());
        authInfo.setRole(source.role());
        authInfo.setUserName(source.userName());
        author.setAuthInfo(authInfo);
        return author;
    }
}

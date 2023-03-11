package peaksoft.dto.author;

import jakarta.validation.constraints.Email;
import peaksoft.enums.Gender;
import peaksoft.enums.Role;

/**
 * A DTO for the {@link peaksoft.models.Author} entity
 */
public record AuthorRequest(
        String firstName,
        Gender gender,

        String userName,

        Role role,
        @Email
        String email,
        String password,
        String phoneNumber) {
}
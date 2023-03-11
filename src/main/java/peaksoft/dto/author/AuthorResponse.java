package peaksoft.dto.author;

import lombok.Builder;

/**
 * A DTO for the {@link peaksoft.models.Author} entity
 */
@Builder
public record AuthorResponse(String firstName) {
}
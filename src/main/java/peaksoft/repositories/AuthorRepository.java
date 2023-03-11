package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.models.Author;

@Repository
public interface AuthorRepository extends JpaRepository<Author, Long> {
    Boolean existsByAuthInfoEmail(String email);

}
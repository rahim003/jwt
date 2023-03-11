package peaksoft.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;
import peaksoft.models.Book;

@Repository
public interface BookRepository extends JpaRepository<Book, Long> {

}
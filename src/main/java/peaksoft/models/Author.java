package peaksoft.models;

import jakarta.persistence.*;
import lombok.Getter;
import lombok.Setter;
import peaksoft.enums.Gender;

import java.util.LinkedHashSet;
import java.util.Set;

@Getter
@Setter
@Entity
@Table(name = "authors")
public class Author {
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "author_seq")
    @SequenceGenerator(name = "author_seq")
    private Long id;
    private String firstName;
    private Gender gender;
    private String phoneNumber;
    @OneToOne(cascade = {CascadeType.PERSIST, CascadeType.DETACH, CascadeType.REFRESH, CascadeType.MERGE}, orphanRemoval = true)
    private AuthInfo authInfo;

    @OneToMany(mappedBy = "author", orphanRemoval = true)
    private Set<Book> books = new LinkedHashSet<>();

    public String getEmail() {
        return this.authInfo.getEmail();
    }

    public String getPassword() {
        return this.authInfo.getPassword();
    }
}
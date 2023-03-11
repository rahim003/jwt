package peaksoft.models;

import jakarta.persistence.*;
import lombok.*;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;
import peaksoft.enums.Role;

import java.util.Collection;
import java.util.List;

@Getter
@Setter
@Builder
@Entity
@Table(name = "auth_info")
@AllArgsConstructor
@NoArgsConstructor
public class AuthInfo implements UserDetails {


    public boolean isEnabled;
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE, generator = "auth_info_seq")
    @SequenceGenerator(name = "auth_info_seq")
    private Long id;
    private String userName;
    private String email;
    private String password;
    private boolean isAccountNonLocked;
    private boolean isCredentialsNonExpired;
    private boolean isAccountNonExpired;
    @Enumerated(EnumType.STRING)
    private Role role;

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return List.of(new SimpleGrantedAuthority(role.name()));
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return email;
    }

}
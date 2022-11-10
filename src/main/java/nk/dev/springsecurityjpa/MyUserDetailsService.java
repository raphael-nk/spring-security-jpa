package nk.dev.springsecurityjpa;

import nk.dev.springsecurityjpa.entities.User;
import nk.dev.springsecurityjpa.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;
import java.util.Optional;

@Service
public class MyUserDetailsService implements UserDetailsService {

    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Optional<User> user = userRepository.findByUsername(username);
        // check if user is not null
        user.orElseThrow(() -> new UsernameNotFoundException("Not found: " + username));
        // convert User instance from DB to MyUserDetails
        return user.map(MyUserDetails::new).get();
    }
}

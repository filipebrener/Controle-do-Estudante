package br.com.filipe.brenner.controle.estudante.configs.security;


import br.com.filipe.brenner.controle.estudante.model.UserModel;
import br.com.filipe.brenner.controle.estudante.repository.UserRepository;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserService implements UserDetailsService {

    final UserRepository userRepository;

    public UserService(UserRepository userRepository) {
        this.userRepository = userRepository;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("UserModel Not Found with username: " + username));
        return new User(userModel.getUsername(), userModel.getPassword(), true, true, true,true, userModel.getAuthorities());
    }
}
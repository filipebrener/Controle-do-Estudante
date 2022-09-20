package br.com.filipe.brenner.controle.estudante.service;

import br.com.filipe.brenner.controle.estudante.model.UserModel;
import br.com.filipe.brenner.controle.estudante.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import javax.transaction.Transactional;

@Service
@Transactional
public class UserService implements UserDetailsService {
    @Autowired
    private UserRepository userRepository;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        UserModel userModel = userRepository.findByUsername(username)
                .orElseThrow(() -> new UsernameNotFoundException("UserModel Not Found with username: " + username));
        return userModel;
    }
}
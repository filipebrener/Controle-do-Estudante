package br.com.filipe.brenner.controle.estudante.controller;

import br.com.filipe.brenner.controle.estudante.model.Enum.RoleName;
import br.com.filipe.brenner.controle.estudante.model.Role;
import br.com.filipe.brenner.controle.estudante.model.UserModel;
import br.com.filipe.brenner.controle.estudante.repository.RoleRepository;
import br.com.filipe.brenner.controle.estudante.repository.UserRepository;
import com.fasterxml.jackson.databind.ObjectMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.test.web.reactive.server.WebTestClient;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

public class BaseControllerTest {
    @Autowired
    protected WebTestClient testClient;
    @Autowired
    private UserRepository userRepository;
    @Autowired
    private RoleRepository roleRepository;
    protected final String MASTER_PASSWORD = "password123";
    protected final String MASTER_NAME = "adm";
    protected final ObjectMapper objectMapper = new ObjectMapper();

    private List<Role> getAllRoles(){
        List<Role> roleList = new ArrayList<>();
        for(RoleName roleName: RoleName.values()){
            Optional<Role> optionalRole = roleRepository.findByRoleName(roleName);
            if(optionalRole.isEmpty()){
                roleList.add(roleRepository.saveAndFlush(new Role(roleName)));
            } else {
                roleList.add(optionalRole.get());
            }
        }
        return roleList;
    }

    protected void createMasterUser(){
        Optional<UserModel> admUser = userRepository.findByUsername("adm");
        if(admUser.isPresent()) return;
        UserModel user = new UserModel("adm", MASTER_PASSWORD, "38999810408", "filipe.brener@ufv.br", getAllRoles());
        userRepository.saveAndFlush(user);
    }


    // TODO implementar métodos e adicionar recursos que sejam interessantes para testar os endpoints

}

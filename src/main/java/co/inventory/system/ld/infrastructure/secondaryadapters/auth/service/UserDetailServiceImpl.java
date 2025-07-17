package co.inventory.system.ld.infrastructure.secondaryadapters.auth.service;

import co.inventory.system.ld.application.secondaryports.entity.users.UserEntity;
import co.inventory.system.ld.application.secondaryports.repository.users.UserRepository;
import co.inventory.system.ld.crosscutting.helpers.JwtHelper;
import co.inventory.system.ld.infrastructure.primaryadapters.controller.response.users.AuthResponse;
import org.springframework.security.authentication.BadCredentialsException;
import org.springframework.security.authentication.UsernamePasswordAuthenticationToken;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.password.PasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserDetailServiceImpl implements UserDetailsService {

    private final UserRepository userRepository;
    private final PasswordEncoder passwordEncoder;
    private final JwtHelper jwtHelper;

    public UserDetailServiceImpl(UserRepository userRepository, PasswordEncoder passwordEncoder, JwtHelper jwtHelper) {
        this.userRepository = userRepository;
        this.passwordEncoder = passwordEncoder;
        this.jwtHelper = jwtHelper;
    }

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        UserEntity user = UserEntity.create().setEmail(email);

        UserEntity userEntity = userRepository.findByFilter(user).get(0);

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userEntity.getUserType().getName()));

        return new User(userEntity.getEmail(), userEntity.getPassword(), authorities);
    }

    public AuthResponse loginUser(String email, String password){

        UserEntity filter = UserEntity.create().setEmail(email);

        UserEntity userEntity = userRepository.findByFilter(filter).get(0);

        if (!passwordEncoder.matches(password, userEntity.getPassword())){
            throw new BadCredentialsException("Usuario o contraseña inválida");
        }

        List<SimpleGrantedAuthority> authorities = new ArrayList<>();
        authorities.add(new SimpleGrantedAuthority("ROLE_" + userEntity.getUserType().getName()));

        UsernamePasswordAuthenticationToken authenticationToken = new
                UsernamePasswordAuthenticationToken(email, null, authorities);
        String token = jwtHelper.createToken(authenticationToken);

        AuthResponse authResponse = new AuthResponse();
        authResponse.setToken(token);
        authResponse.setRole(userEntity.getUserType().getName());
        authResponse.getMessages().add("Usuario logeado correctamente");

        return authResponse;
    }
}

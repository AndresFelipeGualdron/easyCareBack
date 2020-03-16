package edu.eci.arsw.easycare.service.impl;

import edu.eci.arsw.easycare.model.Cliente;
import edu.eci.arsw.easycare.model.Paseador;
import edu.eci.arsw.easycare.service.EasyCareService;
import edu.eci.arsw.easycare.service.ExceptionServiciosEasyCare;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.annotation.Primary;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.User;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.security.crypto.bcrypt.BCryptPasswordEncoder;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
@Primary
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    private final EasyCareService easyCareService;

    public UserDetailsServiceImpl(EasyCareService easyCareService) {
        this.easyCareService = easyCareService;
    }

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        try{
            Cliente cl = easyCareService.getCliente(username);
            return userBuilder(cl.getCorreo(), cl.getPassword(), new BCryptPasswordEncoder().encode(cl.getPassword()),"cliente");
//            return userBuilder("correo", "password", new BCryptPasswordEncoder().encode("password"),"cliente");
        }catch (ExceptionServiciosEasyCare e){
            try{
                Paseador ps = easyCareService.getPaseador(username);
                return userBuilder(ps.getCorreo(), ps.getPassword(), new BCryptPasswordEncoder().encode(ps.getPassword()),"paseador");
//                return userBuilder("correo", "password", new BCryptPasswordEncoder().encode("password"),"paseador");
            }catch (ExceptionServiciosEasyCare ex){
                throw new UsernameNotFoundException("Usuario no valido");
            }
        }

    }

    private User userBuilder(String correo, String password, String... roles){
        boolean enabled = true;
        boolean accountNotExpired = true;
        boolean credentialsNotExpired = true;
        boolean accountNotLocked = true;
        List<GrantedAuthority> authorities = new ArrayList<>();
        for(String role: roles){
            authorities.add(new SimpleGrantedAuthority("ROLE_"+role));
        }
        return new User(correo,password,enabled,accountNotExpired,credentialsNotExpired,accountNotLocked, authorities);
    }
}

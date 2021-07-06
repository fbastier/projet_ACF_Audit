package com.acfaudit;

import com.acfaudit.model.Client;
import com.acfaudit.user.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class JPAClientUserDetailsService implements UserDetailsService {

    @Autowired
    ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String email) throws UsernameNotFoundException {
        Client client = clientService.findByEmail(email);

        if(client == null) {
         throw new UsernameNotFoundException("Not found : " + email);
        }

        return new JPAClientUserDetails(client);
    }
}

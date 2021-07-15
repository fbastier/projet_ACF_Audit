package com.acfaudit.security.services;

import com.acfaudit.model.Client;
import com.acfaudit.security.services.UserDetailsImpl;
import com.acfaudit.user.ClientService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.core.userdetails.UserDetails;
import org.springframework.security.core.userdetails.UserDetailsService;
import org.springframework.security.core.userdetails.UsernameNotFoundException;
import org.springframework.stereotype.Service;

@Service
public class UserDetailsServiceImpl implements UserDetailsService {

    @Autowired
    ClientService clientService;

    @Override
    public UserDetails loadUserByUsername(String username) throws UsernameNotFoundException {
        Client client = clientService.findByUsername(username);

        if(client == null) {
         throw new UsernameNotFoundException("Not found : " + username);
        }

        return new UserDetailsImpl(client);
    }
}

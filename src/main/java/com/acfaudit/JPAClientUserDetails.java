package com.acfaudit;

import com.acfaudit.model.Client;
import com.acfaudit.model.Folder;
import com.acfaudit.model.Message;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.stream.Collectors;

public class JPAClientUserDetails implements UserDetails {

    private int id;
    private String clientFirstName;
    private String clientSurName;
    private String clientEmail;
    private List<Message> messageList;
    private Folder folder;
    private String password;
    private boolean active;
    private List<GrantedAuthority> authorities;

    public JPAClientUserDetails() {

    }

    public JPAClientUserDetails(Client client) {
        this.id = client.getId();
        this.clientFirstName = client.getClientFirstName();
        this.clientEmail = client.getClientEmail();
        this.active = client.isActive();
        this.authorities = Arrays.stream(client.getRoles().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
        this.password = client.getPassword();
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        System.out.println("debug JPAClientUserDetails in getAuthorities() : ");
        //System.out.println(authorities);
        return authorities;
    }

    @Override
    public String getPassword() {
        return password;
    }

    @Override
    public String getUsername() {
        return clientFirstName;
    }

    @Override
    public boolean isAccountNonExpired() {
        return true;
    }

    @Override
    public boolean isAccountNonLocked() {
        return true;
    }

    @Override
    public boolean isCredentialsNonExpired() {
        return true;
    }

    @Override
    public boolean isEnabled() {
        return active;
    }


}

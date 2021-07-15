package com.acfaudit.security.services;

import com.acfaudit.model.Client;
import com.acfaudit.model.Folder;
import com.acfaudit.model.Message;
import com.fasterxml.jackson.annotation.JsonIgnore;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.security.core.userdetails.UserDetails;

import java.util.Arrays;
import java.util.Collection;
import java.util.List;
import java.util.Objects;
import java.util.stream.Collectors;

public class UserDetailsImpl implements UserDetails {

    private int id;
    private String clientFirstName;
    private String clientSurName;
    private String clientEmail;
    private List<Message> messageList;
    private Folder folder;

    @JsonIgnore
    private String password;

    private boolean active;
    private List<GrantedAuthority> authorities;

    public UserDetailsImpl() {
    }

    public UserDetailsImpl(Client client) {
        this.id = client.getId();
        this.clientFirstName = client.getClientFirstName();
        this.clientEmail = client.getEmail();
        this.active = client.isActive();
        this.authorities = Arrays.stream(client.getRoles().split(","))
                        .map(SimpleGrantedAuthority::new)
                        .collect(Collectors.toList());
        this.password = client.getPassword();
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getEmail() {
        return clientEmail;
    }

    public void setClientEmail(String clientEmail) {
        this.clientEmail = clientEmail;
    }

    public void setPassword(String password) {
        this.password = password;
    }

    public void setAuthorities(List<GrantedAuthority> authorities) {
        this.authorities = authorities;
    }

    @Override
    public Collection<? extends GrantedAuthority> getAuthorities() {
        return authorities;
    }

    public static UserDetailsImpl build(Client client) {
        return new UserDetailsImpl(client);
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

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        UserDetailsImpl that = (UserDetailsImpl) o;
        return id == that.id && active == that.active && Objects.equals(clientFirstName, that.clientFirstName) && Objects.equals(clientSurName, that.clientSurName) && clientEmail.equals(that.clientEmail) && Objects.equals(messageList, that.messageList) && Objects.equals(folder, that.folder) && password.equals(that.password) && authorities.equals(that.authorities);
    }

    @Override
    public int hashCode() {
        return Objects.hash(id, clientFirstName, clientSurName, clientEmail, messageList, folder, password, active, authorities);
    }
}

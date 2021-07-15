package com.acfaudit.user;

import com.acfaudit.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {
    Client findUserByClientEmail(String email);

    Client findByUsername(String username);

    boolean existsByUsername(String username);

    boolean existsByEmail(String email);
}

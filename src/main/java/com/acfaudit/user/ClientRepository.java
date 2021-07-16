package com.acfaudit.user;

import com.acfaudit.model.Client;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<Client, Integer> {

    boolean existsByUsername(String username);

    //boolean existsByEmail(String email);

    Client findByUsername(String username);

    //Client findUserByClientEmail(String email);
}

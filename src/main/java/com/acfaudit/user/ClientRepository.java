package com.acfaudit.user;

import com.acfaudit.model.Client;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<Client, Integer> {
    Client findUserByClientEmail(String email);
}

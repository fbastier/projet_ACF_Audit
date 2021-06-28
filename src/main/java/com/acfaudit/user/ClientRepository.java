package com.acfaudit.user;

import com.acfaudit.model.Client;
import org.springframework.data.repository.CrudRepository;


public interface ClientRepository extends CrudRepository<Client, Integer> {
}

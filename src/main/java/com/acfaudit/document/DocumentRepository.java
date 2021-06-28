package com.acfaudit.document;

import com.acfaudit.model.Client;
import com.acfaudit.model.Document;
import org.springframework.data.repository.CrudRepository;


public interface DocumentRepository extends CrudRepository<Document, Integer> {
}

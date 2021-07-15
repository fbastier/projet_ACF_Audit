package com.acfaudit.document;

import com.acfaudit.model.Client;
import com.acfaudit.model.Document;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface DocumentRepository extends CrudRepository<Document, Integer> {
}

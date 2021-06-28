package com.acfaudit.folder;

import com.acfaudit.model.Client;
import com.acfaudit.model.Folder;
import org.springframework.data.repository.CrudRepository;


public interface FolderRepository extends CrudRepository<Folder, Integer> {
}

package com.xproject.master.app.dataprovider.database.repository;

import com.xproject.master.app.dataprovider.database.repository.model.ClientModel;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientModel, Long> {
}

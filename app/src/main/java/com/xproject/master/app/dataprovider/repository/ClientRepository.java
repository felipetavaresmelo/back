package com.xproject.master.app.dataprovider.repository;

import com.xproject.master.app.dataprovider.repository.persistent.ClientPO;
import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends CrudRepository<ClientPO, Long> {
}

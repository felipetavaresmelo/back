package com.xproject.master.app.dataprovider.repositories;

import com.xproject.master.app.dataprovider.repositories.persistent.ClientPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientRepository extends JpaRepository<ClientPO, Long> {
}

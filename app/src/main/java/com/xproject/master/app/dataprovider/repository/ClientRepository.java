package com.xproject.master.app.dataprovider.repository;

import com.xproject.master.app.dataprovider.repository.persistent.ClientPO;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ClientRepository extends JpaRepository<ClientPO, Long> {
}

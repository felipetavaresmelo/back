package com.xproject.master.app.dataprovider.repository.jpa;

import com.xproject.master.app.dataprovider.repository.jpa.po.ClientPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ClientJpaRepository extends JpaRepository<ClientPo, Long> {
}

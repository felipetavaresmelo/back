package com.xproject.master.app.dataprovider.repositories;

import com.xproject.master.app.dataprovider.repositories.persistent.ProductPO;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductPO, Long> {
}

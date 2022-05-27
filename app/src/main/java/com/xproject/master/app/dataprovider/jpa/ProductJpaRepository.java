package com.xproject.master.app.dataprovider.jpa;

import com.xproject.master.app.dataprovider.jpa.po.ProductPo;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductJpaRepository extends JpaRepository<ProductPo, Long> {
}

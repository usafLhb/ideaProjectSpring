package org.sid.billingservice.repository;

import org.sid.billingservice.entity.Bill;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;


@RepositoryRestResource
public interface BillRepository extends JpaRepository <Bill,Long>{
}

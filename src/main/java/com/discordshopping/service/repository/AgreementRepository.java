package com.discordshopping.service.repository;

import com.discordshopping.entity.Agreement;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.UUID;

@Repository
public interface AgreementRepository extends JpaRepository<Agreement, UUID> {

}

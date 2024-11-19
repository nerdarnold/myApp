package com.ata.courierApp.repositories;

import com.ata.courierApp.entities.Operation;
import org.springframework.data.jpa.repository.JpaRepository;

public interface OperationRepository extends JpaRepository<Operation,String>
{
}

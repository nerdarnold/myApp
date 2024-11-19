package com.ata.courierApp.repositories;

import com.ata.courierApp.entities.Courier;
import org.springframework.data.jpa.repository.JpaRepository;

public interface CourierRepository extends JpaRepository<Courier,String>
{
}

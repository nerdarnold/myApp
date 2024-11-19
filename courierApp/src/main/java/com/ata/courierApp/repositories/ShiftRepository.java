package com.ata.courierApp.repositories;

import com.ata.courierApp.entities.Shift;
import org.springframework.data.jpa.repository.JpaRepository;

public interface ShiftRepository extends JpaRepository<Shift,String>
{
}

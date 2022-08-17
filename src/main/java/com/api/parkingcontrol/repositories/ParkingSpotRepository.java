package com.api.parkingcontrol.repositories;

import java.util.UUID;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.api.parkingcontrol.models.ParkingSpotModel;

@Repository 
/*declaração do esteriotipo do spring para transação com a base de dados*/

public interface ParkingSpotRepository extends JpaRepository<ParkingSpotModel, UUID> {

}

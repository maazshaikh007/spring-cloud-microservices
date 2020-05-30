package com.example.maaz.spring.cloud.repo;

import java.util.Collection;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.repository.query.Param;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.data.rest.core.annotation.RestResource;

import com.example.maaz.spring.cloud.entity.Reservation;

@RepositoryRestResource
public interface ReservationRepository extends JpaRepository<Reservation, Long> {
	
	@RestResource(path = "by-name")
    Collection<Reservation> findByReservationName(@Param("reservationName") String reservationName);

}

package com.sut.se.g02.repository;

import com.sut.se.g02.entity.StatusPay;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.rest.core.annotation.RepositoryRestResource;
import org.springframework.web.bind.annotation.CrossOrigin;


@RepositoryRestResource
@CrossOrigin(origins = "http://localhost:4200")
public interface StatusPayRepository extends JpaRepository<StatusPay, Long> {
		StatusPay findByStatusPayId(Long statusPayId);
}
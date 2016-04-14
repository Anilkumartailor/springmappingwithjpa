package com.imlabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;

import com.imlabs.model.AddressMysql;

public interface AddressRepositoryMysql extends JpaRepository<AddressMysql, Long> {

}

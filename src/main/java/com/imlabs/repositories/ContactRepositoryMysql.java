package com.imlabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imlabs.model.ContactMysql;
@Repository
public interface ContactRepositoryMysql extends JpaRepository<ContactMysql, Long> {

}

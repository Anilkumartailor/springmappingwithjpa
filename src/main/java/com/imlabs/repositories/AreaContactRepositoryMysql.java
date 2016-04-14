package com.imlabs.repositories;

import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import com.imlabs.model.AreaContactMysql;
@Repository
public interface AreaContactRepositoryMysql extends JpaRepository<AreaContactMysql, Long>{

}

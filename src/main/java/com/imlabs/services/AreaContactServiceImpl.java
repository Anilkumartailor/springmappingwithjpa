package com.imlabs.services;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.imlabs.model.AreaContactMysql;
import com.imlabs.repositories.AreaContactRepositoryMysql;

@Service
public class AreaContactServiceImpl implements AreaContactService{
    
	@Autowired
	AreaContactRepositoryMysql areaContactRepositoryMysql;
	@Override
	public void insertArea(AreaContactMysql area) {
		areaContactRepositoryMysql.save(area);
		
	}

	@Override
	public List<AreaContactMysql> findAllAreas() {
		return areaContactRepositoryMysql.findAll();
	}

	@Override
	public void deleteArea(long id) {
		areaContactRepositoryMysql.delete(id);
		
	}

	@Override
	public void updateArea(AreaContactMysql area) {
		areaContactRepositoryMysql.save(area);
		
	}

	@Override
	public AreaContactMysql getAreaById(long id) {
		return areaContactRepositoryMysql.findOne(id);
	}

}

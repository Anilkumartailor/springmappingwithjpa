package com.imlabs.services;

import java.util.List;

import com.imlabs.model.AreaContactMysql;
public interface AreaContactService {

	void insertArea(AreaContactMysql area);
    List<AreaContactMysql> findAllAreas();
    void deleteArea(long id);
    void updateArea(AreaContactMysql area);
    AreaContactMysql getAreaById(long id);
}

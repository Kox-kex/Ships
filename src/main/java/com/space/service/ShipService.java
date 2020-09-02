package com.space.service;

import com.space.model.Ship;
import com.space.repository.ShipDAO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ShipService {

    //@Autowired
    private  ShipDAO shipDAO = new ShipDAO();

    public List<Ship> getAllUsers() {
        return shipDAO.getShips();
    }

    public void create(Ship ship) {
        shipDAO.getShips().add(ship);
    }

    public Ship getById(Long id) {
        return shipDAO.getShips().get( id.intValue());
    }
}

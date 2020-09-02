package com.space.repository;

import com.space.model.Ship;
import com.space.model.ShipType;
import org.springframework.stereotype.Repository;
import java.util.ArrayList;
import java.util.Arrays;
import java.util.Date;
import java.util.List;

@Repository
public class ShipDAO {
    /*private List<Ship> ships = Arrays.asList(
            new Ship("admin", "admin", ShipType.MERCHANT,
                    new Date(), false, 2.0, 22),
            new Ship("admin22", "admin22", ShipType.MILITARY,
                    new Date(), true, 5.0, 333));*/
    private final List<Ship> ships = new ArrayList<>();

    public List<Ship> getShips() {
        return ships;
    }

}

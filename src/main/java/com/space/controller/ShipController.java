package com.space.controller;

import com.space.model.Ship;
import com.space.model.ShipType;
import com.space.service.ShipService;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.text.DateFormat;
import java.text.SimpleDateFormat;
import java.util.Date;

import static org.springframework.web.bind.annotation.RequestMethod.POST;

@RestController
@RequestMapping("/rest/ships")
public class ShipController {

    //@Autowired
    private ShipService shipService = new ShipService();

    /*@RequestMapping(value = "", method = RequestMethod.POST, produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Ship> createShip(@RequestBody Ship ship) {

        if (ship == null) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        this.shipService.create(ship);
        return new ResponseEntity<>(ship, HttpStatus.OK);
    }*/

    @RequestMapping(
            value = "",
            params = { "name", "planet", "shipType", "prodDate", "isUsed", "speed", "crewSize" },
            method = POST,
            produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
    public ResponseEntity<Ship> createShip(@RequestParam(value = "name") String name,
                                           @RequestParam(value = "planet") String planet,
                                           @RequestParam(value = "shipType") ShipType shipType,
                                           @RequestParam(value = "prodDate")  Long prodDate,
                                           @RequestParam(value = "isUsed", required = false) Boolean isUsed,
                                           @RequestParam(value = "speed") Double speed,
                                           @RequestParam(value = "crewSize") Integer crewSize) {
        Ship ship = null;
        SimpleDateFormat dateformatYYYY = new SimpleDateFormat("yyyy");
        Date dateDate = new Date(prodDate);
        long date  = Long.parseLong(dateformatYYYY.format(dateDate));

        if (name.length() < 50 && planet.length() < 50
                && !name.isEmpty() && !planet.isEmpty()
                && prodDate >= 0 && date >= 2800 && date <= 3019
                && speed >= 0.01 && speed <= 0.99
                && crewSize >= 1 && crewSize <= 9999) {

            if (isUsed) {
                ship = new Ship(name, planet, shipType, dateDate, true, speed, crewSize);
                this.shipService.create(ship);
                return new ResponseEntity<>(ship, HttpStatus.OK);
            } else { ship = new Ship(name, planet, shipType, dateDate, false, speed, crewSize);
                return new ResponseEntity<>(ship, HttpStatus.OK);
            }
        } else { return new ResponseEntity<>(HttpStatus.BAD_REQUEST); }
    }

    @RequestMapping(value = "{id}", method = RequestMethod.GET)
    public ResponseEntity<Ship> getShip(@PathVariable("id") Long id) {

        if (id == 0) {
            return new ResponseEntity<>(HttpStatus.BAD_REQUEST);
        }

        Ship ship = this.shipService.getById(id);
        return new ResponseEntity<>(ship, HttpStatus.OK);
    }

    /*@RequestMapping(value = "", method = RequestMethod.POST)
    public @ResponseBody
    Ship create(@RequestBody Ship ship) {
        return ship;
    }*/

   /* @RequestMapping(value = "/ship")
    public String helloWorldController(@RequestParam(name = "name", required = false, defaultValue = "World") String name) {
        //model.addAttribute("name", name);
        return "check";
    }*/
/*
    @RequestMapping(value = "", method = RequestMethod.GET)
    public @ResponseBody
    Ship getShip(@ModelAttribute("userFromServer") Ship user) {
        return new Ship("admin22", "admin22", ShipType.MILITARY,
                new Date("10.10.2050"), true, 5.0, 3334);
    }*/

}

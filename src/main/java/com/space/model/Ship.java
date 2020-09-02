package com.space.model;

import java.text.SimpleDateFormat;
import java.util.Date;

public class Ship {
    private Long id;
    private String name;
    private String planet;
    private ShipType shipType;
    private Date prodDate;
    private Boolean isUsed = false;
    private Double speed;
    private Integer crewSize;
    private Double rating;

    public Ship(String name, String planet, ShipType shipType, Date prodDate, Boolean isUsed, Double speed, Integer crewSize) {
        this.name = name;
        this.planet = planet;
        this.shipType = shipType;
        this.prodDate = prodDate;
        this.isUsed = isUsed;
        this.speed = speed;
        this.crewSize = crewSize;


        SimpleDateFormat dateformatYYYY = new SimpleDateFormat("yyyy");
        long date  = Long.parseLong(dateformatYYYY.format(prodDate));
        double k;
        if (isUsed) k = 0.5; else k = 1;
        this.rating = Math.rint(100.0 * ((80 * speed * k) / (3019 - date + 1))) / 100.0 ;
    }

    public Long getId() {
        return id;
    }

    public void setId(Long id) {
        this.id = id;
    }

    public Double getRating() {
        return rating;
    }

    public void setRating(Double rating) {
        this.rating = rating;
    }

    public String getName() {
        return name;
    }

    public void setName(String name) {
        this.name = name;
    }

    public String getPlanet() {
        return planet;
    }

    public void setPlanet(String planet) {
        this.planet = planet;
    }

    public ShipType getShipType() {
        return shipType;
    }

    public void setShipType(ShipType shipType) {
        this.shipType = shipType;
    }

    public Date getProdDate() {
        return prodDate;
    }

    public void setProdDate(Date prodDate) {
        this.prodDate = prodDate;
    }

    public Boolean getUsed() {
        return isUsed;
    }

    public void setUsed(Boolean used) {
        isUsed = used;
    }

    public Double getSpeed() {
        return speed;
    }

    public void setSpeed(Double speed) {
        this.speed = speed;
    }

    public Integer getCrewSize() {
        return crewSize;
    }

    public void setCrewSize(Integer crewSize) {
        this.crewSize = crewSize;
    }



}

package com.example.demo.entity;

import javax.persistence.*;

@Entity
@Table(name = "vehicle")
public class Vehicles {
    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    @Column(name="id")
    private int id;

    @Column(name = "vehicle_name")
    private String vehicle_name;

    @Column(name = "part_name")
    private String part_name;

    @Column(name = "model")
    private String model;

    @Column(name = "owner")
    private String owner;

    @Column(name = "number")
    private String number;

    public Vehicles(){

    }

    public Vehicles(String vehicle_name, String part_name,
                    String model, String owner, String number){
        this.vehicle_name = vehicle_name;
        this.part_name = part_name;
        this.model = model;
        this.owner = owner;
        this.number = number;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getVehicle_name() {
        return vehicle_name;
    }

    public void setVehicle_name(String vehicle_name) {
        this.vehicle_name = vehicle_name;
    }

    public String getPart_name() {
        return part_name;
    }

    public void setPart_name(String part_name) {
        this.part_name = part_name;
    }

    public String getModel() {
        return model;
    }

    public void setModel(String model) {
        this.model = model;
    }

    public String getOwner() {
        return owner;
    }

    public void setOwner(String owner) {
        this.owner = owner;
    }

    public String getNumber() {
        return number;
    }

    public void setNumber(String number) {
        this.number = number;
    }

    @Override
    public String toString() {
        return "Vehicles{" +
                "id=" + id +
                ", vehicle_name='" + vehicle_name + '\'' +
                ", part_name='" + part_name + '\'' +
                ", model='" + model + '\'' +
                ", owner='" + owner + '\'' +
                ", number='" + number + '\'' +
                '}';
    }
}

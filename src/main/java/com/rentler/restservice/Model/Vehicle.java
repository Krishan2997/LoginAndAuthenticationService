package com.rentler.restservice.Model;

import lombok.AllArgsConstructor;
import lombok.Getter;
import lombok.Setter;

@Getter
@Setter
@AllArgsConstructor
public class Vehicle {
    //Unique Id
    String vehicleId;

    //Number on numberplate
    String vehicleNumber;

    //Name of vehicle
    String getVehicleName;

    //Two or four wheeler
    String vehicleType;
}

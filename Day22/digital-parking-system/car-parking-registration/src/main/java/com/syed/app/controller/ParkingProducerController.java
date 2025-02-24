package com.syed.app.controller;

import com.syed.app.model.Car;
import com.syed.app.model.ParkingEnd;
import com.syed.app.model.ParkingStart;
import com.syed.app.service.ParkingService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("/parking")
public class ParkingProducerController {
    private ParkingService parkingService;
    public ParkingProducerController(ParkingService parkingService) {
        this.parkingService = parkingService;
    }
    private static final Logger logger = LoggerFactory.getLogger(ParkingProducerController.class);
    @PostMapping("/start")
    public ParkingStart startParking(@RequestBody Car car, @RequestParam String parkingNo) {
        logger.info("Starting parking for car");
        return parkingService.startParking(car,parkingNo);
    }
    @PostMapping("/end")
    public ParkingEnd endParking(@RequestParam String regNo) {
        logger.info("Ending car parking");
        return parkingService.endParking(regNo);
    }
}

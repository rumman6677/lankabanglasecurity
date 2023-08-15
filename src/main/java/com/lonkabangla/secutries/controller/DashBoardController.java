package com.lonkabangla.secutries.controller;


import com.lonkabangla.secutries.service.DashBoardService;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import java.util.HashMap;
import java.util.Map;

@RestController
@RequestMapping("/api/dashboard")
public class DashBoardController {

    private final DashBoardService dashBoardService;

    public DashBoardController(DashBoardService dashBoardService) {
        this.dashBoardService = dashBoardService;
    }

    @GetMapping("/countByGender")
    public ResponseEntity<Map<String, Long>> countByGender() {
        Long maleCount = dashBoardService.countmale();
        long femaleCount = dashBoardService.countFemale();

        Map<String, Long> counts = new HashMap<>();
        counts.put("male", maleCount);
        counts.put("female", femaleCount);

        return ResponseEntity.ok(counts);
    }

    @GetMapping("/division-city-counts")
    public ResponseEntity<Map<String, Long>> getDivisionCityCounts() {
        Map<String, Long> divisionMap = dashBoardService.getDivisionCityCounts();
        return ResponseEntity.ok(divisionMap);
    }

    @GetMapping("/userstatus")
    public ResponseEntity<?> getUserStatus()
    {
        Map<String ,Long> userStatus = dashBoardService.getUserStatus();

        return ResponseEntity.ok(userStatus);
    }

    @GetMapping("/userperbranch")
    public ResponseEntity<?> userPerbranch()
    {
        Map<String ,Long> userStatus = dashBoardService.getUserPerbranch();

        return ResponseEntity.ok(userStatus);
    }

    @GetMapping("/male/female/perbranch")
    public ResponseEntity<?> maleAndFemale(){
        Map<String,Map<String,Long>> maleAndFemale = dashBoardService.getMaleAndFemale();

        return ResponseEntity.ok(maleAndFemale);
    }

    @GetMapping("/account/peryear")
    public ResponseEntity<?> accountPeryear(){
        Map<Integer,Long> maleAndFemale = dashBoardService.accountPeryesr();

        return ResponseEntity.ok(maleAndFemale);
    }

}

package com.lonkabangla.secutries.controller;

import com.lonkabangla.secutries.dto.eftDto;
import com.lonkabangla.secutries.service.CommonService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

@RestController
@RequestMapping("api/v1")
public class CommonController {

    private final CommonService commonService;

    public CommonController(CommonService commonService) {
        this.commonService = commonService;
    }


    @PostMapping("/save/eft")
    public ResponseEntity<?> createEft(@RequestBody eftDto eft) {
        return new ResponseEntity<>(commonService.createEft(eft), HttpStatus.OK);
    }

    @GetMapping("/eft/{id}")
    public ResponseEntity<?> showEft(@PathVariable("id") Long id) {
        return new ResponseEntity<>(commonService.getEftById(id),HttpStatus.OK);
    }

    @GetMapping("/eft/list")
    public ResponseEntity<?> showEft() {
        return new ResponseEntity<>(commonService.getAll(),HttpStatus.OK);
    }
}

package com.lonkabangla.secutries.controller;

import com.lonkabangla.secutries.dto.BoDto;
import com.lonkabangla.secutries.dto.NomineeDto;
import com.lonkabangla.secutries.entity.BOAccount;
import com.lonkabangla.secutries.repository.BOAccountRepoRepo;
import com.lonkabangla.secutries.service.BoService;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/api/v1")
public class BOController {

    private final BOAccountRepoRepo formRepository;

    private final BoService boService;

    public BOController(BOAccountRepoRepo formRepository, BoService boService) {
        this.formRepository = formRepository;
        this.boService = boService;
    }


    @PostMapping("bo")
    public ResponseEntity<?> createForm(@RequestBody BoDto formData) {
        Long account = boService.save(formData);
        return new ResponseEntity<>(account, HttpStatus.OK);
    }

    @PostMapping("/nominee/{id}")
    public ResponseEntity<?> createNominee(@RequestBody NomineeDto dto) {
        Long nominee = boService.saveNominee(dto);

        return new ResponseEntity<>(nominee,HttpStatus.OK);
    }


}

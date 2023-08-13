package com.lonkabangla.secutries.service;

import com.lonkabangla.secutries.Enum.Status;
import com.lonkabangla.secutries.dto.eftDto;
import com.lonkabangla.secutries.entity.BankAccountDetails;
import com.lonkabangla.secutries.entity.EFT;
import com.lonkabangla.secutries.repository.*;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class CommonService {
    private final EFTrepo efTrepo;


    private final POARepo poaRepo;

    private final NomineeRepo nomineeRepo;

    private final BankDetailsRepo bankDetailsRepo;
    public CommonService(EFTrepo efTrepo, POARepo poaRepo, NomineeRepo nomineeRepo, BankDetailsRepo bankDetailsRepo) {
        this.efTrepo = efTrepo;
        this.poaRepo = poaRepo;
        this.nomineeRepo = nomineeRepo;
        this.bankDetailsRepo = bankDetailsRepo;
    }

    public EFT createEft(eftDto eft) {
        EFT eft1 = prepareEft(eft);
        BankAccountDetails bank = getBankAccountDetails(eft);
        bankDetailsRepo.save(bank);
        eft1.setBankAccountDetails(bank);
        efTrepo.save(eft1);

        return eft1;
    }

    private BankAccountDetails getBankAccountDetails(eftDto eft) {
        BankAccountDetails bank = new BankAccountDetails();
        bank.setBankName(eft.getBankName());
        bank.setBranchName(eft.getBranchName());
        bank.setAccountNo(eft.getAccountNo());
        bank.setRoutingNo(eft.getRoutingNo());

        return bank;
    }

    private EFT prepareEft(eftDto eft) {
        EFT eft1 = new EFT();
        eft1.setClintCode(eft.getClintCode());
        eft1.setDate(eft.getDate());
        eft1.setClientName(eft.getClientName());
        eft1.setMobileNumber(eft.getMobileNumber());
        eft1.setStatus(Status.REVIEW);
        return eft1;

    }

    public eftDto getEftById(Long id) {
        Optional<EFT> eft = efTrepo.findById(id);
        eftDto dto = new eftDto();
        if(eft.isPresent()) {
           dto = eftDto.form(eft.get());
           return dto;
        } return dto;
    }

    public List<eftDto> getAll() {
        List<EFT> list = efTrepo.findAll();
        return list.stream().map(eftDto::form).toList();
    }
}

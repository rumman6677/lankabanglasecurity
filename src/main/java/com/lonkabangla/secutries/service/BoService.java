package com.lonkabangla.secutries.service;


import com.lonkabangla.secutries.Enum.Status;
import com.lonkabangla.secutries.dto.BoDto;
import com.lonkabangla.secutries.dto.NomineeDto;
import com.lonkabangla.secutries.entity.Address;
import com.lonkabangla.secutries.entity.BOAccount;
import com.lonkabangla.secutries.entity.Nominee;
import com.lonkabangla.secutries.repository.AddressRepo;
import com.lonkabangla.secutries.repository.BOAccountRepoRepo;
import com.lonkabangla.secutries.repository.NomineeRepo;
import org.springframework.stereotype.Service;

@Service
public class BoService {

    private final BOAccountRepoRepo boAccountRepoRepo;

    private final AddressRepo addressRepo;

    private final NomineeRepo nomineeRepo;
    public BoService(BOAccountRepoRepo boAccountRepoRepo, AddressRepo addressRepo, NomineeRepo nomineeRepo) {
        this.boAccountRepoRepo = boAccountRepoRepo;
        this.addressRepo = addressRepo;
        this.nomineeRepo = nomineeRepo;
    }

    public Long  save(BoDto formData) {

        BOAccount boAccount = mapDtoToFormData(formData);

        Address address = preppareaddress(formData);

        Address newAdd = addressRepo.save(address);

        boAccount.setAddress(newAdd);

        BOAccount boAccount1 =  boAccountRepoRepo.save(boAccount);

        return boAccount1.getId();
    }

    private Address preppareaddress(BoDto formData) {
        Address address = new Address();
        address.setAddress(formData.getContactPerson());
        address.setPostCode(formData.getPostCode());
        address.setCountry(formData.getCountry());
        address.setCity(formData.getCity());
        return address;
    }

    public BOAccount mapDtoToFormData(BoDto dto) {
        BOAccount formData = new BOAccount();

        formData.setApplication(dto.getApplication());
        formData.setDate(dto.getDate());
        formData.setCategory(dto.getCategory());
        formData.setType(dto.getType());
        formData.setParticipant(dto.getParticipant());
        formData.setParticipantId(dto.getParticipantId());
        formData.setBoId(dto.getBoId());
        formData.setDateOpened(dto.getDateOpened());
        formData.setFullName(dto.getFullName());
        formData.setShortName(dto.getShortName());
        formData.setTitle(dto.getTitle());
        formData.setContactPerson(dto.getContactPerson());
        formData.setFatherName(dto.getFatherName());
        formData.setMotherName(dto.getMotherName());
        formData.setMobile(dto.getMobile());
        formData.setFax(dto.getFax());
        formData.setEmail(dto.getEmail());
        formData.setBranchNameLSL(dto.getLslbranchName());
        formData.setStatus(Status.CHECK);
        // Assuming you have appropriate methods in AccountFormDTO for these values
        return formData;
    }

    public Long saveNominee(NomineeDto dto) {

        Nominee nominee = prepareNominee(dto);
        Nominee nominee1 = nomineeRepo.save(nominee);
        return nominee1.getId();
    }

    private Nominee prepareNominee(NomineeDto dto) {

        Nominee nominee = new Nominee();
        nominee.setDateOfBirth(dto.getDateOfBirth());
        nominee.setName(dto.getName());
        nominee.setEmail(dto.getEmail());
        nominee.setRelationWithNominee(dto.getRelation());
        nominee.setPercentage(dto.getPercentage());

        return nominee;
    }
}

package com.sut.se.g02.controller;
import lombok.Data;
import org.springframework.http.MediaType;
import com.sut.se.g02.entity.*;

import com.sut.se.g02.repository.*;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;

import javax.print.Doc;
import java.util.Date;
import java.util.Collection;
import java.util.Optional;
import java.util.stream.Collectors;

import java.util.List;

@RestController
@CrossOrigin(origins = "http://localhost:4200")
public class PetInfoController {
    @Autowired
    private PetInfoRepository petInfoRepository;
    @Autowired
    private NurseRepository nurseRepository ;
    @Autowired
    private BreedRepository breedRepository;
    @Autowired
    private OwnerRepository ownerRepository;




     @GetMapping("/PetInfo")
    public List<PetInfo> PetInfo(){
        return petInfoRepository.findAll().stream().collect(Collectors.toList());
    }


     @GetMapping("/Breed")
    public List<Breed> Breed(){
        return breedRepository.findAll().stream().collect(Collectors.toList());
    }

    @PostMapping(path ="/PetInfo/{petName}/{breedNameSelect}/{nurseNameSelect}/" +
            "{weight}/{height}/{ownerName}/{ownerTel}/{age}")
    public PetInfo petInfo( @PathVariable String petName,
                            @PathVariable Long breedNameSelect ,
                            @PathVariable Long nurseNameSelect,
                            @PathVariable Double weight,
                            @PathVariable Double height,
                            @PathVariable String ownerName,
                            @PathVariable String ownerTel,
                            @PathVariable int age
    ){
        Breed  breed = breedRepository.findByBreedId(breedNameSelect);
        Nurse nurse = nurseRepository.findByNurseId(nurseNameSelect);

        PetInfo petInfo = new PetInfo();
        Owner owner = new Owner();
        owner.setOwnerName(ownerName);
        owner.setOwnerTel(ownerTel);


        ownerRepository.save(owner);
        petInfo.setPetName(petName);
        petInfo.setAge(age);
        petInfo.setWeight(weight);
        petInfo.setHeight(height);
        petInfo.setNurse(nurse);
        petInfo.setOwner(owner);
        petInfo.setBreed(breed);

        petInfoRepository.save(petInfo);
        return  petInfo;
    }







}

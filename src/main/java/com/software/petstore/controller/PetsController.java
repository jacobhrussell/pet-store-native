package com.software.petstore.controller;

import com.software.petstore.model.Pet;
import com.software.petstore.model.PetData;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.config.annotation.EnableWebMvc;

import java.security.Principal;
import java.util.Optional;
import java.util.UUID;

@RestController
@EnableWebMvc
public class PetsController {

    @GetMapping(path = "/pets")
    public Pet[] listPets(@RequestParam("limit") Optional<Integer> limit, Principal principal) {
        System.out.println("==> Listing Pets");
        int queryLimit = 10;
        if (limit.isPresent()) {
            queryLimit = limit.get();
        }

        Pet[] outputPets = new Pet[queryLimit];

        for (int i = 0; i < queryLimit; i++) {
            Pet newPet = new Pet();
            newPet.setId(UUID.randomUUID().toString());
            newPet.setName(PetData.getRandomName());
            newPet.setBreed(PetData.getRandomBreed());
            newPet.setDateOfBirth(PetData.getRandomDoB());
            outputPets[i] = newPet;
        }

        return outputPets;
    }

}

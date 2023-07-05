package com.blaquesystems.backend.controllers;


import com.blaquesystems.backend.models.Business;
import com.blaquesystems.backend.payload.response.MessageResponse;
import com.blaquesystems.backend.repository.BusinessRepository;
import com.blaquesystems.backend.repository.UserRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.Date;
import java.util.Objects;

@CrossOrigin(origins = "*", maxAge = 3600)
@RestController
@RequestMapping("/api/business")
public class BusinessController {

    @Autowired
    BusinessRepository businessRepository;

    @Autowired
    UserRepository userRepository;

    @PostMapping("/create/{id}")
    public ResponseEntity<?> create(@RequestBody Business business, @PathVariable("id") Long id){
        if (businessRepository.existsByName(business.getName())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: name is already taken!"));
        } else if (businessRepository.existsByEmail(business.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: email is already taken!"));
        } else if (businessRepository.existsByContact(business.getContact())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: contact  already in use!"));
        }
        if (!Objects.nonNull(userRepository.findById(id).get())){
            return ResponseEntity.badRequest().body(new MessageResponse("Error: User does not exist!"));
        }
        Date date = new Date();
        business.setCreatedAt(date);
        business.setUpdatedAt(date);
        business.setUser(userRepository.findById(id).get());
       return ResponseEntity.ok(businessRepository.save(business));
    };

    @PutMapping("/update/{id}")
    public ResponseEntity<?> update(@RequestBody Business business, @PathVariable("id") Long id){

        if (!Objects.nonNull(businessRepository.findById(id).get())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Business does not exist!"));
        }

        if (businessRepository.existsByName(business.getName()) && ) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: name is already taken!"));
        } else if (businessRepository.existsByEmail(business.getEmail())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: email is already taken!"));
        } else if (businessRepository.existsByContact(business.getContact())) {
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: contact  already in use!"));
        }
        Date date = new Date();
        business.setUpdatedAt(date);
        return ResponseEntity.ok(businessRepository.save(business));
    };

    @GetMapping("/list/{id}")
    public ResponseEntity<?> findOne(@PathVariable("id") Long id){

        if (!Objects.nonNull(businessRepository.findById(id).get())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Business does not exist!"));
        }

        return ResponseEntity.ok(businessRepository.findById(id).get());
    };

    @GetMapping("/list")
    public ResponseEntity<?> findALl(){

        if (!Objects.nonNull(businessRepository.findAll())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("No Businesses found!"));
        }

        return ResponseEntity.ok(businessRepository.findAll());
    };

    @DeleteMapping("/delete/{id}")
    public ResponseEntity<?> deleteOne(@PathVariable("id") Long id){

        if (!Objects.nonNull(businessRepository.findById(id).get())){
            return ResponseEntity
                    .badRequest()
                    .body(new MessageResponse("Error: Business does not exist!"));
        }
        businessRepository.deleteById(id);

        return ResponseEntity.ok().body(new MessageResponse("Business deleted successfully!"));
    };

    @DeleteMapping("/list/delete")
    public ResponseEntity<?> deleteAll(){
        businessRepository.deleteAll();

        return ResponseEntity.ok().body(new MessageResponse("All Businesses deleted successfully!"));
    };
}

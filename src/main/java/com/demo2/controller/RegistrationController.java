package com.demo2.controller;

import com.demo2.entity.Registration4;
import org.springframework.web.bind.annotation.*;
import com.demo2.service.RegistrationService;

import java.util.List;

@RestController
@RequestMapping("/api/v1/registration")
public class RegistrationController {

    private final RegistrationService registrationService;

    public RegistrationController(RegistrationService registrationService){
        this.registrationService = registrationService;
    }

    @PostMapping("/add")
    public String addRegistration(@RequestBody Registration4 registration){ //RequestBody will copy the data from the JSON object and paste into the Registration object
        registrationService.saveRegistration(registration);
        return "Record added successfully";
    }

    @DeleteMapping("/delete/{id}")
    public String deleteRegistration(@RequestParam long id){
        registrationService.deleteRegistrationById(id);
        return "Record deleted successfully";
    }

    @PutMapping("/update/{id}")
    public String updateRegistration(@PathVariable long id, @RequestBody Registration4 registration){
        registrationService.updateRegistration(id,registration);
        return "Record updated successfully";
    }

    @GetMapping("/get/{id}")
    public Registration4 getRegistrationById(@PathVariable long id){
        return registrationService.getRegistrationById(id);
    }

    @GetMapping("/getAll")
    public List<Registration4> getAllRegistrations(){
        return registrationService.getAllRegistrations();
    }
}

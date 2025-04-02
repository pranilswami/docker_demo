package com.demo2.service;

import com.demo2.entity.Registration4;
import org.springframework.stereotype.Service;
import com.demo2.repository.RegistrationRepository;

import java.util.List;
import java.util.Optional;

@Service
public class RegistrationService {
    private final RegistrationRepository registrationRepository;

    public RegistrationService(RegistrationRepository registrationRepository) {
        this.registrationRepository = registrationRepository;
    }


    public void saveRegistration(Registration4 registration) {
        registrationRepository.save(registration);
    }

    public void deleteRegistrationById(long id) {
        registrationRepository.deleteById(id);
    }

    public void updateRegistration(long id, Registration4 registration) {
        Optional<Registration4> opReg = registrationRepository.findById(id);
        Registration4 reg = opReg.get();
        reg.setName(registration.getName());
        reg.setEmailId(registration.getEmailId());
        reg.setMobile(registration.getMobile());
        registrationRepository.save(reg);
    }

    public Registration4 getRegistrationById(long id) {
        Optional<Registration4> opReg = registrationRepository.findById(id);
        return opReg.get();
    }

    public List<Registration4> getAllRegistrations() {
        return registrationRepository.findAll();
    }
}

package com.example.Service.DB.ManyToMany;


import com.example.Entity.DB.ManyToMany.Patient;
import com.example.Repository.ManyToMany.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class PatientServiceImpl implements PatientService {

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Patient save(Patient patient) {
        return patientRepository.save(patient);
    }

    @Override
    public Patient findById(long id) {
        return patientRepository.findById(id).get();
    }

    @Override
    public Patient update(Patient patient, long id) {
        Patient p = patientRepository.findById(id).get();
        p.setAddress(patient.getAddress());
        p.setDisease(patient.getDisease());
        p.setGender(patient.getGender());
        p.setFirstName(patient.getFirstName());
        p.setLastName(patient.getLastName());
        p.setBirthDate(patient.getBirthDate());
        p.setDoctors(patient.getDoctors());
        return patientRepository.save(p);
    }

    @Override
    public void delete(long id) {
        patientRepository.deleteById(id);
    }

    @Override
    public List<Patient> getAllPatients() {
        return patientRepository.findAll();
    }
}

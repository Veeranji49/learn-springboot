package com.example.Service.DB.ManyToMany;


import com.example.Entity.DB.ManyToMany.Patient;

import java.util.List;

public interface PatientService {

    public Patient save(Patient patient);
    public Patient findById(long id);
    public Patient update(Patient patient,long id);
    public void delete(long id);
    public List<Patient> getAllPatients();
}

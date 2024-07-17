package com.example.Service.DB.ManyToMany;

import com.example.Entity.DB.ManyToMany.Doctor;

import java.util.List;

public interface DoctorService {

    public Doctor addDoctor(Doctor doctor);
    public Doctor updateDoctor(Doctor doctor,long id);
    public Doctor getDoctor(long id);
    public void deleteDoctor(long id);
    public List<Doctor> getAllDoctors();
    public List<String> getNameCategory();
    public List<Doctor> getDoctorsWithNoPatients();
    public  Doctor assignPatientToDoctor(long doctorId, long patientId);
}

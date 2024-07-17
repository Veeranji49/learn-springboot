package com.example.Service.DB.ManyToMany;

import com.example.Entity.DB.ManyToMany.Doctor;
import com.example.Entity.DB.ManyToMany.Patient;
import com.example.Repository.ManyToMany.DoctorRepository;
import com.example.Repository.ManyToMany.PatientRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;

@Service
public class DoctorServiceImpl implements DoctorService {

    @Autowired
    private DoctorRepository doctorRepository;

    @Autowired
    private PatientRepository patientRepository;

    @Override
    public Doctor addDoctor(Doctor doctor) {
        return doctorRepository.save(doctor);
    }

    @Override
    public Doctor updateDoctor(Doctor doctor, long id) {
        Doctor d = doctorRepository.findById(id).get();
        d.setName(doctor.getName());
        d.setAge(doctor.getAge());
        d.setCategory(doctor.getCategory());
        d.setHospital_name(doctor.getHospital_name());
        d.setPatients(doctor.getPatients());
        return doctorRepository.save(d);
    }

    @Override
    public Doctor getDoctor(long id) {
        return doctorRepository.findById(id).get();
    }

    @Override
    public void deleteDoctor(long id) {
        doctorRepository.deleteById(id);
    }

    @Override
    public List<Doctor> getAllDoctors() {
        return doctorRepository.findAll();
    }

    @Override
    public List<String> getNameCategory() {
        return doctorRepository.findNameCategory();
    }

    @Override
    public List<Doctor> getDoctorsWithNoPatients() {
        return doctorRepository.findDoctorsWithNoPatients();
    }

    @Override
    public Doctor assignPatientToDoctor(long doctorId, long patientId) {
        Optional<Doctor> optionalDoctor = doctorRepository.findById(doctorId);
        Optional<Patient> optionalPatient = patientRepository.findById(patientId);

        if (optionalDoctor.isPresent() && optionalPatient.isPresent()) {
            Doctor doctor = optionalDoctor.get();
            Patient patient = optionalPatient.get();

            doctor.getPatients().add(patient);
            return doctorRepository.save(doctor);
        } else {
            return null; // Handle the case where doctor or patient is not found
        }
    }
}

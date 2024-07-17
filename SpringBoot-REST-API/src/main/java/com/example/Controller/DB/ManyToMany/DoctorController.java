package com.example.Controller.DB.ManyToMany;


import com.example.Entity.DB.ManyToMany.Doctor;
import com.example.Service.DB.ManyToMany.DoctorService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/doctor")
public class DoctorController {

    @Autowired
    private DoctorService doctorService;

    private static final Logger logger = LoggerFactory.getLogger(DoctorController.class);

    @PostMapping(value = "/save-doctor")
    public ResponseEntity<Doctor> addDoctor(@RequestBody Doctor doctor) {
        Doctor d = doctorService.addDoctor(doctor);
        logger.info("MethodName: {}", "addDoctor", "Doctor: {}", doctor);
        return new ResponseEntity<>(d, HttpStatus.CREATED);
    }

    @PutMapping(value = "/update-doctor/{id}")
    public ResponseEntity<Doctor> updateDoctor(@RequestBody Doctor doctor, @PathVariable long id) {
        Doctor d = doctorService.updateDoctor(doctor, id);
        logger.info("MethodName: {}", "updateDoctor", "Doctor: {}", doctor , "id: {}", id);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-doctor/{id}")
    public ResponseEntity<String> deleteDoctor(@PathVariable long id) {
        doctorService.deleteDoctor(id);
        logger.info("MethodName: {}", "deleteDoctor", "id: {}", id);
        return new ResponseEntity<>("Doctor deleted", HttpStatus.OK);
    }

    @GetMapping(value = "/getall-doctors")
    public ResponseEntity<List<Doctor>> getAllDoctors() {
        List<Doctor> doctors = doctorService.getAllDoctors();
        logger.info("MethodName: {}", "getAllDoctors", "Doctors: {}", doctors);
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @GetMapping(value = "/getone-doctor/{id}")
    public ResponseEntity<Doctor> getDoctorById(@PathVariable long id) {
        Doctor d = doctorService.getDoctor(id);
        logger.info("MethodName: {}", "getDoctorById", "id: {}", id);
        return new ResponseEntity<>(d, HttpStatus.OK);
    }


    /////  Retrieving specific columns   ////

    @GetMapping(value="/getall-name-category")
    public ResponseEntity<List<String>> getNamesCategories(){
        List<String> namescategories = doctorService.getNameCategory();
        logger.info("MethodName: {}", "getNamesCategories", "NameCategory: {}", namescategories);
        return new ResponseEntity<>(namescategories, HttpStatus.OK);
    }

    @GetMapping(value = "/get-doctors-with-no-patients")
    public ResponseEntity<List<Doctor>> getDoctorsWithNoPatients() {
        List<Doctor> doctors = doctorService.getDoctorsWithNoPatients();
        return new ResponseEntity<>(doctors, HttpStatus.OK);
    }

    @PostMapping(value = "/assign-patient")
    public ResponseEntity<Doctor> assignPatientToDoctor(@RequestParam long doctorId, @RequestParam long patientId) {
        Doctor doctor = doctorService.assignPatientToDoctor(doctorId, patientId);
        if (doctor != null) {
            return new ResponseEntity<>(doctor, HttpStatus.OK);
        } else {
            return new ResponseEntity<>(HttpStatus.NOT_FOUND);
        }
    }
}

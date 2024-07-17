package com.example.Controller.DB.ManyToMany;


import com.example.Entity.DB.ManyToMany.Patient;
import com.example.Service.DB.ManyToMany.PatientService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value = "/api/v1/patient")
public class PatientController {

    @Autowired
    private PatientService patientService;

    private static final Logger logger = LoggerFactory.getLogger(PatientController.class);

    @PostMapping(value = "/add-patient/{doctor_id}")
    public ResponseEntity<Patient> addPatient(@RequestBody Patient patient) {
        Patient p = patientService.save(patient);
        logger.info("MethodName: {}", "addPatient", "Patient : {}", patient);
        return new ResponseEntity<>(p, HttpStatus.CREATED);
    }

    @GetMapping(value = "/getone-patient/{id}")
    public ResponseEntity<Patient> getPatientById(@PathVariable long id) {
        Patient p = patientService.findById(id);
        logger.info("MethodName: {}", "getPatientById", "id : {}", id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @PutMapping(value = "/update-patient/{id}")
    public ResponseEntity<Patient> updatePatient(@RequestBody Patient patient, @PathVariable long id) {
        Patient p = patientService.update(patient, id);
        logger.info("MethodName: {}", "updatePatient", "Patient :{}",patient, "id : {}", id);
        return new ResponseEntity<>(p, HttpStatus.OK);
    }

    @DeleteMapping(value = "/delete-patient/{id}")
    public ResponseEntity<String> deletePatient(@PathVariable long id) {
        patientService.delete(id);
        logger.info("MethodName: {}", "deletePatient", "id :{}", id);
        return new ResponseEntity<>("patient deleted successfully", HttpStatus.OK);
    }

    @GetMapping(value = "/getall-patients")
    public ResponseEntity<List<Patient>> getAllPatients() {
        List<Patient> patient = patientService.getAllPatients();
        logger.info("MethodName: {}", "getAllPatients", "patient list : {}", patient);
        return new ResponseEntity<>(patient, HttpStatus.OK);
    }
}

/*
    {
    "id": 4,
    "name": "veeranjisdfjfl",
    "category": "Pefdfsddjn",
    "age": 243,
    "hospital_name": "anji Hosdfdfvdpital",
    "patients": [
        {
            "id": 4,
            "firstName": "ansddsajieru",
            "lastName": "Dasddoe",
            "gender": "Male",
            "birthDate": "1990-01-01",
            "address": "123 Maisdsdn St",
            "disease": "Fevesxddr",
            "doctors": []
        }
    ]
}
 */
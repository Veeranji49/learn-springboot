package com.example.Controller.DB.OneToOne;

import com.example.Entity.DB.OneToOne.StudentAddress;
import com.example.Service.DB.OneToOne.StudentAddressService;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping(value="/api/v1/address")
public class StudentAddressController {

    @Autowired
    private StudentAddressService studentAddressService;

    private static final Logger logger = LoggerFactory.getLogger(StudentAddressController.class);

    @PostMapping(value="/add-student-address")
    public ResponseEntity<StudentAddress> addStudentAddress(@RequestBody StudentAddress studentAddress) {
        StudentAddress studentAddress1 = studentAddressService.save(studentAddress);
        logger.info("MethodName: {}", "addStudentAddress", "studentAddress: {}", studentAddress);
        return new ResponseEntity<>(studentAddress1, HttpStatus.CREATED);
    }

    @GetMapping(value="/getone-student-address/{id}")
    public ResponseEntity<StudentAddress> getOneStudentAddress(@PathVariable long id) {
        StudentAddress studentAddress = studentAddressService.findById(id);
        logger.info("MethodName: {}", "getOneStudentAddress", "id: {}", id);
        return new ResponseEntity<>(studentAddress, HttpStatus.OK);
    }

    @GetMapping(value="/getall-student-address")
    public ResponseEntity<List<StudentAddress>> getAllStudentAddress() {
        List<StudentAddress> studentAddressList = studentAddressService.findAll();
        logger.info("MethodName: {}", "getAllStudentAddress", "studentAddressList: {}", studentAddressList);
        return new ResponseEntity<>(studentAddressList, HttpStatus.OK);
    }

    @PutMapping(value="/update-student-address/{id}")
    public ResponseEntity<StudentAddress> updateStudentAddress(@RequestBody StudentAddress studentAddress, @PathVariable long id) {
        StudentAddress studentAddress1 = studentAddressService.update(studentAddress, id);
        logger.info("MethodName: {}", "updateStudentAddress", "studentAddress: {}", studentAddress, "id: {}",id);
        return new ResponseEntity<>(studentAddress1, HttpStatus.OK);
    }

    @DeleteMapping(value="/delete-student-address/{id}")
    public ResponseEntity<StudentAddress> deleteStudentAddress(@PathVariable long id) {
         studentAddressService.deleteById(id);
         logger.info("MethodName: {}", "deleteStudentAddress", "id: {}", id);
        return new ResponseEntity<>(HttpStatus.OK);
    }

    ////  Retrieving Specific address of students   ////

    @GetMapping(value="/student-streets")
    public ResponseEntity<List<String>> getStudentStreets() {
        logger.info("MethodName: {}", "getStudentStreets", "");
        return ResponseEntity.ok(studentAddressService.getStreet());
    }

    @GetMapping(value="/student-city")
    public ResponseEntity<List<String>> getStudentCity() {
        logger.info("MethodName: {}", "getStudentCity", "");
        return ResponseEntity.ok(studentAddressService.getCity());
    }

    @GetMapping(value="/student-state")
    public ResponseEntity<List<String>> getStudentState() {
        logger.info("MethodName: {}", "getStudentState", "");
        return ResponseEntity.ok(studentAddressService.getState());
    }

    @GetMapping(value="/student-addresses")
    public ResponseEntity<List<String>> getStudentAddresses() {
        logger.info("MethodName: {}", "getStudentAddresses", "");
        return ResponseEntity.ok(studentAddressService.findByStreetSate());
    }
}

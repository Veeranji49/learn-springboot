package com.example.Service.DB.OneToOne;

import com.example.Entity.DB.OneToOne.StudentAddress;
import com.example.Repository.OneToOne.StudentAddressRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class StudentAddressServiceImpl implements StudentAddressService {

    @Autowired
    private StudentAddressRepository studentAddressRepository;

    @Override
    public List<StudentAddress> findAll() {
        return studentAddressRepository.findAll();
    }

    @Override
    public StudentAddress findById(long id) {
        return studentAddressRepository.findById(id).get();
    }

    @Override
    public StudentAddress save(StudentAddress studentAddress) {
        return studentAddressRepository.save(studentAddress);
    }

    @Override
    public void deleteById(long id) {
        studentAddressRepository.deleteById(id);
    }

    @Override
    public StudentAddress update(StudentAddress studentAddress, long id) {
        StudentAddress studentAddress1 = studentAddressRepository.findById(id).get();
        //studentAddress1.setId(studentAddress.getId());
        studentAddress1.setStreet(studentAddress.getStreet());
        studentAddress1.setCity(studentAddress.getCity());
        studentAddress1.setState(studentAddress.getState());
        return studentAddressRepository.save(studentAddress1);
    }

    @Override
    public List<String> getStreet() {
        return studentAddressRepository.findByStreet();
    }

    @Override
    public List<String> getCity() {
        return studentAddressRepository.findByCity();
    }

    @Override
    public List<String> getState() {
        return studentAddressRepository.findByState();
    }

    @Override
    public List<String> findByStreetSate() {
        return studentAddressRepository.findByStreetStateAndCity();
    }
}

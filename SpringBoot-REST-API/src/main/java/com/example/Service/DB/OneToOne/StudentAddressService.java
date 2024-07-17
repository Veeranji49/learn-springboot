package com.example.Service.DB.OneToOne;

import com.example.Entity.DB.OneToOne.StudentAddress;

import java.util.List;

public interface StudentAddressService {
    public List<StudentAddress> findAll();
    public StudentAddress findById(long id);
    public StudentAddress save(StudentAddress studentAddress);
    public void deleteById(long id);
    public StudentAddress update(StudentAddress studentAddress,long id);
    public List<String> getStreet();
    public List<String> getCity();
    public List<String> getState();
    public List<String> findByStreetSate();
}

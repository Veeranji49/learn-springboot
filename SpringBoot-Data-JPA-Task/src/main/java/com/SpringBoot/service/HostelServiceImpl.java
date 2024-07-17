package com.SpringBoot.service;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.SpringBoot.Entity.Hostel;
import com.SpringBoot.Repository.HostelRepository;

@Service
public class HostelServiceImpl implements HostelService {

	@Autowired
	private HostelRepository hostelRepo;
	
	@Override
	public Hostel insert(Hostel hostel) {
		return hostelRepo.save(hostel);
	}

	@Override
	public Hostel update(Hostel hostel) {
		return hostelRepo.save(hostel);
	}

	@Override
	public void delete(long id) {
		hostelRepo.deleteById(id);
	}

	@Override
	public Hostel getone(long id) {
		return hostelRepo.findById(id).get();
	}

	@Override
	public List<Hostel> getAll() {
		return hostelRepo.findAll();
	}

}

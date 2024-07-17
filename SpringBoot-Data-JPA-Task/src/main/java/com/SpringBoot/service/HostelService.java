package com.SpringBoot.service;

import java.util.List;

import com.SpringBoot.Entity.Hostel;

public interface HostelService {

	public Hostel insert(Hostel hostel);
	public Hostel update(Hostel hostel);
	public void delete(long id);
	public Hostel getone(long id);
	public List<Hostel> getAll();
}

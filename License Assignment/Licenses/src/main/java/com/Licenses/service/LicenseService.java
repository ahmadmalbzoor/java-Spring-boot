package com.Licenses.service;

import java.util.List;
import java.util.Optional;

import org.springframework.stereotype.Service;

import com.Licenses.models.Licensess;
import com.Licenses.models.Person;
import com.Licenses.repositories.LicensesRepositories;
import com.Licenses.repositories.PersonRepositories;
@Service
public class LicenseService {
	private final LicensesRepositories licensesRepositories;
	public LicenseService(LicensesRepositories licensesRepositories )
	{
		this.licensesRepositories=licensesRepositories;
	}
	public List<Licensess> allLicenses()
	{
		return licensesRepositories.findAll();
	}
	public Licensess createLicenses(Licensess l)
	{	l.setNumber(this.createNumber());
		return licensesRepositories.save(l);
	}
	public int createNumber() {
		Licensess license = licensesRepositories.findTopByOrderByNumberDesc();
		
		if(license == null)
			return 1;
		int LisNumber = license.getNumber();
		LisNumber++;
		return (LisNumber);
	}
	
	public Licensess findLicenses(Long id)
	{
		Optional<Licensess>optionalLicense=licensesRepositories.findById(id);
		if(optionalLicense.isPresent())
		{
			return optionalLicense.get();
		} else

			return null;
		}
	
	
}



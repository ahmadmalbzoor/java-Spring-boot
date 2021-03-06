package com.Licenses.repositories;

import java.util.List;

import org.springframework.data.repository.CrudRepository;
import org.springframework.stereotype.Repository;

import com.Licenses.models.Licensess;

@Repository
public interface LicensesRepositories extends CrudRepository<Licensess, Long> {
	List<Licensess> findAll();
	Licensess findTopByOrderByNumberDesc();
}

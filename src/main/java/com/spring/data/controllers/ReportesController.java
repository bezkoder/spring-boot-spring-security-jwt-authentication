package com.spring.data.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.spring.data.models.Reportes;
import com.spring.data.repository.ReportesRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;



@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/reportes")
public class ReportesController {
    @Autowired
	ReportesRepository reportesRepository;

	@GetMapping("/all")
	public ResponseEntity<List<Reportes>> getAllUsers(/*@RequestParam(required = false) String username*/) {
		try {
			List<Reportes> reportes = new ArrayList<Reportes>();

			//if (username == null)
				reportesRepository.findAll().forEach(reportes::add);
			//else
			//	userRepository.findByStringContaining(username).forEach(users::add);

			if (reportes.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(reportes, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

	@GetMapping("/{id}")
	public ResponseEntity<Reportes> getUserById(@PathVariable("id") long id) {
		Optional<Reportes> reportesData = reportesRepository.findById(id);

		if (reportesData.isPresent()) {
			return new ResponseEntity<>(reportesData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @PostMapping("/create/{user_id}/{user_id_reported}")
    public ResponseEntity<Reportes> createReport(@RequestBody Reportes reportes) { 
        try {
            Reportes _reportes = reportesRepository.save(new Reportes(reportes.getUserId(), reportes.getUserId_reported(), reportes.getMotiu(), reportes.getComentari(), reportes.getProva(), reportes.getSolucionado()));
            return new ResponseEntity<>(_reportes, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }

    @PutMapping("/update/{id}")
	public ResponseEntity<Reportes> updateModo(@PathVariable("id") long id, @RequestBody Reportes reportes) {
		Optional<Reportes> reportesData = reportesRepository.findById(id);

		if (reportesData.isPresent()) {
			Reportes _reportes = reportesData.get();
			_reportes.setSolucionado(reportes.getSolucionado());
			return new ResponseEntity<>(reportesRepository.save(_reportes), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}



}

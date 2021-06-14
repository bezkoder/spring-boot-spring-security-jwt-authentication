package com.spring.data.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.spring.data.models.Match;
import com.spring.data.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "http://localhost:8080")
@RestController
@RequestMapping("/match")
public class MatchController {

    @Autowired
	MatchRepository matchRepository;

    @GetMapping("/{id}")
	public ResponseEntity<Match> getMatchById(@PathVariable("id") long id) {
		Optional<Match> matchData = matchRepository.findById(id);

		if (matchData.isPresent()) {
			return new ResponseEntity<>(matchData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    /*@GetMapping("/{user_id_1}/{user_id_2}")
	public Match getUserByIdandModo(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") Long user_id_2) {
		return matchRepository.findIsMatch(user_id_1, user_id_2);
	}

    @GetMapping("/user/{user_id_1}")
	public Match getUserMatches(@PathVariable("user_id_1") long user_id_1) {
		return matchRepository.findUserMatches(user_id_1);
	}*/
    
}


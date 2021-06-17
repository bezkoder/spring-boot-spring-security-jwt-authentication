package com.spring.data.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.spring.data.models.Matches;
import com.spring.data.repository.*;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
//import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/match")
public class MatchesController {

    @Autowired
	MatchesRepository matchesRepository;


	/*				RETORNI TOTS ELS USERS QUE NO HA FET MATCH
	@GetMapping("/all/{user_id_1}")
	public ResponseEntity<List<Matches>> getAllUsers(@PathVariable("user_id_1") long user_id_1) {
		try {
			List<Matches> matches = new ArrayList<Matches>();

			
			matchesRepository.findUserNotMatches(user_id_1).forEach();
			/*else
				matchesRepository.findByStringContaining(nom).forEach(users::add);

			if (matches.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}

			return new ResponseEntity<>(matches, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}*/


	
	
	//Mirar si fa match
	/*@PostMapping("/{user_id_1}/{user_id_}")
	public Boolean isMatch(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_1") long user_id_2, @RequestParam Boolean liked_2) {
		Optional<Matches> matchData = matchesRepository.findTableByUsers(user_id_1, user_id_2);
		if (matchData.isPresent()) {
			if (matchesRepository.alreadyLiked(user_id_1, user_id_2) && liked_2 == true){
				Matches _matches = matchData.get();
				_matches.setIs_Liked(matches.getIs_Liked());
				getTableId(user_id_1, user_id_2);
			}
	
			
			*/




	
	//Retorna Id de la taula
	@GetMapping("/getTableId/{user_id_1}/{user_id_2}")
	public Long getTableId(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") long user_id_2) {
		return matchesRepository.findIdByUsers(user_id_1, user_id_2);
	}

	@GetMapping("/getTableId/{user_id_1}/{user_id_2}") //Funcio auxiliar cridada a isMatch
	public ResponseEntity<Matches> getTable(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") long user_id_2) {
		Optional<Matches> matchData = matchesRepository.findTableByUsers(user_id_1, user_id_2);
		if (matchData.isPresent()) {
			Matches _matches = matchData.get();
			return new ResponseEntity<>(matchesRepository.save(_matches), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}	
	

	//Retorna taula matches del user id_1, id_2 --> No se si funciona
	@GetMapping("/getTable/{user_id_1}/{user_id_2}")
	public ResponseEntity<Matches> getMatch(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") long user_id_2) {
		Optional<Matches> matchData = matchesRepository.findByMatches(user_id_1, user_id_2);

		if (matchData.isPresent()) {
			Matches _matches = matchData.get();
			return new ResponseEntity<>(matchesRepository.save(_matches), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}	

	@PutMapping("/like/{user_id_1}/{user_id_}")
	public ResponseEntity<Matches> updateMatch(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_1") long user_id_2, @RequestBody Matches matches) {
		Optional<Matches> matchData = matchesRepository.findByMatches(user_id_1, user_id_2);

		if (matchData.isPresent()) {
			Matches _matches = matchData.get();
			_matches.setIs_Liked(matches.getIs_Liked());
			return new ResponseEntity<>(matchesRepository.save(_matches), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
	


    @GetMapping("/{id}")
	public ResponseEntity<Matches> getMatchById(@PathVariable("id") long id) {
		Optional<Matches> matchData = matchesRepository.findById(id);

		if (matchData.isPresent()) {
			return new ResponseEntity<>(matchData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    @GetMapping("/{user_id_1}/{user_id_2}")
	public Boolean isMatch(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") Long user_id_2) {
		return matchesRepository.findIsMatch(user_id_1, user_id_2);
	}

    @GetMapping("/user/{user_id_1}")
	public List<Matches> getUserMatches(@PathVariable("user_id_1") long user_id_1) {
		
		return matchesRepository.findUserMatches(user_id_1);
	}


    
}


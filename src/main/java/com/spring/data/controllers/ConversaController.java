package com.spring.data.controllers;

import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.spring.data.models.Conversa;
import com.spring.data.repository.ConversaRepository;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.CrossOrigin;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@CrossOrigin(origins = "*")
@RestController
@RequestMapping("/conversa")
public class ConversaController {
    @Autowired
	ConversaRepository conversaRepository;

    @GetMapping("/all")
	public ResponseEntity<List<Conversa>> getAllUsers(/*@RequestParam(required = false) String username*/) {
		try {
			List<Conversa> reportes = new ArrayList<Conversa>();

			//if (username == null)
				conversaRepository.findAll().forEach(reportes::add);
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
	public ResponseEntity<Conversa> getUserById(@PathVariable("id") long id) {
		Optional<Conversa> userData = conversaRepository.findById(id);

		if (userData.isPresent()) {
			return new ResponseEntity<>(userData.get(), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}

    /*@PostMapping("/newconversa/{user_id_1}/{user_id_2}")
    public ResponseEntity<Conversa> novaConversa(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") long user_id_2, @PathVariable("time_started") String time_started@RequestBody Conversa conversa) { 
	try {
		Conversa _conversa = conversaRepository.save(new Conversa(conversa.getUser_Id_creador(), conversa.getUser_Id_segon(), conversa.getTimeStarted()));
		return new ResponseEntity<>(_conversa, HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}*/

@PostMapping("/newconversa/{user_id_1}/{user_id_2}")
public ResponseEntity<Conversa> novaConversa(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") long user_id_2 /* @PathVariable("time_started") String time_started@RequestBody Conversa conversa*/) { 
try {
	Conversa _conversa = conversaRepository.save(new Conversa(user_id_1, user_id_2/*, conversa.getTimeStarted())*/));
	return new ResponseEntity<>(_conversa, HttpStatus.CREATED);
} catch (Exception e) {
	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
}
}


}

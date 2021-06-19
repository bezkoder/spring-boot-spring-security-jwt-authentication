package com.spring.data.controllers;
import java.util.ArrayList;
import java.util.List;
import java.util.Optional;

import com.fasterxml.jackson.databind.deser.DataFormatReaders.Match;
import com.spring.data.models.Matches;
import com.spring.data.repository.*;
import com.spring.data.controllers.ConversaController;

import com.spring.data.models.Conversa;

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
@RequestMapping("/matches")
public class MatchesController {

    @Autowired
	MatchesRepository matchesRepository;

	@Autowired
	ConversaRepository conversaRepository;


			
	@GetMapping("/all")
	public ResponseEntity<List<Matches>> getAllUsers() {
		try {
			List<Matches> matches = new ArrayList<Matches>();

			matchesRepository.findAllMatches().forEach(matches::add);

			if (matches.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(matches, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
		
	
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


	//Falta fer una query per crear una nova entrada a la taula amb el like
	
	//Mirar si fa match ---> Implementat de moment amb un request body // Error: No converter found capable of converting from type [java.lang.Integer] to type [java.lang.Boolean]
	


	//@PutMapping("/{user_id_1}/{user_id_2}/{liked_2}")
    public Boolean isMatch(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") long user_id_2, @PathVariable("liked_2") boolean liked_2) {
        Optional<Matches> matchData = matchesRepository.findTableByUsers(user_id_1, user_id_2);
        if (matchData.isPresent()) {
            Matches _matches = matchData.get();
			boolean isliked = matchesRepository.alreadyLiked(user_id_1, user_id_2) > 0;
            if (isliked && liked_2 == true) {
                //Matches _matches = matchData.get();
                _matches.setLiked_2(liked_2);
                _matches.setIs_Match(true);
               // matchesRepository.save(matchData);
                return true;
            }
            else {
                //_matches.setLiked_2(false);
                return false;
        }
        
    }
    else return false; 
}





/*
@PutMapping("/{user_id_1}/{user_id_2}/{liked_2}")
	public ResponseEntity<Matches> isMatch2(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") long user_id_2, @PathVariable("liked_2") boolean liked_2) {
		Optional<Matches> matchData = matchesRepository.findTableByUsers(user_id_1, user_id_2);
		if (matchData.isPresent()) {
			Matches _matches = matchData.get();
			boolean isliked = matchesRepository.alreadyLiked(user_id_1, user_id_2) > 0;
			if (isliked && liked_2 == true) {

				//Matches _matches = matchData.get();
				_matches.setLiked_2(liked_2);
				_matches.setIs_Match(true);
				//matchesRepository.save(matchData);
				return new ResponseEntity<>(matchesRepository.save(_matches), HttpStatus.OK);
			}
			else if (liked_2 == true) {
				@PostMapping("/addShoe")
				public Shoe addShoe(@RequestBody Shoe shoe) {
					return shoeRepository.save(shoe);
				}
			}
			else {

				//_matches.setLiked_2(false);
				return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
		
	}
	return new ResponseEntity<>(HttpStatus.NOT_FOUND);
}*/

/*@PostMapping("/newlike/{user_id_1}/{user_id_2}")
public ResponseEntity<Matches> liked(@PathVariable("user_id_1") Long user_id_1, @PathVariable("user_id_2") Long user_id_2) { 
	try {
		Matches _matches = matchesRepository.save(new Matches((long)1, (long)5, true, false, false));
		return new ResponseEntity<>(_matches, HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}*/

@PostMapping("/newlike")
public ResponseEntity<Matches> liked(@RequestBody Matches matches) { 
	try {
		Matches _matches = matchesRepository.save(new Matches(matches.getUser_Id_1(), matches.getUser_Id_2(), true, false, false));
		return new ResponseEntity<>(_matches, HttpStatus.CREATED);
	} catch (Exception e) {
		return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
	}
}

@PostMapping("/newconversa/{user_id_1}/{user_id_2}")
public ResponseEntity<Conversa> novaConversa(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") long user_id_2 /* @PathVariable("time_started") String time_started@RequestBody Conversa conversa*/) { 
try {
	Conversa _conversa = conversaRepository.save(new Conversa(user_id_1, user_id_2));/*, conversa.getTimeStarted())*/
	return new ResponseEntity<>(_conversa, HttpStatus.CREATED);
} catch (Exception e) {
	return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
}
}

@PostMapping("/{user_id_1}/{user_id_2}/{user_liked}")
	public ResponseEntity<Matches> isMatch2(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") long user_id_2, @PathVariable("user_liked") Boolean user_liked, @RequestBody (required=false) Matches matches /*@RequestBody (required=false) Conversa conversa*/) {
		Optional<Matches> matchData = matchesRepository.findTableByUsers(user_id_1, user_id_2);
		if (matchData.isPresent()) {
			Matches _matches = matchData.get();
			boolean isliked = matchesRepository.alreadyLiked(user_id_1, user_id_2) > 0;
			if (isliked && user_liked == true) {

				//Matches _matches = matchData.get();
				_matches.setLiked_2(user_liked);
				_matches.setIs_Match(true);
				//matchesRepository.save(matchData);
				novaConversa(user_id_1, user_id_2);
				return new ResponseEntity<>(matchesRepository.save(_matches), HttpStatus.OK);
			}
		}
		else if (user_liked == true) {
			liked(matches);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}

/*7@PostMapping("/{user_id_1}/{user_id_2}/{user_liked}")
	public ResponseEntity<Matches> isMatch2(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") long user_id_2, @PathVariable("user_liked") Boolean user_liked, @RequestBody (required=false) Matches matches) {
		Optional<Matches> matchData = matchesRepository.findTableByUsers(user_id_1, user_id_2);
		if (matchData.isPresent()) {
			Matches _matches = matchData.get();
			boolean isliked = matchesRepository.alreadyLiked(user_id_1, user_id_2) > 0;
			if (isliked && user_liked == true) {

				//Matches _matches = matchData.get();
				_matches.setLiked_2(user_liked);
				_matches.setIs_Match(true);
				//matchesRepository.save(matchData);
				return new ResponseEntity<>(matchesRepository.save(_matches), HttpStatus.OK);
			}
		}
		else if (user_liked == true) {
			Matches _matches = matchesRepository.save(new Matches(matches.getUser_Id_1(), matches.getUser_Id_2(), matches.getLiked_1(), false, false));
			return new ResponseEntity<>(_matches, HttpStatus.CREATED);
		}
		return new ResponseEntity<>(HttpStatus.NOT_FOUND);
	}*/
			
		

/*

@PutMapping("/update/preferences/{id}")
	public ResponseEntity<User> updateModo(@PathVariable("id") long id, @RequestBody User user) {
		Optional<User> userData = userRepository.findById(id);

		if (userData.isPresent()) {
			User _user = userData.get();
			_user.setFlex(user.getFlex());
			_user.setDuo(user.getDuo());
			_user.setClash(user.getClash());
			_user.setOtro(user.getOtro());
			_user.setforfun(user.getForFun());
			_user.setChamps(user.getChamps());
			_user.setOtps(user.getOtps());
			_user.setTryHard(user.getTryHard());
			_user.setBot(user.getBot());
			_user.setFill(user.getFill());
			_user.setJungle(user.getJungle());
			_user.setMid(user.getMid());
			_user.setSupp(user.getSupp());
			_user.setTop(user.getTop());
			return new ResponseEntity<>(userRepository.save(_user), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}
*/
	
		
	//Retorna Id de la taula (en teoria no s'ha d'utilitzar)
	@GetMapping("/getTableId/{user_id_1}/{user_id_2}")
	public Long getTableId(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") long user_id_2) {
		return matchesRepository.findIdByUsers(user_id_1, user_id_2);
	}

	@GetMapping("/getTable/{user_id_1}/{user_id_2}") //Funcio auxiliar per fer proves amb postman 
	public ResponseEntity<Matches> getTable(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") long user_id_2) {
		Optional<Matches> matchData = matchesRepository.findTableByUsers(user_id_1, user_id_2);
		if (matchData.isPresent()) {
			Matches _matches = matchData.get();
			return new ResponseEntity<>(matchesRepository.save(_matches), HttpStatus.OK);
		} else {
			return new ResponseEntity<>(HttpStatus.NOT_FOUND);
		}
	}	
	

	//Retorna taula matches del user id_1, id_2 --> No cal utilitzar-la 
	//@GetMapping("/getTable/{user_id_1}/{user_id_2}")
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
			_matches.setLiked_2(matches.getLiked_2());
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

	//No cal utilitzar-la
    @GetMapping("/{user_id_1}/{user_id_2}")
	public Boolean isMatch(@PathVariable("user_id_1") long user_id_1, @PathVariable("user_id_2") Long user_id_2) {
		return matchesRepository.findIsMatch(user_id_1, user_id_2);
	}

	//Matches del usuari user_id_1
    @GetMapping("/user/{user_id_1}")
	public List<Matches> getUserMatches(@PathVariable("user_id_1") long user_id_1) {
		
		return matchesRepository.findUserMatches(user_id_1);
	}


    
}


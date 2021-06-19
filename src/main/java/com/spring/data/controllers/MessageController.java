package com.spring.data.controllers;

import java.util.ArrayList;
import java.util.List;

import com.spring.data.repository.MessageRepository;

import com.spring.data.models.Message;

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
@RequestMapping("/message")
public class MessageController {

    @Autowired
	MessageRepository messageRepository;


    @GetMapping("/all/{id}")
	public ResponseEntity<List<Message>> getAllUsers(@PathVariable("id") long id) {
		try {
			List<Message> matches = new ArrayList<Message>();

			messageRepository.findMessages(id).forEach(matches::add);

			if (matches.isEmpty()) {
				return new ResponseEntity<>(HttpStatus.NO_CONTENT);
			}
			return new ResponseEntity<>(matches, HttpStatus.OK);
		} catch (Exception e) {
			return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}

    @PostMapping("/create/{conversa_id}}")
    public ResponseEntity<Message> createReport(@PathVariable("id") long conversa_id, @RequestBody Message message) { 
        try {
            Message _message = messageRepository.save(new Message(message.getconversaId(), message.getUseridemisor(), message.getUseridreceptor(), message.getmessage(), message.getTimestamp()));
            return new ResponseEntity<>(_message, HttpStatus.CREATED);
        } catch (Exception e) {
            return new ResponseEntity<>(null, HttpStatus.INTERNAL_SERVER_ERROR);
        }
    }
    
}

package com.rest.webservices.pollswebservice.polls;

import java.net.URI;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

@RestController
public class PollController {

	@Autowired
	private PollRepository pollRepository;
	
	@GetMapping("/polls")
	public ResponseEntity<Iterable<Poll>> getAllPolls() {
	        return new ResponseEntity<>(pollRepository.findAll(), HttpStatus.OK);
	}
	
	@PostMapping("/jpa/polls")
	public ResponseEntity<Object> createPolls(@Valid @RequestBody Poll poll) {
		Poll savedPoll = pollRepository.save(poll);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPoll.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}

}

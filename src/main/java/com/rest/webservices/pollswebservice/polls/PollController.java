package com.rest.webservices.pollswebservice.polls;

import java.net.URI;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
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
	
	@PostMapping("/create/polls")
	public ResponseEntity<Object> createPolls(Poll poll) {
		Poll savedPoll = pollRepository.save(poll);

		URI location = ServletUriComponentsBuilder.fromCurrentRequest().path("/{id}").buildAndExpand(savedPoll.getId())
				.toUri();

		return ResponseEntity.created(location).build();

	}
	
	@PutMapping("/update/polls")
	public ResponseEntity<?> updatePoll(@RequestBody Poll poll, @PathVariable Long pollId) {
	       
	        pollRepository.save(poll);
	        return new ResponseEntity<>(HttpStatus.OK);
	}

}

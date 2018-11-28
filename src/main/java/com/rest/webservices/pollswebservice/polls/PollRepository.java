package com.rest.webservices.pollswebservice.polls;

import org.springframework.data.repository.PagingAndSortingRepository;


public interface PollRepository extends PagingAndSortingRepository<Poll, Integer> {

}

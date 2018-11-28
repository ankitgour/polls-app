package com.rest.webservices.pollswebservice.polls;

import org.springframework.data.repository.CrudRepository;


public interface OptionRepository extends CrudRepository<Choice, Integer>{

}

package com.rest.webservices.pollswebservice.polls.test;

import static org.assertj.core.api.Assertions.assertThat;
import static org.hamcrest.Matchers.containsString;
import static org.springframework.test.web.servlet.request.MockMvcRequestBuilders.get;
import static org.springframework.test.web.servlet.result.MockMvcResultHandlers.print;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.content;
import static org.springframework.test.web.servlet.result.MockMvcResultMatchers.status;

import java.util.HashSet;
import java.util.Set;

import org.junit.Test;
import org.junit.runner.RunWith;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.test.context.SpringBootTest;
import org.springframework.boot.test.web.client.TestRestTemplate;
import org.springframework.boot.web.server.LocalServerPort;
import org.springframework.test.context.junit4.SpringRunner;
import org.springframework.test.web.servlet.MockMvc;

import com.rest.webservices.pollswebservice.polls.Choice;
import com.rest.webservices.pollswebservice.polls.Poll;
import com.rest.webservices.pollswebservice.polls.PollController;

@RunWith(SpringRunner.class)
@SpringBootTest
public class PollsControllerTests {
	
	@LocalServerPort
    private int port;

	@Autowired
    private PollController pollController;
	
	 @Autowired
	private TestRestTemplate restTemplate;
	 
	 @Autowired
	    private MockMvc mockMvc;

    @Test
    public void contexLoads() throws Exception {
        assertThat(pollController).isNotNull();
    }
    
    @Test
    public void pollsReturnMessageFromService() throws Exception {
    	Poll poll = new Poll();
    	poll.setQuestion("Favourite programming language?");
    	poll.setId(102);
    	Set<Choice> choice = new HashSet<Choice>(101);
    	poll.setChoices(choice);
        this.mockMvc.perform(get("/polls")).andDo(print()).andExpect(status().isOk())
                .andExpect(content().string(containsString("Favourite")));
    }

}

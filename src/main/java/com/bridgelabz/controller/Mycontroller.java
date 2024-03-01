package com.bridgelabz.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.bridgelabz.model.Greetings;
import com.bridgelabz.myservices.Myservice;

@RestController
public class Mycontroller {

	@Autowired
	private Myservice services;
	
	@GetMapping("/Greetings")
	public List<Greetings> getGreetings(){
		return services.getGreetings(); 
	}
	@GetMapping("/Greetings/{greetingId}")
	public Greetings getGreeting(@PathVariable int greetingId) {
		return services.getGreeting(greetingId);
	}
	
	@PostMapping("/Greetings")
	public ResponseEntity<String> postGreetings(@RequestBody Greetings msg){
		try{
			this.services.addGreetings(msg);
			String responseBody = "Response from POST request : Has be Added successfully";
			return new ResponseEntity<>(responseBody,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	} 
	
	@PutMapping("/putGreetings")
	public ResponseEntity<String> updateGreetings(@RequestBody Greetings msg){
		try{
			this.services.putGreetings(msg);
			String responseBody = "Response from PUT request for MSG: Altered successfully";
			
			return new ResponseEntity<>(responseBody,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
	@DeleteMapping("/deleteGreetings/{greetingId}")
	public ResponseEntity<String> deleteGreetings(@PathVariable int greetingId){
		try{
			this.services.deleteGreetings(greetingId);
			String responseBody = "Response from Delete request for ID: " + greetingId + " Has been removed successfully";
			return new ResponseEntity<>(responseBody,HttpStatus.OK);
		}catch(Exception e) {
			return new ResponseEntity<>(HttpStatus.INTERNAL_SERVER_ERROR);
		}
	}
}

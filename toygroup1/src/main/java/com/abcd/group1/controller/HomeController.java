package com.abcd.group1.controller;

import java.net.URI;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpHeaders;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.util.UriComponentsBuilder;

import com.abcd.group1.model.UserDetails;
import com.abcd.group1.service.UserDetailsService;


@Controller
public class HomeController {

	@Autowired
	private UserDetailsService userDetailsService;
	

	
	
	@RequestMapping("/")
	public String displayHomePage(){
		return "index";
	}
	
	
	@RequestMapping(value="/candidate", method=RequestMethod.GET)
	public ResponseEntity <List<UserDetails>> displayUsers(){
		List <UserDetails> users = userDetailsService.getUsers();
		System.out.println(users);
		if(users.isEmpty())
			return new ResponseEntity <List<UserDetails>>(HttpStatus.NO_CONTENT);
		return new ResponseEntity <List<UserDetails>>(users,HttpStatus.ACCEPTED);		
	}
	
	@RequestMapping(value="/candidate/{uid}", method=RequestMethod.GET)
	public ResponseEntity <UserDetails> displayUsersById(@PathVariable("uid")String uid){
		 UserDetails users = userDetailsService.getUserById(uid);
		System.out.println(users);
		if(users==null)
			return new ResponseEntity<UserDetails>(HttpStatus.NO_CONTENT);
		return new ResponseEntity <UserDetails>(users,HttpStatus.OK);		
	}
	
	@RequestMapping(value="/candidate", method=RequestMethod.POST)
	public ResponseEntity<Void> addUser(@RequestBody UserDetails users,UriComponentsBuilder build){
		userDetailsService.addUser(users);
		HttpHeaders headers = new HttpHeaders();
		
		URI urilocation = 
				build.path("/candidate/")
				.path(String.valueOf(users.getUserid()))
				.build()
				.toUri();
		headers.setLocation(urilocation);
		return new ResponseEntity<Void>(headers,HttpStatus.CREATED);	
		
	}
	
	
	// http://localhost:1010/toygroup/get/USR00001,  PUT -> DispatcherServlet ->
	// handler -> find a method in controller which can handle the request
	@RequestMapping(value="/candidate/{uid}", method=RequestMethod.PUT)
	public ResponseEntity <UserDetails> updateUser1(@PathVariable("uid")String uid,@RequestBody UserDetails ud){
		UserDetails res = userDetailsService.updateUser(uid,ud);
		if(res==null){
			System.out.println("\nUpdate : No record");
			return new ResponseEntity<UserDetails>(HttpStatus.NOT_FOUND);
		}
		else{
		
			return new ResponseEntity<UserDetails>(res,HttpStatus.OK);
		}
		
		
	}
	
	@RequestMapping(value="/candidate/{uid}", method=RequestMethod.DELETE)
	public ResponseEntity <Void> deleteUser(@PathVariable("uid")String uid){
		UserDetails temp = userDetailsService.getUserById(uid);
		if(temp==null)
			return new ResponseEntity<Void>(HttpStatus.NOT_FOUND);
		else
			userDetailsService.deleteUser(uid);
		return new ResponseEntity<Void>(HttpStatus.OK);
	}
	
}

/**
 * 
 */
package com.d9hub.myslot.controllers;

import java.util.List;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;

import com.d9hub.myslot.models.User;
import com.d9hub.myslot.repositories.UserRepository;

/**
 * @author lruhunage
 *
 */

@RestController
@RequestMapping("/api/v1/users")
public class UserController {
	
	@Autowired
	private UserRepository userRepository;
	
	@GetMapping
	public List<User> getAllUsers() {
	   return userRepository.findAll();
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.GET)
	public ResponseEntity<User> get(@PathVariable Long id) throws Exception {
		User user = userRepository.findById(id)
	            .orElseThrow(() -> new Exception("User " + id + " not found"));
		
		return ResponseEntity.ok().body(user);
	}
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public User create(@RequestBody User user) {
		return userRepository.saveAndFlush(user);
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.DELETE)
	public void delete(@PathVariable Long id) {
		userRepository.deleteById(id);
	}
	
	@RequestMapping(value ="{id}", method= RequestMethod.PUT)
	public User update(@PathVariable Long id,@RequestBody User user) throws Exception {
		//PUT will expect full object to update. PATCH will need delta
		User existingUser = userRepository.findById(id).orElseThrow(() -> new Exception("User " + id + " not found"));
		BeanUtils.copyProperties(user, existingUser, "user_id");
		return userRepository.saveAndFlush(existingUser);
	}

}

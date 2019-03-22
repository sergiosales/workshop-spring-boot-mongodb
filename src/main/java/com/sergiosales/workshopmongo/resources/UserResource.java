package com.sergiosales.workshopmongo.resources;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;

import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RestController;

import com.sergiosales.workshopmongo.domain.User;


@RestController
@RequestMapping(value= "/user")
public class UserResource {

@RequestMapping(method= RequestMethod.GET)
public List<User> findAll(){
	User Maria = new User("1", "Maria Eduarda","mariaeduarda@gmail.com");
	User Alex = new User("2", "Alex Fernando","alex@gmail.com");
	List<User> list = new ArrayList<User>();
	list.addAll(Arrays.asList(Maria,Alex));
	return list;
	
}
	
}

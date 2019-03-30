package com.sergiosales.workshopmongo.services;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergiosales.workshopmongo.domain.User;
import com.sergiosales.workshopmongo.dto.UserDTO;
import com.sergiosales.workshopmongo.repository.UserRepository;
import com.sergiosales.workshopmongo.services.exception.ObjectNotFoundException;


@Service
public class UserService {
	
	@Autowired
	private UserRepository rep;
	
	public List<User> findAll(){
		return rep.findAll();
		
	}
	
	public User findById(String id) {
		Optional<User> obj = rep.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	
	public User insert(User obj) {
		return rep.insert(obj);
		
	}
	
	public void delete(String id) {
		findById(id);		
	 rep.deleteById(id);
	}
	
	
	public User update(User obj) {
		User novoObjeto= findById(obj.getId());
		updateData(novoObjeto,obj);
		return rep.save(novoObjeto);
		
	}
	
	private void updateData(User novoObjeto, User obj) {
		novoObjeto.setName(obj.getName());
		novoObjeto.setEmail(obj.getEmail());
		
	}

	public User fromDTO(UserDTO objDTO) {
	
		return  new User(objDTO.getId(), objDTO.getName(), objDTO.getEmail());
		
		
	}
	
	
}

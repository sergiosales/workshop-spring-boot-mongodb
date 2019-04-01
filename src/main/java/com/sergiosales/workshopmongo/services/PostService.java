package com.sergiosales.workshopmongo.services;

import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.sergiosales.workshopmongo.domain.Post;
import com.sergiosales.workshopmongo.repository.PostRepository;
import com.sergiosales.workshopmongo.services.exception.ObjectNotFoundException;


@Service
public class PostService {
	
	@Autowired
	private PostRepository post;
	
	
	public Post findById(String id) {
		Optional<Post> obj = post.findById(id);
		return obj.orElseThrow(() -> new ObjectNotFoundException("Objeto não encontrado"));
		}
	
	

	
	
}

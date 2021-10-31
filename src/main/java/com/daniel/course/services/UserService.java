package com.daniel.course.services;

import java.util.List;
import java.util.Optional;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;

import com.daniel.course.entities.User;
import com.daniel.course.repositories.UserRepository;
import com.daniel.course.services.exceptions.DatabaseException;
import com.daniel.course.services.exceptions.ResourceNotFoundException;

@Service
public class UserService {
	
	@Autowired
	private UserRepository repository;
	
	public List<User> findAll(){
		return repository.findAll();
	}
	
	//gera exceção se o objeto não existir
	public User findById(Long id) {
		Optional<User> obj = repository.findById(id);
		return obj.orElseThrow(() -> new ResourceNotFoundException(id)); //lambda
	}
	
	public User insert(User obj) {
		return repository.save(obj);
	}
	
	//tratar exceções
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		}
		catch (EmptyResultDataAccessException e) {//excluir user que não existe
			throw new ResourceNotFoundException(id);
		}
		catch (DataIntegrityViolationException e) {//excluir user que tem pedido
			throw new DatabaseException(e.getMessage());
		}
	}
	
	//tratar exceção (verificar que tipo exceção está sendo lançada criando uma exceção abstrata (RuntimeException)
	public User update(Long id, User obj) {
		try {
			User entity = repository.getOne(id);
			updateData(entity, obj);
			return repository.save(entity);
		}
		catch (EntityNotFoundException e) {
			throw new ResourceNotFoundException(id);
		}
	}

	private void updateData(User entity, User obj) {
		entity.setName(obj.getName());
		entity.setEmail(obj.getEmail());
		entity.setPhone(obj.getPhone());
		
	}
	
	

}

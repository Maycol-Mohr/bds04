package com.devsuperior.bds04.services;

import javax.persistence.EntityNotFoundException;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.dao.DataIntegrityViolationException;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import com.devsuperior.bds04.dto.EventDTO;
import com.devsuperior.bds04.entities.City;
import com.devsuperior.bds04.entities.Event;
import com.devsuperior.bds04.repositories.EventRepository;
import com.devsuperior.bds04.services.exceptions.ControllerNotFoundException;
import com.devsuperior.bds04.services.exceptions.DatabaseException;

@Service
public class EventService {

	@Autowired
	private EventRepository repository;

	@Transactional
	public EventDTO update(Long id, EventDTO dto) {
		try {
			Event entity = repository.getOne(id);
			entity.setName(dto.getName());
			entity.setDate(dto.getDate());
			entity.setUrl(dto.getUrl());
			entity.setCity(new City(dto.getCityId(), null));
			entity = repository.save(entity);
			return new EventDTO(entity);
		} catch (EntityNotFoundException e) {
			throw new ControllerNotFoundException("Id not found " + id);
		}
	}
	
	public void delete(Long id) {
		try {
			repository.deleteById(id);
		} catch (EmptyResultDataAccessException e) {
			throw new ControllerNotFoundException("Id not found " + id);
		} catch (DataIntegrityViolationException e) {
			throw new DatabaseException("Integrity violation");
		}
	}
}
package com.qualstack.resource;

import java.util.List;
import java.util.Objects;
import java.util.Optional;

import javax.servlet.http.HttpServletResponse;
import javax.validation.Valid;

import org.springframework.beans.BeanUtils;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.context.ApplicationEventPublisher;
import org.springframework.dao.EmptyResultDataAccessException;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.ResponseStatus;

import com.qualstack.model.BaseEntity;

public class BaseResource<R extends JpaRepository<E, Long>, E extends BaseEntity> {

	@Autowired
	protected ApplicationEventPublisher publisher;
	
	@Autowired
	private R repository;
	
	@GetMapping
	public List<E> listar(){
		List<E> lista = repository.findAll();
		return lista;
	}
	
	@PostMapping
	public ResponseEntity<E> criar(@Valid @RequestBody E entity, HttpServletResponse response) {
		E entitySalvo = repository.save(entity);
		return ResponseEntity.status(HttpStatus.CREATED).body(entitySalvo);
	}
	
	@GetMapping("/{id}")
	public E buscarPeloId(@PathVariable Long id) {
		Optional<E> optional = repository.findById(id);
		return !optional.isEmpty() ? optional.get() : null;
	}
	
	@DeleteMapping("/{codigo}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void remover(@PathVariable Long codigo) {
		repository.deleteById(codigo);
	}
	
	@PutMapping("/{codigo}")
	public ResponseEntity<E> atualizar(@PathVariable Long codigo, @Valid @RequestBody E entity){
		 Optional<E> optional = repository.findById(codigo);
		 E entidadeSalva = optional.get();
		 if(Objects.isNull(entidadeSalva)) {
			throw new EmptyResultDataAccessException(1);
		}
		BeanUtils.copyProperties(entity, entidadeSalva, "id");
		repository.save(entidadeSalva);
		return ResponseEntity.ok(entidadeSalva);
	}
	
}

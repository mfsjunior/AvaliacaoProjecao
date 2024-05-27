package com.exercicio.atividade.http.controller;

import java.util.List;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseStatus;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.server.ResponseStatusException;

import com.exercicio.atividade.entity.Cliente;
import com.exercicio.atividade.service.ClienteService;

import jakarta.websocket.server.PathParam;

@RestController
@RequestMapping("/cliente")
public class ClienteController {
	
	
	
	@Autowired
	private ClienteService clienteService;
	
	
	@Autowired
	private ModelMapper modelMapper;
	
	@PostMapping
	@ResponseStatus(HttpStatus.CREATED)
	public Cliente salvar(@RequestBody Cliente cliente) {
		
		return clienteService.salvar(cliente);
	}
	
	@GetMapping
	@ResponseStatus(HttpStatus.OK)
	public List<Cliente> listaCliente(){
		return clienteService.listaClientes();
	}
	
	
	@GetMapping("/{id}")
	@ResponseStatus(HttpStatus.OK)
	public Cliente buscarClientePorId(@PathVariable("id") Long id){
		return clienteService.buscarPorId(id)
				.orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
	}
	
	@DeleteMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void removeCliente(Long id) {
		clienteService.buscarPorId(id)
			.map(cliente -> {
				clienteService.removerPorId(cliente.getId());
				return Void.TYPE;
			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
	}
	
	
	@PutMapping("/{id}")
	@ResponseStatus(HttpStatus.NO_CONTENT)
	public void atualizaCliente(@PathVariable("id") Long id, @RequestBody Cliente cliente) {
		clienteService.buscarPorId(id)
			.map(clienteBase -> {
				modelMapper.map(cliente, clienteBase);
				return Void.TYPE;
			}).orElseThrow(() -> new ResponseStatusException(HttpStatus.NOT_FOUND, "Cliente não encontrado."));
		
		
	}

}

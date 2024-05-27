package com.exercicio.atividade.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.exercicio.atividade.entity.Cliente;
import com.exercicio.atividade.repository.ClienteRepository;

@Service
public class ClienteService {
	
	@Autowired
	private ClienteRepository clienteRepository;
	
	public Cliente salvar(Cliente cliente) {
		
		return clienteRepository.save(cliente);
		
	}
	
	public List<Cliente> listaClientes(){
		return clienteRepository.findAll();
	}
	
	public Optional<Cliente> buscarPorId(Long id){
		
		return clienteRepository.findById(id);
	}
	
	public void removerPorId(Long id) {
		clienteRepository.deleteById(id);
	}

}

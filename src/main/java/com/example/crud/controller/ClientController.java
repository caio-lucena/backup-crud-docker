package com.example.crud.controller;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.example.crud.model.Client;
import com.example.crud.service.ClientService;

@RestController
@RequestMapping("/api/clients")
public class ClientController {
	
	@Autowired
	private ClientService clientService;	
	
	
	@GetMapping
	public List<Client> getAllClients (){
		return clientService.getAllClients();
	}
	
	
	@GetMapping("/{clientId}")
	public Optional<Client> getClientById (@PathVariable Integer clientId){		
		return clientService.getClientById(clientId);
	}
	
	@PostMapping	
	public String addClient (@RequestBody Client client) {
		String message = "";
		
		if (client != null) {
			clientService.addClient(client);
			message = "Cliente cadastrado com sucesso\n{" + client + "}"; 
		}
		else {
			message = "Não foi possível cadastrar o cliente. O parâmetro 'client' não pode ser nulo";
		}
		
		return message;
	}
	
	
	@DeleteMapping("/{clientId}")
	public String  deleteClient (@PathVariable  Integer clientId) {
		String message = "";
		
		if(clientId != null) {
			clientService.deleteClient (clientId);
			message = "Cliente com ID " + clientId + " deletado com sucesso";
		}
		else {
			message = "clientId inválido";
		}
		
		return message;
	}
	
	@PutMapping("/{clientId}")
	public Client updateClient (@RequestBody Client client, @PathVariable Integer clientId) {
		return clientService.updateClient(client, clientId);
	}
}

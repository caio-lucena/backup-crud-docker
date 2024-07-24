package com.example.crud.service;

import java.util.List;
import java.util.Optional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.example.crud.model.Client;
import com.example.crud.repository.ClientRepository;

@Service
public class ClientService {
	
	@Autowired
	ClientRepository clientRepository;
	
	public List<Client> getAllClients (){
		return clientRepository.findAll();
	}
	
	public Optional<Client> getClientById (Integer clientId){		
		return clientRepository.findById(clientId);
	}
	
	public void addClient (Client client) {
		
		if (client != null) {
			clientRepository.save(client);
		}
	}
	
	public void deleteClient(Integer clientId) {
		
		if(clientId != null) {
			clientRepository.deleteById(clientId);
		}	
	}
	
	public Client updateClient(Client client, Integer clientId) {
		
		//TODO lembrar de alterar a base pra receber só nome e profissão no json
		
		clientRepository.save(client);

		return client ;
	}
}

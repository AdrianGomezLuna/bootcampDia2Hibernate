package com.ntt.bootcamp.hibernate.services.impl;

import java.util.List;

import javax.transaction.Transactional;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.ntt.bootcamp.hibernate.bbdd.Client;
import com.ntt.bootcamp.hibernate.bbdd.dao.ClientDao;
import com.ntt.bootcamp.hibernate.services.ClientService;

@Service
public class ClientServiceImpl implements ClientService {
	
	@Autowired
	private ClientDao clientDao;

	@Override
	@Transactional
	public void insertNewClient(Client client) {
		if (client != null) {
			System.out.println("Cliente insertado con exito");
			clientDao.insert(client);
		}		
	}

	@Override
	@Transactional
	public Client searchId(Long id) {
		Client client = null;
		if (id != null) {
			client = clientDao.searchId(id);
		} else {
			System.out.println("No se ha encontrado ningún cliente con ese id");
		}
		return client;
	}

	@Override
	@Transactional
	public void updateClient(Client client) {
		if (client != null) {
			clientDao.update(client);
			System.out.println("Cliente actualizado");
		}		
	}

	@Override
	@Transactional
	public void deleteClient(Client client) {
		if (client != null) {
			clientDao.delete(client);
			System.out.println("Cliente eliminado");
		}
		
	}

	@Override
	@Transactional
	public Client searchName(Client client) {
		Client clientSearch = null;
		if (client != null) {
			clientSearch = clientDao.searchName(client);
		} else {
			System.out.println("No se ha encontrado ningún cliente con ese nombre y apellidos");
		}
		return client;
	}

	@Override
	@Transactional
	public List<Client> searchAll() {		
		return clientDao.showAll();
	}

}

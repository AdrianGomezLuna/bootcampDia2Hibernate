package com.ntt.bootcamp.hibernate.services.impl;

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
		}
		return client;
	}

}

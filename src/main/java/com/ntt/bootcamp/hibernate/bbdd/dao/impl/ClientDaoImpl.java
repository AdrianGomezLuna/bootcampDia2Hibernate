package com.ntt.bootcamp.hibernate.bbdd.dao.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ntt.bootcamp.hibernate.bbdd.Client;
import com.ntt.bootcamp.hibernate.bbdd.dao.ClientDao;

@Repository
public class ClientDaoImpl implements ClientDao{

	/**
	 * Manejador de entidades
	 */
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insert(Client client) {
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		//Insertamos en bbdd
		currentSession.save(client);
		//Cerramos la sesión
		currentSession.close();	
	}

	@Override
	public void showAll() {
		// TODO Auto-generated method stub
		
	}

	@Override
	@Transactional
	public Client searchId(Long id) {
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		//Insertamos en bbdd
		Client client = currentSession.find(Client.class, id);
		//Cerramos la sesión
		currentSession.close();	
		//devolvemos el jugador
		return client;
	}

	@Override
	public void delete(Client client) {
		// TODO Auto-generated method stub
		
	}

	@Override
	public Client update(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

	@Override
	public Client searchName(Client client) {
		// TODO Auto-generated method stub
		return null;
	}

}

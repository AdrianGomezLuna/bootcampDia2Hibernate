package com.ntt.bootcamp.hibernate.bbdd.dao.impl;

import java.util.List;

import javax.management.Query;
import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ntt.bootcamp.hibernate.bbdd.Client;
import com.ntt.bootcamp.hibernate.bbdd.dao.ClientDao;

@Repository
public class ClientDaoImpl implements ClientDao {

	/**
	 * Manejador de entidades
	 */
	@Autowired
	private EntityManager entityManager;

	@Override
	@Transactional
	public void insert(Client client) {
		// Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		// Insertamos en bbdd
		currentSession.save(client);
		// Cerramos la sesión
		currentSession.close();
	}



	@Override
	@Transactional
	public Client searchId(Long id) {
		// Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		// Buscamos en bbdd
		Client client = currentSession.find(Client.class, id);
		// Cerramos la sesión
		currentSession.close();
		// devolvemos el jugador
		return client;
	}

	@Override
	@Transactional
	public void delete(Client client) {
		// Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		// Borramos en bbdd
		currentSession.remove(currentSession.contains(client)? client : currentSession.merge(client));
		// Cerramos la sesión
		currentSession.close();
	}

	@Override
	@Transactional
	public void update(Client client) {
		// Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		//Le agregamos la nueva actualización
		currentSession.saveOrUpdate(client);
		currentSession.close();
	}

	@Override
	@Transactional
	public Client searchName(Client client) {
		Client clientSearch = null;
		// Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		String q = "SELECT * FROM `client` WHERE name='"+ client.getName() + 
				"' and last_name1='" + client.getLastName1() +
				"' and last_name2='" + client.getLastName2() + "'";
		clientSearch = (Client) currentSession.createNativeQuery(q);
		
		return clientSearch;
	}



	@Override
	@Transactional
	public List<Client> showAll() {
		// Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		return currentSession.createQuery("select m from Client m", Client.class).getResultList();
	}

}

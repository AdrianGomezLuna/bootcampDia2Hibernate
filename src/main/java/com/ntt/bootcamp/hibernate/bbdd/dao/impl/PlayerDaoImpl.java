package com.ntt.bootcamp.hibernate.bbdd.dao.impl;

import javax.persistence.EntityManager;
import javax.transaction.Transactional;

import org.hibernate.Session;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import com.ntt.bootcamp.hibernate.bbdd.Player;
import com.ntt.bootcamp.hibernate.bbdd.dao.PlayerDao;

@Repository
public class PlayerDaoImpl implements PlayerDao {

	/**
	 * Manejador de entidades
	 */
	@Autowired
	private EntityManager entityManager;
	
	@Override
	@Transactional
	public void insert(Player player) {
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		//Insertamos en bbdd
		currentSession.save(player);
		//Cerramos la sesión
		currentSession.close();	
	}

	@Override
	@Transactional
	public Player searchId(Long id) {
		//Obtenemos la sesión
		Session currentSession = entityManager.unwrap(Session.class);
		//Insertamos en bbdd
		Player player = currentSession.find(Player.class, id);
		//Cerramos la sesión
		currentSession.close();	
		//devolvemos el jugador
		return player;
	}

}

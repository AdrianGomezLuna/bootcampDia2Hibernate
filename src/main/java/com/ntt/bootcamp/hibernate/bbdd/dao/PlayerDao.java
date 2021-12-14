package com.ntt.bootcamp.hibernate.bbdd.dao;

import com.ntt.bootcamp.hibernate.bbdd.Player;

public interface PlayerDao {

	/**
	 * Método que inserta un nuevo jugador
	 * @param player Nuevo Jugador a guardar
	 */
	public void insert(Player player);
	
	/**
	 * Método que devuelve un jugador buscado por id
	 * @param id id del jugador a buscar
	 * @return player que es el jugador buscado por id
	 */
	public Player searchId(Long id);
}

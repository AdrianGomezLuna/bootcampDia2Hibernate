package com.ntt.bootcamp.hibernate.services;

import com.ntt.bootcamp.hibernate.bbdd.Player;

public interface PlayerService {
	
	/**
	 * Método que inserta un nuevo jugador
	 * @param playernuego jugador a guardar
	 */
	public void insertNewPlayer(Player player);

	/**
	 * Método que busca un jugador por id
	 * @param id del jugador
	 * @return Jugador encontrado
	 */
	public Player searchPlayerByID(Long id);
}

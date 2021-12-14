package com.ntt.bootcamp.hibernate.services;

import com.ntt.bootcamp.hibernate.bbdd.Client;

public interface ClientService {
	
	/**
	 * Método insertar un nuevo cliente
	 * @param client que va a ser insertado
	 */
	public void insertNewClient(Client client);
	
	/**
	 * Método que busca por id el cliente
	 * @param id del cliente a buscar
	 * @return Client cliente encontrado
	 */
	public Client searchId(Long id);

}

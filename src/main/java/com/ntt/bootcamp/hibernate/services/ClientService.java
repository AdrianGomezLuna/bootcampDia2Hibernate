package com.ntt.bootcamp.hibernate.services;

import java.util.List;

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
	
	/**
	 * Método que actualiza un cliente
	 * @param client cliente nuevo para actualizar
	 */
	public void updateClient(Client client);
	
	/**
	 * Método que elimina un cliente
	 * @param client que va a ser eliminado
	 */
	public void deleteClient(Client client);
	
	/**
	 * Método que busca por nombre y apellidos
	 * @param client  client a buscar
	 * @return Client cliente encontrado 
	 */
	public Client searchName(Client client);

	/**
	 * Muestra todos los resultados que tenemos en Client
	 * @return lista de clientes
	 */
	public List<Client> searchAll();

}

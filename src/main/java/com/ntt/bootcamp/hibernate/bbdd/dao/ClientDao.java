package com.ntt.bootcamp.hibernate.bbdd.dao;

import java.util.List;

import com.ntt.bootcamp.hibernate.bbdd.Client;

public interface ClientDao {

	/**
	 * Método para insertar un nuevo cliente
	 * @param client cliente que va a ser insertado
	 */
	public void insert(Client client);
	
	/**
	 * Método que mostrará todos los clientes que tenemos
	 */
	public List<Client> showAll();
	
	/**
	 * Método que buscará por ID del cliente
	 * @param id ID del cliente que buscará
	 * @return Client cliente que se encontró
	 */
	public Client searchId(Long id);
	
	/**
	 * Método que elimina un cliente
	 * @param client cliente que va a ser borrado
	 */
	public void delete(Client client);
	
	/**
	 * Método para actualizar a algún cliente
	 * @param client que va a ser actualizado
	 */
	public void update(Client client);
	
	/**
	 * Método que busca por nombre, apellido1 y apellido2
	 * @param client Cliente
	 * @return Client cliente que ha sido encontrado
	 */
	public Client searchName(Client client);
}

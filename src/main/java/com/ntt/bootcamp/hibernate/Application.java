package com.ntt.bootcamp.hibernate;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.CommandLineRunner;
import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;

import com.ntt.bootcamp.hibernate.bbdd.Client;
import com.ntt.bootcamp.hibernate.bbdd.Player;
import com.ntt.bootcamp.hibernate.services.ClientService;
import com.ntt.bootcamp.hibernate.services.PlayerService;

@SpringBootApplication
public class Application implements CommandLineRunner {

	@Autowired
	private PlayerService playerService;

	@Autowired
	private ClientService clientService;

	public static void main(String[] args) {
		SpringApplication.run(Application.class, args);
	}

	@Override
	public void run(String... args) throws Exception {
		System.out.println("Iniciando la conexión");

		// Creamos un nuevo jugador
		Player player1 = new Player();
		player1.setName("Cristiano");
		player1.setLastName("Ronaldo");
		player1.setNumber(7);
		player1.setTeam("United");
		// Lo insertamos en la base de datos
		playerService.insertNewPlayer(player1);

		// Creamos un nuevo jugador
		Player player3 = new Player();
		player3.setName("Lionel");
		player3.setLastName("Messi");
		player3.setNumber(30);
		player3.setTeam("PSG");
		// Lo insertamos en la base de datos
		playerService.insertNewPlayer(player3);

		// Creamos un nuevo jugador
		Player player2 = new Player();
		player2.setName("Gerard");
		player2.setLastName("Moreno");
		player2.setNumber(9);
		player2.setTeam("Villareal");
		// Lo insertamos en la base de datos
		playerService.insertNewPlayer(player2);

		// Buscamos
		Player searchPlayer = playerService.searchPlayerByID(1L);
		if (searchPlayer != null) {
			System.out.println("JUgador encontrado " + searchPlayer.getId());
		} else {
			System.out.println("No encontrado");
		}

		// Insertamos unos clientes
		Client client1 = new Client();
		client1.setName("Adrian");
		client1.setLastName1("Gomez");
		client1.setLastName2("Luna");
		client1.setDni("111111111");
		// Lo insertamos en la BBDD
		clientService.insertNewClient(client1);
		// Insertamos unos clientes
		Client client2 = new Client();
		client2.setName("Marta");
		client2.setLastName1("Blandon");
		client2.setLastName2("Garcia");
		client2.setDni("111111112");
		// Lo insertamos en la BBDD
		clientService.insertNewClient(client2);
		// Insertamos unos clientes
		Client client3 = new Client();
		client3.setName("Laura");
		client3.setLastName1("Rodriguez");
		client3.setLastName2("Diaz");
		client3.setDni("111111113");
		// Lo insertamos en la BBDD
		clientService.insertNewClient(client3);
		// Insertamos unos clientes --> Da error con el DNI
		/*
		 * Client client4 = new Client(); client4.setName("Laura");
		 * client4.setLastName1("Rodriguez"); client4.setLastName2("Diaz");
		 * client4.setDni("1111111134"); // más de 9 carácteres // Lo insertamos en la
		 * BBDD clientService.insertNewClient(client4);
		 */

		// Buscamos cliente
		Client searchClient = clientService.searchId(4L);
		if (searchClient != null) {
			System.out.println("Cliente encontrado " + searchClient.toString());
		} else {
			System.out.println("No encontrado");
		}

		// Actualización de un Cliente
		System.out.println(client3.toString());
		client3.setName("Lauro");
		clientService.updateClient(client3);
		System.out.println(client3.toString());

		// Eliminar un cliente (Quitar comentarios para ejecutarlo)
		//searchClient = clientService.searchId(6L);	
		//clientService.deleteClient(searchClient);		
		
		//Buscar por nombre y apellidos
		/*System.out.println("BUSQUEDA POR NOMBRE Y APELLIDOS: ");		
		searchClient.setName("Adrian");
		searchClient.setLastName1("a");
		searchClient.setLastName2("a");
		searchClient.setDni("123");
		searchClient = clientService.searchName(searchClient);
		if (searchClient != null) {
			System.out.println("Cliente encontrado por nombre --> " + searchClient.toString());
		} else {
			System.out.println("No encontrado");
		}*/
	}

}

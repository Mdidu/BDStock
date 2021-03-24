package persistance.dao;

import java.util.List;

import persistance.entities.Client;

public interface ClientDao {

	void add(Client client);
	void delete(Client client);
	void update(Client client);
	Client findById(int id); 
	List<Client> findAll();
}

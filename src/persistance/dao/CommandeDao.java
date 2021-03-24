package persistance.dao;

import java.util.List;

import persistance.entities.Commande;
import persistance.entities.CommandeId;

public interface CommandeDao {

	void add(Commande commande);
	void delete(Commande commande);
	void update(Commande commande);
	Commande findById(CommandeId commandeId); 
	List<Commande> findAll();
}

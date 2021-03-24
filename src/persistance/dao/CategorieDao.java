package persistance.dao;

import java.util.List;

import persistance.entities.Categorie;

public interface CategorieDao {

	void add(Categorie categorie);
	void delete(Categorie categorie);
	void update(Categorie categorie);
	Categorie findById(int id); 
	List<Categorie> findAll();
}

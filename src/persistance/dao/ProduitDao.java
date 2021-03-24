package persistance.dao;

import java.util.List;

import persistance.entities.Produit;

public interface ProduitDao {

	void add(Produit produit);
	void delete(Produit produit);
	void update(Produit produit);
	Produit findById(int id); 
	List<Produit> findAll();
}

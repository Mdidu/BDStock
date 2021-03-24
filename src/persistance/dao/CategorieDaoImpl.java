package persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.entities.Categorie;

public class CategorieDaoImpl implements CategorieDao {

	@Override
	public void add(Categorie categorie) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Transaction tx = session.beginTransaction();
			session.save(categorie);
			tx.commit();
		}
	}

	@Override
	public void delete(Categorie categorie) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Transaction tx = session.beginTransaction();
			session.delete(categorie);
			tx.commit();
		}
	}

	@Override
	public void update(Categorie categorie) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Transaction tx = session.beginTransaction();
			session.update(categorie);
			tx.commit();
		}
	}

	@Override
	public Categorie findById(int id) {
		Categorie categorie = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			categorie = session.get(Categorie.class, id);
		}
		return categorie;
	}

	@Override
	public List<Categorie> findAll() {
		List<Categorie> listCategories = new ArrayList<Categorie>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			listCategories = session.createQuery("from Categorie").list();
		}
		return listCategories;
	}

}

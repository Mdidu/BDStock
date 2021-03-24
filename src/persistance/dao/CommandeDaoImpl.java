package persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.entities.Commande;
import persistance.entities.CommandeId;

public class CommandeDaoImpl implements CommandeDao {

	@Override
	public void add(Commande commande) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Transaction tx = session.beginTransaction();
			session.save(commande);
			tx.commit();
		}
	}

	@Override
	public void delete(Commande commande) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Transaction tx = session.beginTransaction();
			session.delete(commande);
			tx.commit();
		}
	}

	@Override
	public void update(Commande commande) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			Transaction tx = session.beginTransaction();
			session.update(commande);
			tx.commit();
		}
	}

	@Override
	public Commande findById(CommandeId commandeId) {
		Commande commande = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			commande = session.get(Commande.class, commandeId);
		}
		return commande;
	}

	@Override
	public List<Commande> findAll() {
		List<Commande> listCommandes = new ArrayList<Commande>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {
			
			listCommandes = session.createQuery("from Commande").list();
		}
		return listCommandes;
	}

}

package persistance.dao;

import java.util.ArrayList;
import java.util.List;

import org.hibernate.Session;
import org.hibernate.Transaction;

import persistance.entities.Client;

public class ClientDaoImpl implements ClientDao {

	@Override
	public void add(Client client) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			session.save(client);
			tx.commit();
		}
	}

	@Override
	public void delete(Client client) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			session.delete(client);
			tx.commit();
		}

	}

	@Override
	public void update(Client client) {
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			Transaction tx = session.beginTransaction();
			session.update(client);
			tx.commit();
		}
	}

	@Override
	public Client findById(int id) {
		Client client = null;
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			client = session.get(Client.class, id);
		}
		return client;
	}

	@Override
	public List<Client> findAll() {
		List<Client> listClients = new ArrayList<Client>();
		try (Session session = HibernateUtil.getSessionFactory().openSession()) {

			listClients = session.createQuery("from Client").list();
		}
		return listClients;
	}

}

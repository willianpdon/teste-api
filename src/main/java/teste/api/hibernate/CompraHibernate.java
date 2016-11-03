package teste.api.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teste.api.domain.Compra;
import teste.api.repository.CompraRepository;

@Repository
public class CompraHibernate extends Hibernate<Compra, Long> implements CompraRepository {
	
	@Autowired
	public CompraHibernate(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
}
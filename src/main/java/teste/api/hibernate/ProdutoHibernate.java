package teste.api.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teste.api.domain.Produto;
import teste.api.repository.ProdutoRepository;

@Repository
public class ProdutoHibernate extends Hibernate<Produto, Long> implements ProdutoRepository {
	
	@Autowired
	public ProdutoHibernate(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
}
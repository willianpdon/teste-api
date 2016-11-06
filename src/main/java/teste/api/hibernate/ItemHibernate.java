package teste.api.hibernate;

import org.hibernate.SessionFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Repository;

import teste.api.domain.Item;
import teste.api.repository.ItemRepository;

@Repository
public class ItemHibernate extends Hibernate<Item, Long> implements ItemRepository {
	
	@Autowired
	public ItemHibernate(SessionFactory sessionFactory) {
		super(sessionFactory);
	}
	
}
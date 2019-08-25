package th.priisoft.crm.spring.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BaseCRMRepository {
	@PersistenceContext(unitName="CRM_JPA")
	protected EntityManager entityManager;
}

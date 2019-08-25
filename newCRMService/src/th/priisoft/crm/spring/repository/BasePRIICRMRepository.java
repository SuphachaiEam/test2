package th.priisoft.crm.spring.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BasePRIICRMRepository {
	@PersistenceContext(unitName="PRII_CRM_JPA")
	protected EntityManager entityManager;
}

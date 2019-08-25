package th.priisoft.crm.spring.repository;

import javax.persistence.EntityManager;
import javax.persistence.PersistenceContext;

public class BasePRIIPARepository {
	@PersistenceContext(unitName="PRII_PA_JPA")
	protected EntityManager entityManagerPA;
}

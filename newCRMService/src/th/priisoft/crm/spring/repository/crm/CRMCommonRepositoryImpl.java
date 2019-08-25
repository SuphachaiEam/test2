package th.priisoft.crm.spring.repository.crm;

import org.springframework.stereotype.Repository;

import th.priisoft.crm.spring.entity.crmdta.RolesEntity;
import th.priisoft.crm.spring.repository.BaseCRMRepository;

@Repository
public class CRMCommonRepositoryImpl extends BaseCRMRepository implements CRMCommonRepository {
	@Override
	public RolesEntity saveRoleEnttiy(RolesEntity entity) 	throws Exception {
		entityManager.persist(entity);
		return entity;
	}
}

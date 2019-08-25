package th.priisoft.crm.spring.repository.crm;

import th.priisoft.crm.spring.entity.crmdta.RolesEntity;

public interface CRMCommonRepository {
	public RolesEntity saveRoleEnttiy(RolesEntity entity) throws Exception;
}

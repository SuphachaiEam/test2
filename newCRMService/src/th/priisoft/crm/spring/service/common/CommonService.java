package th.priisoft.crm.spring.service.common;

import java.util.List;

import th.priisoft.crm.spring.entity.crmdta.RolesEntity;
import th.priisoft.crm.spring.entity.prii.crmdta.Bank;
import th.priisoft.crm.spring.entity.prii.padta.Client;

public interface CommonService {
	public RolesEntity saveRoleEnttiy() throws Exception;
	public Bank saveBankEnttiy() throws Exception;
	public Client saveClientEnttiy() throws Exception;
	public Client saveClientEnttiy(String name) throws Exception;
	public Client findClientEnttiy() throws Exception;
	public Client updateClientEnttiy() throws Exception;
	public void deleteClientEnttiy(Client entity) throws Exception;
	public List<Client> findByName(String searchName) throws Exception;
	public void updateByName(String oldName,String newName) throws Exception;
}

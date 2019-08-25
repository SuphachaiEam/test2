package th.priisoft.crm.spring.service.common;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.priisoft.crm.spring.entity.crmdta.RolesEntity;
import th.priisoft.crm.spring.entity.prii.crmdta.Bank;
import th.priisoft.crm.spring.entity.prii.padta.Client;
import th.priisoft.crm.spring.repository.crm.CRMCommonRepository;
import th.priisoft.crm.spring.repository.priicrm.PriiCRMCommonRepository;
import th.priisoft.crm.spring.repository.priipa.PriiPACommonRepository;

@Service
public class CommonServiceImpl implements CommonService {
	@Autowired
	private CRMCommonRepository crmCommonRepository;
	
	@Autowired
	private PriiCRMCommonRepository priiCRMCommonRepository;
	
	@Autowired
	private PriiPACommonRepository priiPACommonRepository;
	
	@Override
	@Transactional("CRM_Trans")
	public RolesEntity saveRoleEnttiy() throws Exception {
		RolesEntity entity = new  RolesEntity();
		entity.setRole_name_th("test");
		entity = crmCommonRepository.saveRoleEnttiy(entity);
		return entity;
	}
	
	@Transactional("PRII_CRM_Trans")
	public Bank saveBankEnttiy() throws Exception {
		Bank entity = new  Bank();
		entity.setBanknameTh("test");
		entity = priiCRMCommonRepository.saveBankEnttiy(entity);
		return entity;
	}
	@Transactional("PRII_PA_Trans")
	public Client saveClientEnttiy() throws Exception {
		//Client entity = new  Client();
		//entity.setName("");
		//entity = priiPACommonRepository.saveClientEnttiy(entity);
		//return entity;
		return null;
	}
	@Transactional("PRII_PA_Trans")
	public Client saveClientEnttiy(String name) throws Exception {
		//Client entity = new  Client();
		//entity.setName(name);
		//entity = priiPACommonRepository.saveClientEnttiy(entity);
		//return entity;
		return null;
	}
	@Transactional("PRII_PA_Trans")
	public Client findClientEnttiy() throws Exception {
		//Client entity  = priiPACommonRepository.findClientEnttiy(((long)1));
		//return entity;
		return null;
	}
	@Transactional("PRII_PA_Trans")
	public Client updateClientEnttiy() throws Exception {
		int rand = (int)(Math.random()*100);
		
		//Client entity  = priiPACommonRepository.findClientEnttiy(((long)1));
		//entity.setName("rand"+rand);
		//priiPACommonRepository.updateClientEnttiy(entity);
		//return entity;
		return null;
	}
	@Transactional("PRII_PA_Trans")
	public void deleteClientEnttiy(Client entity) throws Exception {
		try {
			//priiPACommonRepository.deleteClientEnttiy(entity);
		}catch (Exception e) {
			e.printStackTrace();
		}
	}
	
	@Transactional("PRII_PA_Trans")
	public List<Client> findByName(String searchName) throws Exception {
		try {
			//return priiPACommonRepository.findByName(searchName);
		}catch (Exception e) {
			return null;
		}
		return null;
	}
	
	
	@Transactional("PRII_PA_Trans")
	public void updateByName(String oldName,String newName) throws Exception{
		//priiPACommonRepository.updateByName(oldName, newName);
	}
}

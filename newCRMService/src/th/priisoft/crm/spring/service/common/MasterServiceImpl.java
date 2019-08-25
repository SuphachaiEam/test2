package th.priisoft.crm.spring.service.common;

import java.util.ArrayList;
import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.springframework.transaction.annotation.Transactional;

import th.priisoft.crm.spring.entity.prii.crmdta.AccessMenu;
import th.priisoft.crm.spring.entity.prii.crmdta.Bank;
import th.priisoft.crm.spring.entity.prii.crmdta.Cardtype;
import th.priisoft.crm.spring.entity.prii.crmdta.FullUser;
import th.priisoft.crm.spring.entity.prii.crmdta.Gender;
import th.priisoft.crm.spring.entity.prii.crmdta.Groupmenu;
import th.priisoft.crm.spring.entity.prii.crmdta.Label;
import th.priisoft.crm.spring.entity.prii.crmdta.Menu;
import th.priisoft.crm.spring.entity.prii.crmdta.Module;
import th.priisoft.crm.spring.entity.prii.crmdta.Param;
import th.priisoft.crm.spring.entity.prii.crmdta.Partner;
import th.priisoft.crm.spring.entity.prii.crmdta.Product;
import th.priisoft.crm.spring.entity.prii.crmdta.Province;
import th.priisoft.crm.spring.entity.prii.crmdta.Reason;
import th.priisoft.crm.spring.entity.prii.crmdta.RefMaster;
import th.priisoft.crm.spring.entity.prii.crmdta.Role;
import th.priisoft.crm.spring.entity.prii.crmdta.Status;
import th.priisoft.crm.spring.entity.prii.crmdta.Title;
import th.priisoft.crm.spring.entity.prii.crmdta.TmpRoleMenu;
import th.priisoft.crm.spring.entity.prii.crmdta.User;
import th.priisoft.crm.spring.entity.prii.crmdta.UsersHi;
import th.priisoft.crm.spring.repository.priicrm.PriiCRMCommonRepository;
@Service
public class MasterServiceImpl implements MasterService {
	@Autowired
	private PriiCRMCommonRepository priiCRMCommonRepository;
	
	//Start bank
	@Transactional("PRII_CRM_Trans")
	public Bank saveBankEnttiy(Bank bank) throws Exception {
		bank = priiCRMCommonRepository.saveBankEnttiy(bank);
		return bank;
	}
	
	@Transactional("PRII_CRM_Trans")
	public boolean updateBankEnttiy(Bank bank) throws Exception {
		return priiCRMCommonRepository.updateBankEntity(bank);

	}
	@Transactional("PRII_CRM_Trans")
	public Bank findBankByID(int bankid) throws Exception {
		Bank entity = new  Bank();
		entity = priiCRMCommonRepository.findBankByID(bankid);
		return entity;
	}
	@Transactional("PRII_CRM_Trans")
	public List<Bank> findBankByCond(String json) throws Exception {
		List<Bank> lsentity = priiCRMCommonRepository.findBankByCond(json);
		return lsentity;
	}
	//End Bank
	
	//Start Modules
	@Transactional("PRII_CRM_Trans")
	public Module saveModuleEnttiy(Module module) throws Exception {
		module = priiCRMCommonRepository.saveModuleEnttiy(module);
		return module;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean updateModuleEnttiy(Module module) throws Exception {
		return priiCRMCommonRepository.updateModuleEntity(module);
		
	}
	@Transactional("PRII_CRM_Trans")
	public Module findModuleByID(int moduleid) throws Exception {
		Module entity = new  Module();
		entity = priiCRMCommonRepository.findModuleByID(moduleid);
		return entity;
	}
	@Transactional("PRII_CRM_Trans")
	public List<Module> findModuleByCond(String json) throws Exception {
		List<Module> lsentity = priiCRMCommonRepository.findModuleByCond(json);
		return lsentity;
	}
	//End Module
	
	//Start Status
	@Transactional("PRII_CRM_Trans")
	public Status saveStatusEnttiy(Status status) throws Exception {
		status = priiCRMCommonRepository.saveStatusEnttiy(status);
		return status;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean updateStatusEnttiy(Status status) throws Exception {
		return priiCRMCommonRepository.updateStatusEntity(status);
		
	}
	@Transactional("PRII_CRM_Trans")
	public Status findStatusByID(int statusid) throws Exception {
		Status entity = new  Status();
		entity = priiCRMCommonRepository.findStatusByID(statusid);
		return entity;
	}
	@Transactional("PRII_CRM_Trans")
	public List<Status> findStatusByCond(String json) throws Exception {
		List<Status> lsentity = priiCRMCommonRepository.findStatusByCond(json);
		return lsentity;
	}
	//End status
	//Start reason
	@Transactional("PRII_CRM_Trans")
	public Reason saveReasonEnttiy(Reason reason) throws Exception {
		reason = priiCRMCommonRepository.saveReasonEnttiy(reason);
		return reason;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean updateReasonEnttiy(Reason reason) throws Exception {
		return priiCRMCommonRepository.updateReasonEntity(reason);
		
	}
	@Transactional("PRII_CRM_Trans")
	public Reason findReasonByID(int reasonid) throws Exception {
		Reason entity = new  Reason();
		entity = priiCRMCommonRepository.findReasonByID(reasonid);
		return entity;
	}
	@Transactional("PRII_CRM_Trans")
	public List<Reason> findReasonByCond(String json) throws Exception {
		List<Reason> lsentity = priiCRMCommonRepository.findReasonByCond(json);
		return lsentity;
	}
	//End reason
	//Start Card type
	@Transactional("PRII_CRM_Trans")
	public Cardtype saveCardtypeEnttiy(Cardtype cardtype) throws Exception {
		cardtype = priiCRMCommonRepository.saveCardtypeEnttiy(cardtype);
		return cardtype;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean updateCardtypeEnttiy(Cardtype cardtype) throws Exception {
		return priiCRMCommonRepository.updateCardtypeEntity(cardtype);
		
	}
	@Transactional("PRII_CRM_Trans")
	public Cardtype findCardtypeByID(int cardtypeid) throws Exception {
		Cardtype entity = new  Cardtype();
		entity = priiCRMCommonRepository.findCardtypeByID( cardtypeid);
		return entity;
	}
	@Transactional("PRII_CRM_Trans")
	public List<Cardtype> findCardtypeByCond(String json) throws Exception {
		List<Cardtype> lsentity = priiCRMCommonRepository.findCardtypeByCond(json);
		return lsentity;
	}
	//End Card type
	//Start Label
	@Transactional("PRII_CRM_Trans")
	public Label saveLabelEnttiy(Label label) throws Exception {
		label = priiCRMCommonRepository.saveLabelEnttiy(label);
		return label;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean updateLabelEnttiy(Label label) throws Exception {
		return priiCRMCommonRepository.updateLabelEntity(label);
		
	}
	@Transactional("PRII_CRM_Trans")
	public Label findLabelByID(int labelid) throws Exception {
		Label entity = new  Label();
		entity = priiCRMCommonRepository.findLabelByID( labelid);
		return entity;
	}
	@Transactional("PRII_CRM_Trans")
	public List<Label> findLabelByCond(String json) throws Exception {
		List<Label> lsentity = priiCRMCommonRepository.findLabelByCond(json);
		return lsentity;
	}
	//End Label
	//Start Param
	@Transactional("PRII_CRM_Trans")
	public Param saveParamEnttiy(Param param) throws Exception {
		param = priiCRMCommonRepository.saveParamEnttiy(param);
		return param;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean updateParamEnttiy(Param param) throws Exception {
		return priiCRMCommonRepository.updateParamEntity(param);
		
	}
	@Transactional("PRII_CRM_Trans")
	public Param findParamByID(int paramid) throws Exception {
		Param entity = new  Param();
		entity = priiCRMCommonRepository.findParamByID( paramid);
		return entity;
	}
	@Transactional("PRII_CRM_Trans")
	public List<Param> findParamByCond(String json) throws Exception {
		List<Param> lsentity = priiCRMCommonRepository.findParamByCond(json);
		return lsentity;
	}
	//End Param
	//Start Partner
	@Transactional("PRII_CRM_Trans")
	public Partner savePartnerEnttiy(Partner partner) throws Exception {
		partner = priiCRMCommonRepository.savePartnerEnttiy(partner);
		return partner;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean updatePartnerEnttiy(Partner partner) throws Exception {
		return priiCRMCommonRepository.updatePartnerEntity(partner);
		
	}
	@Transactional("PRII_CRM_Trans")
	public Partner findPartnerByID(int partnerid) throws Exception {
		Partner entity = new  Partner();
		entity = priiCRMCommonRepository.findPartnerByID( partnerid);
		return entity;
	}
	@Transactional("PRII_CRM_Trans")
	public List<Partner> findPartnerByCond(String json) throws Exception {
		List<Partner> lsentity = priiCRMCommonRepository.findPartnerByCond(json);
		return lsentity;
	}
	//End Partner
	//Start Product
	@Transactional("PRII_CRM_Trans")
	public Product saveProductEnttiy(Product product) throws Exception {
		product = priiCRMCommonRepository.saveProductEnttiy(product);
		return product;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean updateProductEnttiy(Product product) throws Exception {
		return priiCRMCommonRepository.updateProductEntity(product);
		
	}
	@Transactional("PRII_CRM_Trans")
	public Product findProductByID(int productid) throws Exception {
		Product entity = new  Product();
		entity = priiCRMCommonRepository.findProductByID( productid);
		return entity;
	}
	@Transactional("PRII_CRM_Trans")
	public List<Product> findProductByCond(String json) throws Exception {
		List<Product> lsentity = priiCRMCommonRepository.findProductByCond(json);
		return lsentity;
	}
	//End Product
	//Start Menu
	@Transactional("PRII_CRM_Trans")
	public Menu saveMenuEnttiy(Menu menu) throws Exception {
		menu = priiCRMCommonRepository.saveMenuEnttiy(menu);
		return menu;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean updateMenuEnttiy(Menu menu) throws Exception {
		return priiCRMCommonRepository.updateMenuEntity(menu);
		
	}
	@Transactional("PRII_CRM_Trans")
	public Menu findMenuByID(int menuid) throws Exception {
		Menu entity = new  Menu();
		entity = priiCRMCommonRepository.findMenuByID( menuid);
		return entity;
	}
	@Transactional("PRII_CRM_Trans")
	public List<Menu> findMenuByCond(String json) throws Exception {
		List<Menu> lsentity = priiCRMCommonRepository.findMenuByCond(json);
		return lsentity;
	}
	//End Menu
	//Start Role
	@Transactional("PRII_CRM_Trans")
	public Role saveRoleEnttiy(Role role) throws Exception {
		role = priiCRMCommonRepository.saveRoleEnttiy(role);
		return role;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean updateRoleEnttiy(Role role) throws Exception {
		return priiCRMCommonRepository.updateRoleEntity(role);
		
	}
	@Transactional("PRII_CRM_Trans")
	public Role findRoleByID(int roleid) throws Exception {
		Role entity = new  Role();
		entity = priiCRMCommonRepository.findRoleByID( roleid);
		return entity;
	}
	@Transactional("PRII_CRM_Trans")
	public List<Role> findRoleByCond(String json) throws Exception {
		List<Role> lsentity = priiCRMCommonRepository.findRoleByCond(json);
		return lsentity;
	}
	@Transactional("PRII_CRM_Trans")
	public ArrayList<Role> findRoleUserByCond(String json) throws Exception {
		ArrayList<Role> lsentity = priiCRMCommonRepository.findRoleUserByCond(json);
		return lsentity;
	}
	//End Role
	//Start access menu
	@Transactional("PRII_CRM_Trans")
	public AccessMenu saveAccessMenuEnttiy(AccessMenu accessMenu) throws Exception {
		accessMenu = priiCRMCommonRepository.saveAccessMenuEnttiy(accessMenu);
		return accessMenu;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean updateAccessMenuEnttiy(AccessMenu accessMenu) throws Exception {
		return priiCRMCommonRepository.updateAccessMenuEntity(accessMenu);
		
	}
	@Transactional("PRII_CRM_Trans")
	public AccessMenu findAccessMenuByID(int accessMenuid) throws Exception {
		AccessMenu entity = new  AccessMenu();
		entity = priiCRMCommonRepository.findAccessMenuByID( accessMenuid);
		return entity;
	}
	
	@Transactional("PRII_CRM_Trans")
	public ArrayList<AccessMenu> findAccessMenuByCond(String json) throws Exception {
		ArrayList<AccessMenu> lsentity = priiCRMCommonRepository.findAccessMenuByCond(json);
		return lsentity;
	}
	@Transactional("PRII_CRM_Trans")
	public ArrayList<AccessMenu> findAccessUserByCond(String json) throws Exception {
		ArrayList<AccessMenu> lsentity = priiCRMCommonRepository.findAccessUserByCond(json);
		return lsentity;
	}
	//End access menu
	//Start full user
	@Transactional("PRII_CRM_Trans")
	public UsersHi saveUserHistoryEnttiy(String act,String json,int userid, int rmid) throws Exception {
		UsersHi user = priiCRMCommonRepository.saveUserHistory(act, json, userid, rmid);
		return user;
	}
	@Transactional("PRII_CRM_Trans")
	public User findUserByID(int userid) throws Exception {
		User user = priiCRMCommonRepository.findUserByID(userid);
		return user;
	}
	@Transactional("PRII_CRM_Trans")
	public ArrayList<User> findUserEnttiyByCond(String json) throws Exception {
		ArrayList<User> lsUser = priiCRMCommonRepository.findUserByCond(json);
		return lsUser;
	}
	@Transactional("PRII_CRM_Trans")
	public FullUser saveFullUserEnttiy(FullUser fullUser) throws Exception {
		fullUser = priiCRMCommonRepository.saveFullUserEnttiy(fullUser);
		return fullUser;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean updateFullUserEnttiy(FullUser fullUser) throws Exception {
		return priiCRMCommonRepository.updateFullUserEntity(fullUser);
		
	}
	@Transactional("PRII_CRM_Trans")
	public List<RefMaster> findRefMasterByCond(String json) throws Exception {
		List<RefMaster> lsentity = priiCRMCommonRepository.findRefMasterByCond(json);
		return lsentity;
	}
	@Transactional("PRII_CRM_Trans")
	public FullUser findFullUserByID(int rmid) throws Exception {
		FullUser entity = new  FullUser();
		entity = priiCRMCommonRepository.findFullUserByID( rmid);
		return entity;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean removeUserByID(int userid) throws Exception {

		return priiCRMCommonRepository.removeUserByID(userid);
	}
	@Transactional("PRII_CRM_Trans")
	public List<FullUser> findFullUserByCond(String json) throws Exception {
		List<FullUser> lsentity = priiCRMCommonRepository.findFullUserByCond(json);
		return lsentity;
	}
	@Transactional("PRII_CRM_Trans")
	public boolean removeFullUserEnttiy(RefMaster refmaster,int userid) throws Exception {
		return priiCRMCommonRepository.removeFullUser(refmaster, userid);
		
	}
	//End full user
	
	//Start template role menu
		@Transactional("PRII_CRM_Trans")
		public TmpRoleMenu saveTmpRoleMenuEnttiy(TmpRoleMenu tmpRoleMenu) throws Exception {
			tmpRoleMenu = priiCRMCommonRepository.saveTmpRoleMenuEnttiy(tmpRoleMenu);
			return tmpRoleMenu;
		}
		
		@Transactional("PRII_CRM_Trans")
		public boolean updateTmpRoleMenuEnttiy(TmpRoleMenu tmpRoleMenu) throws Exception {
			return priiCRMCommonRepository.updateTmpRoleMenuEntity(tmpRoleMenu);

		}
		@Transactional("PRII_CRM_Trans")
		public TmpRoleMenu findTmpRoleMenuByID(int tmpRoleMenuid) throws Exception {
			TmpRoleMenu entity = new  TmpRoleMenu();
			entity = priiCRMCommonRepository.findTmpRoleMenuByID(tmpRoleMenuid);
			return entity;
		}
		@Transactional("PRII_CRM_Trans")
		public List<TmpRoleMenu> findTmpRoleMenuByCond(String json) throws Exception {
			List<TmpRoleMenu> lsentity = priiCRMCommonRepository.findTmpRoleMenuByCond(json);
			return lsentity;
		}
		@Transactional("PRII_CRM_Trans")
		public boolean deleteTmpRoleMenuEnttiy(int tmpRoleMenuid) throws Exception {
			return priiCRMCommonRepository.deleteTmpRoleMenuEnttiy(tmpRoleMenuid);

		}
		//End template role menu
	//Start Group menu
		@Transactional("PRII_CRM_Trans")
		public Groupmenu saveGroupmenuEnttiy(Groupmenu groupmenu) throws Exception {
			groupmenu = priiCRMCommonRepository.saveGroupmenuEnttiy(groupmenu);
			return groupmenu;
		}
		
		@Transactional("PRII_CRM_Trans")
		public boolean updateGroupmenuEnttiy(Groupmenu groupmenu) throws Exception {
			return priiCRMCommonRepository.updateGroupmenuEntity(groupmenu);

		}
		@Transactional("PRII_CRM_Trans")
		public Groupmenu findGroupmenuByID(int grpmenuid) throws Exception {
			Groupmenu entity = new  Groupmenu();
			entity = priiCRMCommonRepository.findGroupmenuByID(grpmenuid);
			return entity;
		}
		@Transactional("PRII_CRM_Trans")
		public List<Groupmenu> findGroupmenuByCond(String json) throws Exception {
			List<Groupmenu> lsentity = priiCRMCommonRepository.findGroupmenuByCond(json);
			return lsentity;
		}
	//End Group menu
	//Start title
		@Transactional("PRII_CRM_Trans")
		public Title saveTitleEnttiy(Title title) throws Exception {
			title = priiCRMCommonRepository.saveTitleEnttiy(title);
			return title;
		}
		
		@Transactional("PRII_CRM_Trans")
		public boolean updateTitleEnttiy(Title title) throws Exception {
			return priiCRMCommonRepository.updateTitleEntity(title);

		}
		@Transactional("PRII_CRM_Trans")
		public Title findTitleByID(int titleid) throws Exception {
			Title entity = new  Title();
			entity = priiCRMCommonRepository.findTitleByID(titleid);
			return entity;
		}
		@Transactional("PRII_CRM_Trans")
		public List<Title> findTitleByCond(String json) throws Exception {
			List<Title> lsentity = priiCRMCommonRepository.findTitleByCond(json);
			return lsentity;
		}		
	//End title
	//Start Gender
		@Transactional("PRII_CRM_Trans")
		public Gender saveGenderEnttiy(Gender gender) throws Exception {
			gender = priiCRMCommonRepository.saveGenderEnttiy(gender);
			return gender;
		}
				
		@Transactional("PRII_CRM_Trans")
		public boolean updateGenderEnttiy(Gender gender) throws Exception {
			return priiCRMCommonRepository.updateGenderEntity(gender);

		}
		@Transactional("PRII_CRM_Trans")
		public Gender findGenderByID(int genderid) throws Exception {
			Gender entity = new  Gender();
			entity = priiCRMCommonRepository.findGenderByID(genderid);
			return entity;
		}
		@Transactional("PRII_CRM_Trans")
		public List<Gender> findGenderByCond(String json) throws Exception {
			List<Gender> lsentity = priiCRMCommonRepository.findGenderByCond(json);
			return lsentity;
		}		
	//End Gender
	//Start Province
	@Transactional("PRII_CRM_Trans")
	public Province saveProvinceEnttiy(Province entity) throws Exception {
		entity = priiCRMCommonRepository.saveProvinceEnttiy(entity);
		return entity;
	}
				
	@Transactional("PRII_CRM_Trans")
	public boolean updateProvinceEnttiy(Province entity) throws Exception {
		return priiCRMCommonRepository.updateProvinceEntity(entity);

	}
	@Transactional("PRII_CRM_Trans")
	public Province findProvinceByID(int id) throws Exception {
		Province entity = new  Province();
		entity = priiCRMCommonRepository.findProvinceByID(id);
		return entity;
	}
	@Transactional("PRII_CRM_Trans")
	public List<Province> findProvinceByCond(String json) throws Exception {
		List<Province> lsentity = priiCRMCommonRepository.findProvinceByCond(json);
		return lsentity;
	}		
	//End Province
		
}

package th.priisoft.crm.spring.repository.priicrm;

import java.util.ArrayList;
import java.util.List;

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

public interface PriiCRMCommonRepository {
	
	public Bank saveBankEnttiy(Bank entity) throws Exception;
	public boolean updateBankEntity(Bank entity) throws Exception;
	public Bank findBankByID(int bankid) throws Exception;
	public List<Bank> findBankByCond(String json) throws Exception;
	
	public Module saveModuleEnttiy(Module entity) throws Exception;
	public boolean updateModuleEntity(Module entity) throws Exception;
	public Module findModuleByID(int moduledid) throws Exception;
	public List<Module> findModuleByCond(String json) throws Exception;
	
	public Status saveStatusEnttiy(Status entity) throws Exception;
	public boolean updateStatusEntity(Status entity) throws Exception;
	public Status findStatusByID(int statusid) throws Exception;
	public List<Status> findStatusByCond(String json) throws Exception;
	
	public Reason saveReasonEnttiy(Reason entity) throws Exception;
	public boolean updateReasonEntity(Reason entity) throws Exception;
	public Reason findReasonByID(int reasonid) throws Exception;
	public List<Reason> findReasonByCond(String json) throws Exception;
	
	public Cardtype saveCardtypeEnttiy(Cardtype entity) throws Exception;
	public boolean updateCardtypeEntity(Cardtype entity) throws Exception;
	public Cardtype findCardtypeByID(int cardtypeid) throws Exception;
	public List<Cardtype> findCardtypeByCond(String json) throws Exception;
	
	public Label saveLabelEnttiy(Label entity) throws Exception;
	public boolean updateLabelEntity(Label entity) throws Exception;
	public Label findLabelByID(int labelid) throws Exception;
	public List<Label> findLabelByCond(String json) throws Exception;
	
	public Param saveParamEnttiy(Param entity) throws Exception;
	public boolean updateParamEntity(Param entity) throws Exception;
	public Param findParamByID(int paramid) throws Exception;
	public List<Param> findParamByCond(String json) throws Exception;
	
	public Partner savePartnerEnttiy(Partner entity) throws Exception;
	public boolean updatePartnerEntity(Partner entity) throws Exception;
	public Partner findPartnerByID(int partnerid) throws Exception;
	public List<Partner> findPartnerByCond(String json) throws Exception;
	
	public Product saveProductEnttiy(Product entity) throws Exception;
	public boolean updateProductEntity(Product entity) throws Exception;
	public Product findProductByID(int productid) throws Exception;
	public List<Product> findProductByCond(String json) throws Exception;
	
	public Menu saveMenuEnttiy(Menu entity) throws Exception;
	public boolean updateMenuEntity(Menu entity) throws Exception;
	public Menu findMenuByID(int menuid) throws Exception;
	public List<Menu> findMenuByCond(String json) throws Exception;
	
	public Role saveRoleEnttiy(Role entity) throws Exception;
	public boolean updateRoleEntity(Role entity) throws Exception;
	public Role findRoleByID(int roleid) throws Exception;
	public List<Role> findRoleByCond(String json) throws Exception;
	public ArrayList<Role> findRoleUserByCond(String json) throws Exception;
	
	public AccessMenu saveAccessMenuEnttiy(AccessMenu entity) throws Exception;
	public boolean updateAccessMenuEntity(AccessMenu entity) throws Exception;
	public AccessMenu findAccessMenuByID(int accessMenuid) throws Exception;
	public ArrayList<AccessMenu> findAccessMenuByCond(String json) throws Exception;
	public ArrayList<AccessMenu> findAccessUserByCond(String json) throws Exception;
	public ArrayList<RefMaster> findRefMasterByCond(String json) throws Exception;
	
	public UsersHi saveUserHistory(String act,String json,int userid, int rmid) throws Exception;
	public User findUserByID(int userid) throws Exception;
	public boolean removeUserByID(int userid) throws Exception;
	public ArrayList<User> findUserByCond(String json) throws Exception;
	public FullUser saveFullUserEnttiy(FullUser entity) throws Exception;
	public boolean updateFullUserEntity(FullUser entity) throws Exception;
	public FullUser findFullUserByID(int rmid) throws Exception;
	public List<FullUser> findFullUserByCond(String json) throws Exception;
	public boolean removeFullUser(RefMaster refmaster,int userid) throws Exception;
	
	public TmpRoleMenu saveTmpRoleMenuEnttiy(TmpRoleMenu entity) throws Exception;
	public boolean updateTmpRoleMenuEntity(TmpRoleMenu entity) throws Exception;
	public TmpRoleMenu findTmpRoleMenuByID(int tmpRoleMenuid) throws Exception;
	public List<TmpRoleMenu> findTmpRoleMenuByCond(String json) throws Exception;
	public boolean deleteTmpRoleMenuEnttiy(int tmpRoleMenuid) 	throws Exception;
	
	public Groupmenu saveGroupmenuEnttiy(Groupmenu entity) throws Exception;
	public boolean updateGroupmenuEntity(Groupmenu entity) throws Exception;
	public Groupmenu findGroupmenuByID(int grpmenuid) throws Exception;
	public List<Groupmenu> findGroupmenuByCond(String json) throws Exception;
	
	public Title saveTitleEnttiy(Title entity) throws Exception;
	public boolean updateTitleEntity(Title entity) throws Exception;
	public Title findTitleByID(int titleid) throws Exception;
	public List<Title> findTitleByCond(String json) throws Exception;
	
	public Gender saveGenderEnttiy(Gender entity) throws Exception;
	public boolean updateGenderEntity(Gender entity) throws Exception;
	public Gender findGenderByID(int genderid) throws Exception;
	public List<Gender> findGenderByCond(String json) throws Exception;
	
	public Province saveProvinceEnttiy(Province entity) 	throws Exception;
	public boolean updateProvinceEntity(Province entity) throws Exception;
	public Province findProvinceByID(long pid) throws Exception;
	public List<Province> findProvinceByCond(String json) throws Exception;
	public boolean deleteProvinceEnttiy(long pid) 	throws Exception;
}

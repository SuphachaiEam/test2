package th.priisoft.crm.spring.service.common;

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

public interface MasterService {
	public Bank saveBankEnttiy(Bank bank) throws Exception;
	public boolean updateBankEnttiy(Bank bank) throws Exception;
	public Bank findBankByID(int bankid) throws Exception;
	public List<Bank> findBankByCond(String json) throws Exception;
	
	public Module saveModuleEnttiy(Module module) throws Exception;
	public boolean updateModuleEnttiy(Module module) throws Exception;
	public Module findModuleByID(int moduleid) throws Exception;
	public List<Module> findModuleByCond(String json) throws Exception;
	
	public Status saveStatusEnttiy(Status status) throws Exception;
	public boolean updateStatusEnttiy(Status status) throws Exception;
	public Status findStatusByID(int statusid) throws Exception;
	public List<Status> findStatusByCond(String json) throws Exception;
	
	public Reason saveReasonEnttiy(Reason reason) throws Exception;
	public boolean updateReasonEnttiy(Reason reason) throws Exception;
	public Reason findReasonByID(int reasonid) throws Exception;
	public List<Reason> findReasonByCond(String json) throws Exception;
	
	public Cardtype saveCardtypeEnttiy(Cardtype cardtype) throws Exception;
	public boolean updateCardtypeEnttiy(Cardtype cardtype) throws Exception;
	public Cardtype findCardtypeByID(int cardtypeid) throws Exception;
	public List<Cardtype> findCardtypeByCond(String json) throws Exception;
	
	public Label saveLabelEnttiy(Label label) throws Exception;
	public boolean updateLabelEnttiy(Label label) throws Exception;
	public Label findLabelByID(int labelid) throws Exception;
	public List<Label> findLabelByCond(String json) throws Exception;
	
	public Param saveParamEnttiy(Param param) throws Exception;
	public boolean updateParamEnttiy(Param param) throws Exception;
	public Param findParamByID(int paramid) throws Exception;
	public List<Param> findParamByCond(String json) throws Exception;
	
	public Partner savePartnerEnttiy(Partner partner) throws Exception;
	public boolean updatePartnerEnttiy(Partner partner) throws Exception;
	public Partner findPartnerByID(int partnerid) throws Exception;
	public List<Partner> findPartnerByCond(String json) throws Exception;
	
	public Product saveProductEnttiy(Product product) throws Exception;
	public boolean updateProductEnttiy(Product product) throws Exception;
	public Product findProductByID(int productid) throws Exception;
	public List<Product> findProductByCond(String json) throws Exception;
	
	public Menu saveMenuEnttiy(Menu menu) throws Exception;
	public boolean updateMenuEnttiy(Menu menu) throws Exception;
	public Menu findMenuByID(int menuid) throws Exception;
	public List<Menu> findMenuByCond(String json) throws Exception;
	
	public Role saveRoleEnttiy(Role role) throws Exception;
	public boolean updateRoleEnttiy(Role role) throws Exception;
	public Role findRoleByID(int roleid) throws Exception;
	public List<Role> findRoleByCond(String json) throws Exception;
	public ArrayList<Role> findRoleUserByCond(String json) throws Exception;
	
	public AccessMenu saveAccessMenuEnttiy(AccessMenu accessMenu) throws Exception;
	public boolean updateAccessMenuEnttiy(AccessMenu accessMenu) throws Exception;
	public AccessMenu findAccessMenuByID(int accessMenuid) throws Exception;
	public ArrayList<AccessMenu> findAccessMenuByCond(String json) throws Exception;
	public ArrayList<AccessMenu> findAccessUserByCond(String json) throws Exception;
	public List<RefMaster> findRefMasterByCond(String json) throws Exception;
	
	public UsersHi saveUserHistoryEnttiy(String act,String json,int userid,int rmid) throws Exception;
	public User findUserByID(int userid) throws Exception;
	public boolean removeUserByID(int userid) throws Exception;
	public ArrayList<User> findUserEnttiyByCond(String json) throws Exception;
	public FullUser saveFullUserEnttiy(FullUser fullUser) throws Exception;
	public boolean updateFullUserEnttiy(FullUser fullUser) throws Exception;
	public FullUser findFullUserByID(int rmid) throws Exception;
	public List<FullUser> findFullUserByCond(String json) throws Exception;
	public boolean removeFullUserEnttiy(RefMaster refmaster,int userid) throws Exception;
	
	public TmpRoleMenu saveTmpRoleMenuEnttiy(TmpRoleMenu tmpRoleMenu) throws Exception;
	public boolean updateTmpRoleMenuEnttiy(TmpRoleMenu tmpRoleMenu) throws Exception;
	public TmpRoleMenu findTmpRoleMenuByID(int tmpRoleMenuid) throws Exception;
	public List<TmpRoleMenu> findTmpRoleMenuByCond(String json) throws Exception;
	public boolean deleteTmpRoleMenuEnttiy(int tmpRoleMenuid) throws Exception;
	
	public Groupmenu saveGroupmenuEnttiy(Groupmenu groupmenu) throws Exception;
	public boolean updateGroupmenuEnttiy(Groupmenu groupmenu) throws Exception;
	public Groupmenu findGroupmenuByID(int grpmenuid) throws Exception;
	public List<Groupmenu> findGroupmenuByCond(String json) throws Exception;
	
	public Title saveTitleEnttiy(Title title) throws Exception;
	public boolean updateTitleEnttiy(Title title) throws Exception;
	public Title findTitleByID(int titleid) throws Exception;
	public List<Title> findTitleByCond(String json) throws Exception;
	
	public Gender saveGenderEnttiy(Gender title) throws Exception;
	public boolean updateGenderEnttiy(Gender title) throws Exception;
	public Gender findGenderByID(int titleid) throws Exception;
	public List<Gender> findGenderByCond(String json) throws Exception;
	
	public Province saveProvinceEnttiy(Province entity) throws Exception;
	public boolean updateProvinceEnttiy(Province entity) throws Exception;
	public Province findProvinceByID(int id) throws Exception;
	public List<Province> findProvinceByCond(String json) throws Exception;
}

package th.priisoft.crm.spring.repository.priicrm;

import java.util.ArrayList;
import java.util.List;

import javax.persistence.Query;

import org.springframework.stereotype.Repository;

import th.priisoft.crm.common.date.DateControl;
import th.priisoft.crm.common.utils.JsonUtils;
import th.priisoft.crm.spring.entity.prii.crmdta.AccessMenu;
import th.priisoft.crm.spring.entity.prii.crmdta.Bank;
import th.priisoft.crm.spring.entity.prii.crmdta.Cardtype;
import th.priisoft.crm.spring.entity.prii.crmdta.FullUser;
import th.priisoft.crm.spring.entity.prii.crmdta.Gender;
import th.priisoft.crm.spring.entity.prii.crmdta.Groupmenu;
import th.priisoft.crm.spring.entity.prii.crmdta.Label;
import th.priisoft.crm.spring.entity.prii.crmdta.Lov;
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
import th.priisoft.crm.spring.entity.prii.crmdta.VfullUser;
import th.priisoft.crm.spring.repository.BasePRIICRMRepository;

@Repository
public class PriiCRMCommonRepositoryImpl extends BasePRIICRMRepository implements PriiCRMCommonRepository {
	//Start Bank
	public Bank saveBankEnttiy(Bank entity) 	throws Exception {
		entityManager.persist(entity);
		return entity;
	}
	public boolean updateBankEntity(Bank entity) throws Exception {
		boolean result = false;
		try {
			entityManager.merge(entity);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	public Bank findBankByID(int bankid) throws Exception {
		return entityManager.find(Bank.class, bankid);
	}
	public List<Bank> findBankByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM BANK  ";
		
		List<Bank> lsBank  = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsBank = entityManager.createNativeQuery(sqlStr + sqlWhere, Bank.class)
							.getResultList();
			} else {
				lsBank = entityManager.createNativeQuery(sqlStr, Bank.class)
						.getResultList();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsBank;
	}
	//End Bank
	
	//Start Modules
	public Module saveModuleEnttiy(Module entity) 	throws Exception {
		entityManager.persist(entity);
		return entity;
	}
	public boolean updateModuleEntity(Module entity) throws Exception {
		boolean result = false;
		try {
			entityManager.merge(entity);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}

		return result;
	}
	public Module findModuleByID(int moduleid) throws Exception {
		return entityManager.find(Module.class, moduleid);
	}
	public List<Module> findModuleByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM Modules  ";
		
		List<Module> lsModule  = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsModule = entityManager.createNativeQuery(sqlStr + sqlWhere, Module.class)
							.getResultList();
			} else {
				lsModule = entityManager.createNativeQuery(sqlStr, Module.class)
						.getResultList();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsModule;
	}
	//End modules
	
	//Start Status
	public Status saveStatusEnttiy(Status entity) 	throws Exception {
		entityManager.persist(entity);
		return entity;
	}
	public boolean updateStatusEntity(Status entity) throws Exception {
		boolean result = false;
		try {
			entityManager.merge(entity);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public Status findStatusByID(int statusid) throws Exception {
		return entityManager.find(Status.class, statusid);
	}
	public List<Status> findStatusByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM STATUS  ";
		
		List<Status> lsStatus  = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsStatus = entityManager.createNativeQuery(sqlStr + sqlWhere, Status.class)
							.getResultList();
			} else {
				lsStatus = entityManager.createNativeQuery(sqlStr, Status.class)
						.getResultList();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsStatus;
	}
	//End Status
	//Start Reason
	public Reason saveReasonEnttiy(Reason entity) 	throws Exception {
		entityManager.persist(entity);
		return entity;
	}
	public boolean updateReasonEntity(Reason entity) throws Exception {
		boolean result = false;
		try {
			entityManager.merge(entity);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public Reason findReasonByID(int reasonid) throws Exception {
		return entityManager.find(Reason.class, reasonid);
	}
	public List<Reason> findReasonByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM Reason  ";
		
		List<Reason> lsReason  = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsReason = entityManager.createNativeQuery(sqlStr + sqlWhere, Reason.class)
							.getResultList();
			} else {
				lsReason = entityManager.createNativeQuery(sqlStr, Reason.class)
						.getResultList();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsReason;
	}
	//End Reason
	//Start Card type
	public Cardtype saveCardtypeEnttiy(Cardtype entity) 	throws Exception {
		entityManager.persist(entity);
		return entity;
	}
	public boolean updateCardtypeEntity(Cardtype entity) throws Exception {
		boolean result = false;
		try {
			entityManager.merge(entity);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public Cardtype findCardtypeByID(int cardtypeid) throws Exception {
		return entityManager.find(Cardtype.class, cardtypeid);
	}
	public List<Cardtype> findCardtypeByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM Cardtype  ";
		
		List<Cardtype> lsCardtype  = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsCardtype = entityManager.createNativeQuery(sqlStr + sqlWhere, Cardtype.class)
							.getResultList();
			} else {
				lsCardtype = entityManager.createNativeQuery(sqlStr, Cardtype.class)
						.getResultList();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsCardtype;
	}
	//End Card type
	//Start Label
	public Label saveLabelEnttiy(Label entity) 	throws Exception {
		try {
			entityManager.persist(entity);
			for (Lov lov : entity.getLovs()) {
				lov.setLabel(entity);
				entityManager.persist(lov);
			}
		} catch (Exception e) {
			e.printStackTrace();
		}
		return entity;
	}
	public boolean updateLabelEntity(Label entity) throws Exception {
		boolean result = false;
		try {
			entityManager.merge(entity);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public Label findLabelByID(int labelid) throws Exception {
		List<Lov> lsLov = null;
		Label lb = null;
		try {
			lb = entityManager.find(Label.class, labelid);
			if (lb != null && lb.getLabelid() > 0) {
				String str = "{\"LABELID\":" + lb.getLabelid() + "}";
				lsLov = findLovByCond(str);
				lb.setLovs(lsLov);
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return lb; 
	}
	public List<Label> findLabelByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM Labels  ";
		
		List<Label> lsLabel  = null;
		List<Lov> lsLov = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsLabel = entityManager.createNativeQuery(sqlStr + sqlWhere, Label.class)
							.getResultList();
			} else {
				lsLabel = entityManager.createNativeQuery(sqlStr, Label.class)
						.getResultList();
			}
			for (Label lb : lsLabel) {
				String str = "{\"LABELID\":" + lb.getLabelid() + "}";
				lsLov = findLovByCond(str);
				lb.setLovs(lsLov);
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsLabel;
	}
	public List<Lov> findLovByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM LOV  ";
		
		
		List<Lov> lsLov = new ArrayList<Lov>();
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsLov = entityManager.createNativeQuery(sqlStr + sqlWhere, Lov.class)
							.getResultList();
			} else {
				lsLov = entityManager.createNativeQuery(sqlStr, Lov.class)
						.getResultList();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsLov;
	}
	//End Label
	//Start Param
	public Param saveParamEnttiy(Param entity) 	throws Exception {
		entityManager.persist(entity);
		return entity;
	}
	public boolean updateParamEntity(Param entity) throws Exception {
		boolean result = false;
		try {
			entityManager.merge(entity);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public Param findParamByID(int paramid) throws Exception {
		return entityManager.find(Param.class, paramid);
	}
	public List<Param> findParamByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM Param  ";
	
		List<Param> lsParam  = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsParam = entityManager.createNativeQuery(sqlStr + sqlWhere, Param.class)
							.getResultList();
			} else {
				lsParam = entityManager.createNativeQuery(sqlStr, Param.class)
						.getResultList();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsParam;
	}
	//End Param
	//Start Partner
	public Partner savePartnerEnttiy(Partner entity) 	throws Exception {
		entityManager.persist(entity);
		return entity;
	}
	public boolean updatePartnerEntity(Partner entity) throws Exception {
		boolean result = false;
		try {
			entityManager.merge(entity);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public Partner findPartnerByID(int partnerid) throws Exception {
		return entityManager.find(Partner.class, partnerid);
	}
	public List<Partner> findPartnerByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM Partner  ";
		//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
		String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
		List<Partner> lsPartner  = null;
		try {
			if (json != null && json.length() > 1) {
				lsPartner = entityManager.createNativeQuery(sqlStr + sqlWhere, Partner.class)
							.getResultList();
			} else {
				lsPartner = entityManager.createNativeQuery(sqlStr, Partner.class)
						.getResultList();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsPartner;
	}
	//End Partner
	//Start Product
	public Product saveProductEnttiy(Product entity) 	throws Exception {
		entityManager.persist(entity);
		return entity;
	}
	public boolean updateProductEntity(Product entity) throws Exception {
		boolean result = false;
		try {
			entityManager.merge(entity);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public Product findProductByID(int productid) throws Exception {
		return entityManager.find(Product.class, productid);
	}
	public List<Product> findProductByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM Product  ";
		
		List<Product> lsProduct  = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsProduct = entityManager.createNativeQuery(sqlStr + sqlWhere, Product.class)
							.getResultList();
			} else {
				lsProduct = entityManager.createNativeQuery(sqlStr, Product.class)
						.getResultList();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsProduct;
	}
	//End Product
	//Start Menu
	public Menu saveMenuEnttiy(Menu entity) 	throws Exception {
		entityManager.persist(entity);
		return entity;
	}
	public boolean updateMenuEntity(Menu entity) throws Exception {
		boolean result = false;
		try {
			entityManager.merge(entity);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public Menu findMenuByID(int menuid) throws Exception {
		return entityManager.find(Menu.class, menuid);
	}
	public List<Menu> findMenuByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM Menu  ";
		
		List<Menu> lsMenu  = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsMenu = entityManager.createNativeQuery(sqlStr + sqlWhere, Menu.class)
							.getResultList();
			} else {
				lsMenu = entityManager.createNativeQuery(sqlStr, Menu.class)
						.getResultList();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsMenu;
	}
	//End Menu
	//Start Role
	public Role saveRoleEnttiy(Role entity) 	throws Exception {
		entityManager.persist(entity);
		return entity;
	}
	public boolean updateRoleEntity(Role entity) throws Exception {
		boolean result = false;
		try {
			entityManager.merge(entity);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public Role findRoleByID(int roleid) throws Exception {
		return entityManager.find(Role.class, roleid);
	}
	public List<Role> findRoleByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM Roles  ";
		
		List<Role> lsRole  = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsRole = entityManager.createNativeQuery(sqlStr + sqlWhere, Role.class)
							.getResultList();
			} else {
				lsRole = entityManager.createNativeQuery(sqlStr, Role.class)
						.getResultList();
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsRole;
	}
	public ArrayList<Role> findRoleUserByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM ref_master  ";
		
		ArrayList<Role> lsRole  = null;
		List<RefMaster> refM = new ArrayList<RefMaster>();
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				refM = (List<RefMaster>)entityManager.createNativeQuery(sqlStr + sqlWhere, RefMaster.class).getResultList();
				if (refM != null && refM.size() > 0)	{
					for (RefMaster rm : refM) {
						if(lsRole == null) {
							lsRole = new ArrayList<Role>();
						}
						lsRole.add(rm.getRole());
					}
				}
			} 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsRole;
	}
	//End Role
	//Start access menu
	public AccessMenu saveAccessMenuEnttiy(AccessMenu entity) 	throws Exception {
		entityManager.persist(entity);
		return entity;
	}
	public boolean updateAccessMenuEntity(AccessMenu entity) throws Exception {
		boolean result = false;
		try {
			entityManager.merge(entity);
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public AccessMenu findAccessMenuByID(int accessMenuid) throws Exception {
		return entityManager.find(AccessMenu.class, accessMenuid);
	}
	public ArrayList<AccessMenu> findAccessMenuByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM Access_Menu  ";
		
		ArrayList<AccessMenu> lsAccessMenu  = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsAccessMenu = (ArrayList<AccessMenu>)entityManager.createNativeQuery(sqlStr + sqlWhere, AccessMenu.class)
							.getResultList();
			} else {
				lsAccessMenu = (ArrayList<AccessMenu>)entityManager.createNativeQuery(sqlStr, AccessMenu.class)
						.getResultList();
			}
			if (lsAccessMenu != null && lsAccessMenu.size() > 0) {
				for (AccessMenu accm : lsAccessMenu) {
					Menu menu = findMenuByID(accm.getMenuid());
					accm.setMenu(menu);
					Groupmenu grp = findGroupmenuByID(accm.getGrpmenuid());
					accm.setGroupmenu(grp);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsAccessMenu;
	}
	public ArrayList<AccessMenu> findAccessUserByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM ref_master  ";
		
		String sqlStr1 = "SELECT * FROM Access_Menu  ";
		String sqlWhere1 = " WHERE ";
		ArrayList<AccessMenu> lsAccessMenu  = null;
		RefMaster refM = new RefMaster();
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				refM = (RefMaster)entityManager.createNativeQuery(sqlStr + sqlWhere, RefMaster.class).getSingleResult();
				if (refM != null && refM.getRmid() > 0)	{
					sqlWhere1 = sqlWhere1 + "rmid = " + refM.getRmid();
					lsAccessMenu = (ArrayList<AccessMenu>)entityManager.createNativeQuery(sqlStr1 + sqlWhere1, AccessMenu.class)
							.getResultList();
					if (lsAccessMenu != null && lsAccessMenu.size() > 0) {
						for (AccessMenu accm : lsAccessMenu) {
							Menu menu = findMenuByID(accm.getMenuid());
							accm.setMenu(menu);
						}
					}
				}
			} 
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsAccessMenu;
	}
	public boolean removeRefMaster(int rmid) {
		boolean result = false;
		try {
			RefMaster refM = entityManager.find(RefMaster.class, rmid);
			if (refM != null) {
				entityManager.remove(refM);
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
				e.printStackTrace();
		}
		return result;
	}
	public ArrayList<RefMaster> findRefMasterByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM ref_master  ";
		
		ArrayList<RefMaster> lsRefMaster  = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsRefMaster = (ArrayList<RefMaster>)entityManager.createNativeQuery(sqlStr + sqlWhere, RefMaster.class)
							.getResultList();
			} else {
				lsRefMaster = (ArrayList<RefMaster>)entityManager.createNativeQuery(sqlStr, RefMaster.class)
						.getResultList();
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsRefMaster;
	}
	//End access menu
	//Start full user
	
	public UsersHi saveUserHistory(String act,String json,int userid, int rmid) throws Exception {
		UsersHi usersh = new UsersHi(); 
		DateControl dateCon = new DateControl();
		try {
			usersh.setAct(act);
			usersh.setJsonStr(json);
			usersh.setCreateUserid(userid);
			usersh.setCreateDate(DateControl.toDaytoTimeStamp());
			usersh.setRmid(rmid);
			entityManager.persist(usersh);
		}catch (Exception e) {
			// TODO: handle exception
		}
		return usersh;
	}
	public User findUserByID(int userid) throws Exception {
		return entityManager.find(User.class, userid);
	}
	public boolean removeUserByID(int userid) throws Exception {
		boolean result = false;
		try {
			User user = entityManager.find(User.class, userid);
		
			if (user != null) {
				entityManager.remove(user);
				result = true;
			}
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public ArrayList<User> findUserByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM users  ";
		
		ArrayList<User> lsUser  = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsUser = (ArrayList<User>)entityManager.createNativeQuery(sqlStr + sqlWhere, User.class)
							.getResultList();
			} else {
				lsUser = (ArrayList<User>)entityManager.createNativeQuery(sqlStr, User.class)
						.getResultList();
			}
			for (User user : lsUser) {
				User tmpuser = findUserByID(user.getCreateUserid());
				if (tmpuser != null) {
					user.setUsercreate(tmpuser);
				}
			}
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsUser;
	}
	public FullUser saveFullUserEnttiy(FullUser entity) 	throws Exception {
		try {
			RefMaster refM = new RefMaster();
			if (entity.getUser().getUserid() > 0) {
								
				entityManager.merge(entity.getUser());
			} else {
				entityManager.persist(entity.getUser());
			}
			refM.setUser(entity.getUser());
			refM.setCreateUserid(entity.getUser().getCreateUserid());
			refM.setCreateDate(entity.getUser().getCreateDate());
			refM.setPartner(findPartnerByID(entity.getPartner().getPartnerid()));
			refM.setProduct(findProductByID(entity.getProduct().getProductid()));
			refM.setRole(findRoleByID(entity.getRole().getRoleid()));
			refM.setRmdesc(entity.getRefmaster().getRmdesc());
			entityManager.persist(refM);
			entity.setRefmaster(new RefMaster());
			entity.setRefmaster(refM);
			for (AccessMenu accM : entity.getAccessmenu()) {
				accM.setRmid(refM.getRmid());
				if (accM.getCreateDate() == null) {
					accM.setCreateDate(DateControl.toDaytoTimeStamp());
					
				}
				accM.setMenuid(accM.getMenu().getMenuid());
				accM.setGrpmenuid(accM.getGroupmenu().getGrpmenuid());
				entityManager.persist(accM);
			}
			
		} catch (Exception e) {
			// TODO: handle exception
			
			e.printStackTrace();
		}
		return entity;
	}
	public boolean updateFullUserEntity(FullUser entity) throws Exception {
		boolean result = false;
		try {
			RefMaster refM = entity.getRefmaster();
//			User user = entityManager.find(User.class, entity.getUser().getUserid());
//			user.setLogonad(entity.getUser().getLogonad());
//			user.setFname(entity.getUser().getFname());
//			user.setLname(entity.getUser().getLname());
//			user.setLicenseno(entity.getUser().getLicenseno());
//			user.setLicenseSDate(entity.getUser().getLicenseSDate());
//			user.setLicenseEDate(entity.getUser().getLicenseEDate());
//			user.setTypes(entity.getUser().getTypes());
//			user.setDetail(entity.getUser().getDetail());
//			user.setCreateDate(entity.getUser().getCreateDate());
//			user.setCreateUserid(entity.getUser().getCreateUserid());
//			user.setActive(entity.getUser().getActive());
			entityManager.merge(entity.getUser());
			refM.setPartner(findPartnerByID(entity.getPartner().getPartnerid()));
			refM.setProduct(findProductByID(entity.getProduct().getProductid()));
			refM.setRole(findRoleByID(entity.getRole().getRoleid()));
			refM.setRmdesc(entity.getRefmaster().getRmdesc());
			entityManager.merge(refM);
			for (AccessMenu accM : entity.getAccessmenu()) {
				accM.setRmid(refM.getRmid());
				accM.setCreateDate(DateControl.toDaytoTimeStamp());
				accM.setMenuid(accM.getMenu().getMenuid());
				accM.setGrpmenuid(accM.getGroupmenu().getGrpmenuid());
				entityManager.merge(accM);
			}
			result = true;
		} catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	public FullUser findFullUserByID(int rmid) throws Exception {
			FullUser fu = new FullUser();
			RefMaster refM = entityManager.find(RefMaster.class, rmid);
			//User user = entityManager.find(User.class, refM.getUser().getUserid());
			//Partner partner = entityManager.find(Partner.class, refM.getPartner().getPartnerid());
			//Product product = entityManager.find(Product.class, refM.getProduct().getProductid());
			//Role role = entityManager.find(Role.class, refM.getRole().getRoleid());
			String json = "{\"rmid\":[\"=\","+refM.getRmid()+"]}";
			ArrayList<AccessMenu> lsAccessMenu = findAccessMenuByCond(json);
			//AccessMenu[] arrAM = (AccessMenu[])lsAccessMenu.toArray();
			fu.setRefmaster(refM);
			fu.setUser(refM.getUser());
			fu.setPartner(refM.getPartner());
			fu.setProduct(refM.getProduct());
			fu.setRole(refM.getRole());
			fu.setAccessmenu(lsAccessMenu.toArray(new AccessMenu[lsAccessMenu.size()]));
		return fu;
	}
	public List<FullUser> findFullUserByCond(String json) throws Exception {
		String sqlStr = "SELECT * FROM PRII_CRM.dbo.V_FullUser  ";
		
		List<VfullUser> lsVfullUser  = null;
		List<FullUser> lsFullUser = null;
		try {
			if (json != null && json.length() > 1) {
				//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
				String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
				lsVfullUser = entityManager.createNativeQuery(sqlStr + sqlWhere, VfullUser.class)
							.getResultList();
			} else {
				lsVfullUser = entityManager.createNativeQuery(sqlStr, VfullUser.class)
						.getResultList();
			}
			if (lsVfullUser != null && lsVfullUser.size() > 0) {
				lsFullUser = new ArrayList<FullUser>();
				for(VfullUser vfu : lsVfullUser) {
					FullUser fu = new FullUser();
					RefMaster rm = new RefMaster();
					User user = new User();
					Partner partner = new Partner();
					Product product = new Product();
					Role role = new Role();
					rm.setRmid(vfu.getRmid());
					rm.setRmdesc(vfu.getRmdesc());
					user.setUserid(vfu.getUserid());
					user.setLogonid(vfu.getLogonid());
					user.setLogonad(vfu.getLogonad());
					user.setFname(vfu.getFname());
					user.setLname(vfu.getLname());
					user.setLicenseno(vfu.getLicenseno());
					user.setLicenseSDate(vfu.getLicenseSDate());
					user.setLicenseEDate(vfu.getLicenseEDate());
					user.setTypes(vfu.getTypes());
					user.setDetail(vfu.getDetail());
					user.setActive(vfu.getActive());
					user.setCreateDate(vfu.getCreateDate());
					user.setCreateUserid(vfu.getCreateUserid());
					user.setUsercreate(findUserByID(vfu.getCreateUserid()));
					
					partner.setPartnerid(vfu.getPartnerid());
					partner.setPartnerNameEn(vfu.getPartnerNameEn());
					partner.setPartnerNameTh(vfu.getPartnerNameTh());
					
					product.setProductid(vfu.getProductid());
					product.setProductNameEn(vfu.getProductNameEn());
					product.setProductNameTh(vfu.getProductNameTh());
					
					role.setRoleid(vfu.getRoleid());
					role.setRoleNameEn(vfu.getRoleNameEn());
					role.setRoleNameTh(vfu.getRoleNameTh());
					role.setRolecode(vfu.getRolecode());
					String jsonCond = "{\"RMID\":[\"=\","+rm.getRmid()+"]}";
					ArrayList<AccessMenu> lsAccessMenu  = findAccessMenuByCond(jsonCond);
					fu.setRefmaster(rm);
					fu.setUser(user);
					fu.setPartner(partner);
					fu.setProduct(product);
					fu.setRole(role);
					fu.setAccessmenu(lsAccessMenu.toArray(new AccessMenu[lsAccessMenu.size()]));
					
					lsFullUser.add(fu);
						
				}
			}
			
		} catch(Exception e) {
			e.printStackTrace();
		}
		return lsFullUser;
	}
	public boolean removeFullUser(RefMaster refmaster,int userid) throws Exception {
		boolean result = false;
		int refUserid = refmaster.getUser().getUserid();
		try {
			List<AccessMenu> accMenu = (List<AccessMenu>)entityManager.createNativeQuery("SELECT * FROM ACCESS_MENU WHERE RMID = " + refmaster.getRmid(),AccessMenu.class).getResultList();
			String json = JsonUtils.genJsonString(accMenu);
			UsersHi userh = saveUserHistory("DELETE", json, userid, refmaster.getRmid());
			if (userh != null && userh.getUserhisid() > 0) {
				
					int cnt = entityManager.createNativeQuery("DELETE FROM ACCESS_MENU WHERE RMID = " + refmaster.getRmid()).executeUpdate();
					//int cntU = entityManager.createNativeQuery("DELETE FROM USERS WHERE USERID = " + refmaster.getUser().getUserid()).executeUpdate();
					if (cnt >= 0 ) {
						if (entityManager.contains(refmaster)) {
							entityManager.remove(refmaster);
						} else {
							refmaster = entityManager.merge(refmaster);
							entityManager.remove(refmaster);
						}
						
						result = true;
						
					}
				}
			
		} catch (Exception e) {
			// TODO: handle exception
		
			e.printStackTrace();
		}
		return result;
	}
	//End full user
	//Start Template Role menu
		public TmpRoleMenu saveTmpRoleMenuEnttiy(TmpRoleMenu entity) 	throws Exception {
			entityManager.persist(entity);
			return entity;
		}
		public boolean updateTmpRoleMenuEntity(TmpRoleMenu entity) throws Exception {
			boolean result = false;
			try {
				entityManager.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return result;
		}
		
		public TmpRoleMenu findTmpRoleMenuByID(int tmpRoleMenuid) throws Exception {
			return entityManager.find(TmpRoleMenu.class, tmpRoleMenuid);
		}
		public List<TmpRoleMenu> findTmpRoleMenuByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM tmp_role_menu  ";
			
			List<TmpRoleMenu> lsTmpRoleMenu  = null;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsTmpRoleMenu = entityManager.createNativeQuery(sqlStr + sqlWhere, TmpRoleMenu.class)
								.getResultList();
				} else {
					lsTmpRoleMenu = entityManager.createNativeQuery(sqlStr, TmpRoleMenu.class)
							.getResultList();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsTmpRoleMenu;
		}
		public boolean deleteTmpRoleMenuEnttiy(int tmpRoleMenuid) 	throws Exception {
			boolean result = false;
			
			String sqlStr = "DELETE FROM tmp_role_menu WHERE trmid = ?1";
			try {
				Query qry = entityManager.createNativeQuery(sqlStr);
				qry.setParameter(1, tmpRoleMenuid);
				int i = qry.executeUpdate();
				if (i > 0) {
					result = true;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return result;
			
		}
		//End Template Role menu
		//Start Group menu
		public Groupmenu saveGroupmenuEnttiy(Groupmenu entity) 	throws Exception {
			entityManager.persist(entity);
			return entity;
		}
		public boolean updateGroupmenuEntity(Groupmenu entity) throws Exception {
			boolean result = false;
			try {
				entityManager.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return result;
		}
		public Groupmenu findGroupmenuByID(int grpmenuid) throws Exception {
			return entityManager.find(Groupmenu.class, grpmenuid);
		}
		public List<Groupmenu> findGroupmenuByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Groupmenu  ";
			
			List<Groupmenu> lsGroupmenu  = null;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsGroupmenu = entityManager.createNativeQuery(sqlStr + sqlWhere, Groupmenu.class)
								.getResultList();
				} else {
					lsGroupmenu = entityManager.createNativeQuery(sqlStr, Groupmenu.class)
							.getResultList();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsGroupmenu;
		}
		//End Group menu
		//Start title
		public Title saveTitleEnttiy(Title entity) 	throws Exception {
			entityManager.persist(entity);
			return entity;
		}
		public boolean updateTitleEntity(Title entity) throws Exception {
			boolean result = false;
			try {
				entityManager.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return result;
		}
		public Title findTitleByID(int titleid) throws Exception {
			return entityManager.find(Title.class, titleid);
		}
		public List<Title> findTitleByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Titles  ";
			
			List<Title> lsTitle  = null;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsTitle = entityManager.createNativeQuery(sqlStr + sqlWhere, Title.class)
								.getResultList();
				} else {
					lsTitle = entityManager.createNativeQuery(sqlStr, Title.class)
							.getResultList();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsTitle;
		}
		//End Title
		//Start Gender
		public Gender saveGenderEnttiy(Gender entity) 	throws Exception {
			entityManager.persist(entity);
			return entity;
		}
		public boolean updateGenderEntity(Gender entity) throws Exception {
			boolean result = false;
			try {
				entityManager.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
					
			return result;
		}
		public Gender findGenderByID(int genderid) throws Exception {
			return entityManager.find(Gender.class, genderid);
		}
		public List<Gender> findGenderByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Gender  ";
					
			List<Gender> lsGender  = null;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsGender = entityManager.createNativeQuery(sqlStr + sqlWhere, Gender.class)
								.getResultList();
				} else {
					lsGender = entityManager.createNativeQuery(sqlStr, Gender.class)
								.getResultList();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsGender;
		}
		//End Gender
		//Start Province
		public Province saveProvinceEnttiy(Province entity) 	throws Exception {
			entityManager.persist(entity);
			return entity;
		}
		public boolean updateProvinceEntity(Province entity) throws Exception {
			boolean result = false;
			try {
				entityManager.merge(entity);
				result = true;
			} catch (Exception e) {
				// TODO: handle exception
				e.printStackTrace();
			}
			
			return result;
		}
		public Province findProvinceByID(long pid) throws Exception {
			return entityManager.find(Province.class, pid);
		}
		public List<Province> findProvinceByCond(String json) throws Exception {
			String sqlStr = "SELECT * FROM Province  ";
			
			List<Province> lsProvince  = null;
			try {
				if (json != null && json.length() > 1) {
					//String sqlWhere = " WHERE " + JsonUtils.mapJsonCondition(json);
					String sqlWhere = " WHERE " + JsonUtils.mapJsonCondNew2(json);
					lsProvince = entityManager.createNativeQuery(sqlStr + sqlWhere, Province.class)
								.getResultList();
				} else {
					lsProvince = entityManager.createNativeQuery(sqlStr, Province.class)
							.getResultList();
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return lsProvince;
		}
		public boolean deleteProvinceEnttiy(long pid) 	throws Exception {
			boolean result = false;
			
			String sqlStr = "DELETE FROM Province WHERE mqid = ?1";
			try {
				Query qry = entityManager.createNativeQuery(sqlStr);
				qry.setParameter(1, pid);
				int i = qry.executeUpdate();
				if (i > 0) {
					result = true;
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
			return result;
		}
		//End Province
}

package th.priisoft.crm.spring.entity.prii.crmdta;

import java.io.Serializable;
import java.util.Arrays;

public class FullUser implements Serializable{

	
	private static final long serialVersionUID = 1L;

	private RefMaster refmaster;
	private User user;
	private Partner partner;
	private Product product;
	private Role role;
	private AccessMenu[] accessmenu;
	
	public RefMaster getRefmaster() {
		return refmaster;
	}
	public void setRefmaster(RefMaster refmaster) {
		this.refmaster = refmaster;
	}
	public User getUser() {
		return user;
	}
	public void setUser(User user) {
		this.user = user;
	}
	public Partner getPartner() {
		return partner;
	}
	public void setPartner(Partner partner) {
		this.partner = partner;
	}
	public Product getProduct() {
		return product;
	}
	public void setProduct(Product product) {
		this.product = product;
	}
	public Role getRole() {
		return role;
	}
	public void setRole(Role role) {
		this.role = role;
	}
	public AccessMenu[] getAccessmenu() {
		return accessmenu;
	}
	public void setAccessmenu(AccessMenu[] accessmenu) {
		this.accessmenu = accessmenu;
	}
	@Override
	public String toString() {
		return "FullUser [refmaster=" + refmaster + ", user=" + user + ", partner=" + partner + ", product=" + product
				+ ", role=" + role + ", accessmenu=" + Arrays.toString(accessmenu) + "]";
	}
	
	
}

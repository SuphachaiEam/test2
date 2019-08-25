package th.priisoft.crm.spring.entity.prii.padta;

import java.io.Serializable;
import javax.persistence.*;
import java.math.BigDecimal;



@Entity
@Table(name="client")
@NamedQuery(name="Client.findAll", query="SELECT c FROM Client c")
public class Client implements Serializable {
	private static final long serialVersionUID = 1L;

	@Id
	@GeneratedValue(strategy=GenerationType.IDENTITY)
	private long clinetid;

	private String address1;

	private String address2;

	private String address3;

	private int age;

	private long appid;

	private String dob;

	private String email;

	private String extraincome;

	private String fax;

	private BigDecimal height;

	private String homephone;

	private String homephoneext;

	private String idcard;

	private String mainincome;

	private String mobile;

	private String mobileext;

	private String name;

	private String nationality;

	private String occupation;

	private String officephone;

	private String officephoneext;

	private String postcode;

	private String province;

	private String sex;

	private String surname;

	private String title;

	private BigDecimal weight;

	@Transient
	private Beneficiary[] beneficiary;
	
	public Client() {
	}

	public long getClinetid() {
		return this.clinetid;
	}

	public void setClinetid(long clinetid) {
		this.clinetid = clinetid;
	}

	public String getAddress1() {
		return this.address1;
	}

	public void setAddress1(String address1) {
		this.address1 = address1;
	}

	public String getAddress2() {
		return this.address2;
	}

	public void setAddress2(String address2) {
		this.address2 = address2;
	}

	public String getAddress3() {
		return this.address3;
	}

	public void setAddress3(String address3) {
		this.address3 = address3;
	}

	public int getAge() {
		return this.age;
	}

	public void setAge(int age) {
		this.age = age;
	}

	public long getAppid() {
		return this.appid;
	}

	public void setAppid(long appid) {
		this.appid = appid;
	}

	public String getDob() {
		return this.dob;
	}

	public void setDob(String dob) {
		this.dob = dob;
	}

	public String getEmail() {
		return this.email;
	}

	public void setEmail(String email) {
		this.email = email;
	}

	public String getExtraincome() {
		return this.extraincome;
	}

	public void setExtraincome(String extraincome) {
		this.extraincome = extraincome;
	}

	public String getFax() {
		return this.fax;
	}

	public void setFax(String fax) {
		this.fax = fax;
	}

	public BigDecimal getHeight() {
		return this.height;
	}

	public void setHeight(BigDecimal height) {
		this.height = height;
	}

	public String getHomephone() {
		return this.homephone;
	}

	public void setHomephone(String homephone) {
		this.homephone = homephone;
	}

	public String getHomephoneext() {
		return this.homephoneext;
	}

	public void setHomephoneext(String homephoneext) {
		this.homephoneext = homephoneext;
	}

	public String getIdcard() {
		return this.idcard;
	}

	public void setIdcard(String idcard) {
		this.idcard = idcard;
	}

	public String getMainincome() {
		return this.mainincome;
	}

	public void setMainincome(String mainincome) {
		this.mainincome = mainincome;
	}

	public String getMobile() {
		return this.mobile;
	}

	public void setMobile(String mobile) {
		this.mobile = mobile;
	}

	public String getMobileext() {
		return this.mobileext;
	}

	public void setMobileext(String mobileext) {
		this.mobileext = mobileext;
	}

	public String getName() {
		return this.name;
	}

	public void setName(String name) {
		this.name = name;
	}

	public String getNationality() {
		return this.nationality;
	}

	public void setNationality(String nationality) {
		this.nationality = nationality;
	}

	public String getOccupation() {
		return this.occupation;
	}

	public void setOccupation(String occupation) {
		this.occupation = occupation;
	}

	public String getOfficephone() {
		return this.officephone;
	}

	public void setOfficephone(String officephone) {
		this.officephone = officephone;
	}

	public String getOfficephoneext() {
		return this.officephoneext;
	}

	public void setOfficephoneext(String officephoneext) {
		this.officephoneext = officephoneext;
	}

	public String getPostcode() {
		return this.postcode;
	}

	public void setPostcode(String postcode) {
		this.postcode = postcode;
	}

	public String getProvince() {
		return this.province;
	}

	public void setProvince(String province) {
		this.province = province;
	}

	public String getSex() {
		return this.sex;
	}

	public void setSex(String sex) {
		this.sex = sex;
	}

	public String getSurname() {
		return this.surname;
	}

	public void setSurname(String surname) {
		this.surname = surname;
	}

	public String getTitle() {
		return this.title;
	}

	public void setTitle(String title) {
		this.title = title;
	}

	public BigDecimal getWeight() {
		return this.weight;
	}

	public void setWeight(BigDecimal weight) {
		this.weight = weight;
	}

	public Beneficiary[] getBeneficiary() {
		return beneficiary;
	}

	public void setBeneficiary(Beneficiary[] beneficiary) {
		this.beneficiary = beneficiary;
	}

}
package th.priisoft.crm.common.model;

public class AfgUploadReq {
	String siteid;
	String filestring; //byte to base64
	String fileName;
	String uploaddirectory;
	String containerid;
	public String getSiteid() {
		return siteid;
	}
	public void setSiteid(String siteid) {
		this.siteid = siteid;
	}
	public String getFilestring() {
		return filestring;
	}
	public void setFilestring(String filestring) {
		this.filestring = filestring;
	}
	public String getFileName() {
		return fileName;
	}
	public void setFileName(String fileName) {
		this.fileName = fileName;
	}
	public String getUploaddirectory() {
		return uploaddirectory;
	}
	public void setUploaddirectory(String uploaddirectory) {
		this.uploaddirectory = uploaddirectory;
	}
	public String getContainerid() {
		return containerid;
	}
	public void setContainerid(String containerid) {
		this.containerid = containerid;
	}
}

package th.priisoft.crm.spring.service.common;

import th.priisoft.crm.common.model.AfgUploadReq;
import th.priisoft.crm.common.restfull.ResponseObject;

public interface AfresgoService {
	public ResponseObject getDoc(String docid) throws Exception;
	public ResponseObject uploadDoc(AfgUploadReq afUploadReq) throws Exception;
}

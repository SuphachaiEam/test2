package th.priisoft.crm.common.constant;

public class MessageConstants {
	public final static String I0001 = "I0001";	//บันทึกข้อมูลเรียบร้อย ${1}
	public final static String I0002 = "I0002";	//แก้ไขข้อมูลเรียบร้อย ${1}
	
	public final static String E0001 = "E0001";	//พบปัญหาระหว่างการทำงาน ${1}
	public final static String E0002 = "E0002";	//ข้อมูลนี้มีในระบบแล้ว ${1} 
	// for payment
	public static class Payment {
		public final static String I1101 = "I1101";	//บิลนี้ได้ถูกวางบิลไปแล้ว ${1}/${2}
		public final static String I1102 = "I1102";	//Reserve นี้ทำจ่ายไปแล้ว ${1}/${2}
	}
	
}

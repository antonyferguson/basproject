package com.ejda.constant;

public class EJDAConstant {

	public interface SESSION_NAME {
		public final String PAGE = "PAGE";
	}
	
	public interface PAGE {
		public final String INDEX_PAGE = "index.jsp";
		public final String INDEX2_PAGE = "index2.jsp";
	}
	
	public interface SQL{
		public final String TRAN_LOG_SQL = "SELECT L.TRANS_ID, L.TRANS_ACTION, L.DESCRIPTION, L.IP_ADDRESS, TO_CHAR(L.TRANS_DATE,'YYYY-MM-DD') AS TRANS_DATE, L.TRANS_BY, U.FIRST_NAME, U.LAST_NAME, U.DEPARTMENT, U.USER_NAME FROM JDA_TRANSACTION_LOG L  JOIN JDA_USER U ON U.USER_NAME = L.TRANS_BY ";
		public final String ROLE_SQL = "SELECT ROLE_ID, ROLE_NAME FROM JDA_ROLE";
		public final String USER__SCREEN_SQL = "SELECT JDA_ID, IV_USER,PASSWORD, USER_NAME, FIRST_NAME, LAST_NAME, DEPARTMENT, USER_STATUS,TO_CHAR(EFFECTIVE_DATE,'YYYY-MM-DD') AS EFFECTIVE_DATE, "+
												"TO_CHAR(EXPIRY_DATE,'YYYY-MM-DD') AS EXPIRY_DATE,TO_CHAR(CREATE_DATE,'YYYY-MM-DD') AS CREATE_DATE FROM JDA_USER ";
		
		public final String FORM1_TABLE1_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM1_CTRL WHERE STATUS = 'D'";
		public final String FORM1_TABLE2_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM1_CTRL WHERE STATUS = 'A'";
		public final String FORM1_TABLE3_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM1_CTRL WHERE STATUS = 'S'";
		public final String FORM1_TABLE4_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM1_CTRL WHERE STATUS = 'P'";
		public final String FORM3_TABLE1_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM3_CTRL WHERE STATUS = 'D'";
		public final String FORM3_TABLE2_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM3_CTRL WHERE STATUS = 'A'";
		public final String FORM3_TABLE3_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM3_CTRL WHERE STATUS = 'S'";
		public final String FORM3_TABLE4_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM3_CTRL WHERE STATUS = 'P'";
		public final String FORM4_TABLE1_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM4_CTRL WHERE STATUS = 'D'";
		public final String FORM4_TABLE2_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM4_CTRL WHERE STATUS = 'A'";
		public final String FORM4_TABLE3_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM4_CTRL WHERE STATUS = 'S'";
		public final String FORM4_TABLE4_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM4_CTRL WHERE STATUS = 'P'";
		
		public final String FORM2_TABLE1_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM2_CTRL WHERE STATUS = 'D'";
		public final String FORM2_TABLE2_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM2_CTRL WHERE STATUS = 'A'";
		public final String FORM2_TABLE3_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM2_CTRL WHERE STATUS = 'S'";
		public final String FORM2_TABLE4_SQL ="SELECT FORM_NO, FORM_NAME, STATUS, UPDATE_BY FROM JDA_FORM2_CTRL WHERE STATUS = 'P'";
		
		
		public final String FORM_T_DOC_1 = "SELECT DOC_ID, COUNTRY_ID, JDA_TYPE, DOC_STATUS, INVOICE_NO, CONSIGNOR_CODE, CONSIGNOR_NAME, "
			+ "CONSIGNOR_ADDRESS, CONSIGNEE_CODE, CONSIGNEE_NAME, CONSIGNEE_ADDRESS, AUTHORAGENT_CODE, AUTHORAGENT_NAME, "
			+ "AUTHORAGENT_ADDRESS, MODE_TRANS, TRANS_OTHER, DATE_IMPORT, TRANS_DETAIL, PORTIMPORT_CODE, PORTIMPORT_DESC, "
			+ "PORTLOAD_CODE, PORTLOAD_DESC, VIA_CODE, VIA_DESC, DATE_RECEIPT, REF_NO, REGIS_NO, CUS_NAME_CODE, CUS_NAME_DESC, "
			+ "MANIFEST_NO, DUTY_TAX_RECEIPT_DATE, DUTY_TAX_RECEIPT_DESC, IMPORT_PERMIT_NO, EXCHG_CTRL_REF, SPECIAL_TREATMENT, "
			+ "COUNTRY_ORIGIN_CODE, COUNTRY_ORIGIN_DESC, COUNTRY_FINAL_CODE, COUNTRY_FINAL_DESC, BILL_NO, TERM_PAYMENT, CUR_CODE, "
			+ "RECEIVED_AMOUNT, EXCHGRATE_ID, EQUIVALENT, GOOD_PAYMENT_CODE, GOOD_PAYMENT_DESC, COUNTRY_OF_GOOD, FOB_VALUE, "
			+ "INSURANCE, FREIGHT, CIF_VALUE, GROSS_WEIGHT, MEASUREMENT, OTHER_CHARG, DECLARANT_NAME, ID_CARD_NO, STATUS, "
			+ "CERIFY, CUS_REMOVAL, TAX_TOTAL, OTHER_CHARG2, PAYABLE_AMOUNT, MANUALSCRIPT_RECERPT, VESSEL_VALUE, INSTRUCT_EXAM, "
			+ "RESULT_EXAM, FOR_OTHER_USE, CREATE_DATE, CREATE_BY, UPDATE_DATE, UPDATE_BY "
			+ " ,MOVEMENT_PEMIT_NO ,EXPIRE_DATE ,SECURITY_REF_NO ,SECURITY_AMT ,RECEIVE_AMT " 
			+ " ,BILL_OF_LADING ,PROPER_OFFICE ,REQUEST_APPROVED ,CERTIFIED "
			+ "FROM JDA_FORM_T_DOC ";
			
	}
}

package com.ejda.action;

import java.util.Vector;

import org.apache.log4j.Logger;

import com.ejda.constant.EJDAConstant;
import com.ejda.sessionBean.Form3Bean;
import com.ejda.util.EJDAUtil;
import com.tcd.ejda.dao.CacheDataDAO;
import com.tcd.ejda.dao.CacheDataDAOImpl;
import com.tcd.ejda.dao.Form1DAO;
import com.tcd.ejda.dao.Form1DAOImpl;
import com.tcd.ejda.dao.Form3DAO;
import com.tcd.ejda.dao.Form3DAOImpl;
import com.tcd.ejda.model.Form1Model;
import com.tcd.ejda.model.Form3Model;
import com.tcd.ejda.model.TransactionLogModel;
import com.tcd.ejda.model.ValueListModel;

public class EJDAM024Action extends AbstractAction {

	private Logger log = Logger.getLogger(EJDAM024Action.class);
	private Form3Bean form3Bean;
	
	public Form3Bean getForm3Bean() {
		Form3Bean form3Bean = (Form3Bean)getRequest().getSession().getAttribute("form3Bean");
		if (null == form3Bean){
			form3Bean = new Form3Bean();
		}
		return form3Bean;
	}

	public void setForm3Bean(Form3Bean form3Bean) {
		getRequest().getSession().setAttribute("form3Bean", form3Bean);
	}
	
	@Override
	public void clearSessionNotUsed() {
		// TODO Auto-generated method stub

	}

	@Override
	public void init() {
		/** EJDA Form no 3****/
		Vector unitVt = new Vector();
		log.debug("*********** EJDAM012Action ***********");
		
		
		form3Bean = getForm3Bean();
		form3Bean.setForm3Vt(new Vector<Form1Model>());
		form3Bean.setForm3ModelSP(new Form1Model());
		ValueListModel valueListM = new ValueListModel();
		valueListM.setReturnModel("Form1Model");
		form3Bean.setValueListM(valueListM);
		try{
			CacheDataDAO dao = new CacheDataDAOImpl();
			unitVt = dao.LoadUnit();
		}catch (Exception e) {
			e.printStackTrace();
		}
		form3Bean.setUnitVt(unitVt);
		setForm3Bean(form3Bean);
	}

	@Override
	public boolean methodAction(String ejdaMethod) {
		if(ejdaMethod.equalsIgnoreCase("doSearch")){
			return doSearch();
		}else if (ejdaMethod.equalsIgnoreCase("doAdd")){
			return doAdd();
		}else if (ejdaMethod.equalsIgnoreCase("doSubmitButton")){
			return doSubmitButton();
		}else if (ejdaMethod.equalsIgnoreCase("doSaveButton")){
			return doSaveButton();
		}else if (ejdaMethod.equalsIgnoreCase("doUpdate")){
			return doUpdate();
		}
		return false;
	}

	@Override
	public boolean validate() {
		// TODO Auto-generated method stub
		return false;
	}
	
	public boolean doAdd(){
		log.debug("*********** doChangePage ***********");
		getForm3Bean().setActionName("EJDAM012");
		return true;
	}
	
	private boolean doSubmitButton() {
		boolean result = false;
		String iuser = (String) getRequest().getSession().getAttribute("iuser");
		String formNo = (String) getRequest().getSession().getAttribute("form_no");
		String ipAddress = getRequest().getRemoteAddr();
		if (null==iuser || "".equals(iuser)){
			iuser = "system";
		}
//		Form3Model form3 = new Form3Model();
//		form3.setForm_name("FN_" + iuser);
//		form3.setForm_status("C");
//		form3.setUpdate_by(iuser);
//		form3.setForm_no(formNo);
		try{
			EJDAM010Action ejdam010Action = new EJDAM010Action();
			ejdam010Action.setRequest(getRequest()); 
			Form1Model form1 = ejdam010Action.setValueModel("3","C",iuser);
			log.debug("Form1Model >> " + form1);
		
			Form1DAO dao = new Form1DAOImpl();
			dao.UpdateFromTable(form1);
			
//			Form3DAO dao = new Form3DAOImpl();
//			dao.UpdateFrom3Table(form3);
			TransactionLogModel transactionLogModel = new TransactionLogModel() ;
			EJDAUtil ejda = new EJDAUtil();
			transactionLogModel.setMenuId("M024");
			transactionLogModel.setTranAction("ADD");
			transactionLogModel.setDescription("Update EJDA Table 4 Form 3");
			transactionLogModel.setIpAddress(ipAddress);
			transactionLogModel.setTranBy(iuser);
			ejda.insertTranLog(transactionLogModel);
			
			getRequest().getSession().setAttribute("responseMessage", "Submit Form 3 Successfully.");
			ValueListModel valueListM = new ValueListModel();
			valueListM.setReturnModel("Form1Model");
			getForm3Bean().setValueListM(valueListM);
			result = doSearch();
			
			log.debug("result = "+result);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	public boolean doSearch(){
		log.debug("*********** doSearch ***********");
//		log.debug("ejdaMethod = "+getRequest().getParameter("ejdaMethod"));
		boolean result = false;
		setCriteriaPameter();
		form3Bean = getForm3Bean();
		ValueListModel valueListM = new ValueListModel();
		ValueListAction valueListA = new ValueListAction();
		log.debug("getRequest().getParameter(Page)"+getRequest().getParameter("Page"));
		try{
			Vector tranLogVt = new Vector();
			valueListM = form3Bean.getValueListM();
			valueListM.setSQL(this.setSQL(form3Bean.form3ModelSP));
			valueListM.setParameters(getValueListParameters());
			valueListM.setPage(getRequest().getParameter("page"));
			valueListM.setItemsPerPage(Integer.parseInt(getRequest().getParameter("volumePerPage")));
			
			form3Bean.setValueListM(valueListA.doSearch(valueListM));
			form3Bean.setForm3Vt(form3Bean.getValueListM().getResult());
			form3Bean.setActionName("EJDAM024");
			log.debug("form3Bean = " + form3Bean.getForm3Vt().size());
			log.debug("tranLogBean.getValueListM().getCount() = "+form3Bean.getValueListM().getCount());
			log.debug("form3Bean setActionName = " + form3Bean.getActionName());
			getRequest().getSession().removeAttribute("VALUE_LIST");
			setForm3Bean(form3Bean);
			result = true;
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		
		return result;
	}
	
	private Vector getValueListParameters() {
		Vector parameters = new Vector();
		Form1Model form3 = getForm3Bean().getForm3ModelSP();
		if (!"".equals(form3.getForm_name())){
			log.debug("Form Name = "+form3.getForm_name());
			parameters.add(form3.getForm_name());
		}
		log.info("parameters.size() = "+parameters.size());
		return parameters;
	}
	
	private void setCriteriaPameter(){
		
		Form1Model form3 = new Form1Model();
		form3.setForm_name(getRequest().getParameter("txtFormName"));
		
		getForm3Bean().setForm3ModelSP(form3);
	}
	
	private String setSQL(Form1Model form3Cri){
		StringBuffer sql = new StringBuffer();
		StringBuffer sql1 = new StringBuffer();
		String sqlCommand ="";
		String sqlWhere="";
		try{
			sql.append(EJDAConstant.SQL.FORM_T_DOC_1);
			sql.append("  WHERE JDA_TYPE = '3' AND DOC_STATUS = 'P' ");
//			if (sql.indexOf("WHERE") != -1){
//				sqlWhere = sql.substring(sql.indexOf("WHERE"),sql.length());
//				sqlCommand = sql.substring(0, sql.lastIndexOf("WHERE"));
//			}
//			if (!"".equals(form3Cri.getForm_name())){
//				//sql.append(" WHERE ");
//				sqlWhere += " FORM_NAME = ? AND ";
//				
//			}
			
			log.debug("sqlWhere >> " + sqlWhere);
			log.debug("sqlCommand >> " + sqlCommand);
			
			sql1.append(sqlCommand + " " + sqlWhere);
			
			log.debug("sql >> " + sql1.toString());
		}catch(Exception e){
			e.printStackTrace();
		}
		
		sql1 = removeWasteSQL(sql1);
		return sql.toString();
	}
	
	private boolean doSaveButton() {
		boolean result = false;
		String iuser = (String) getRequest().getSession().getAttribute("iuser");
		if (null==iuser || "".equals(iuser)){
			iuser = "system";
		}
		Form3Model form3 = new Form3Model();
		form3.setForm_name("FN_" + iuser);
		form3.setForm_status("D");
		form3.setUpdate_by(iuser);
		try{
			Form3DAO dao = new Form3DAOImpl();
			dao.saveFrom3Table1(form3);
			result = doSearch();
			
			log.debug("result = "+result);
		}catch (Exception e) {
			// TODO: handle exception
			e.printStackTrace();
		}
		return result;
	}
	
	private boolean doUpdate() {
		form3Bean = getForm3Bean();
		String docId = (String)getRequest().getParameter("doc_id");
		log.debug("docId = "+docId);
//		getRequest().getSession().setAttribute("form_no", form_no);
		try{
			Form1DAO dao = new Form1DAOImpl();
			form3Bean.setForm3ModelSP(dao.searchFormModel(docId));
			form3Bean.setDetail1MVt(dao.searchFormDetail1Model(docId));
			form3Bean.setDetail2MVt(dao.searchFormDetail2Model(docId));
			form3Bean.setDocAttachMVt(dao.searchFormDocAttachModel(docId));
			log.debug("form3Bean = "+form3Bean.getForm3ModelSP().getMovementPemitNo());
			log.debug("form3Bean.getDetail1MVt().size() = "+form3Bean.getDetail1MVt().size());
			log.debug("form3Bean.getDetail2MVt().size() = "+form3Bean.getDetail2MVt().size());
			log.debug("form3Bean.getDocAttachMVt().size() = "+form3Bean.getDocAttachMVt().size());
			
		}catch (Exception e) {
			e.printStackTrace();
		}
		setForm3Bean(form3Bean);
		return true;
	}
}

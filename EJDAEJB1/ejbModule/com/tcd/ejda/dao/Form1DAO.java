package com.tcd.ejda.dao;

import java.sql.Connection;
import java.sql.SQLException;
import java.util.Vector;

import com.tcd.ejda.model.Form1Model;
import com.tcd.ejda.model.FormDetail1Model;
import com.tcd.ejda.model.FormDetail2Model;
import com.tcd.ejda.model.FormDocAttachModel;

public interface Form1DAO {
	public void saveFrom1Table1(Form1Model form1) throws SQLException;
	public boolean UpdateFrom1Table(Form1Model form1) throws SQLException;
	public void saveFromEJDA(Form1Model form, Vector detail1, Vector detail2, Vector doc) throws SQLException;
	public boolean UpdateFromTable(Form1Model form1) throws SQLException;
	public Form1Model searchFormModel(String docId) throws SQLException;
	public Vector<FormDetail1Model> searchFormDetail1Model(String docId) throws SQLException;
	public Vector<FormDetail2Model> searchFormDetail2Model(String docId) throws SQLException;
	public Vector<FormDocAttachModel> searchFormDocAttachModel(String docId) throws SQLException;
	
	public boolean UpdateFromTable(Form1Model form1, Vector detail1, Vector detail2, Vector doc) throws SQLException;
	public boolean UpdatePayment(String doc_id, String flag_payment, String user_name )throws SQLException;
	public boolean UpdateRemark(String doc_id,String doc_status, String remark, String user_name)throws SQLException;
}

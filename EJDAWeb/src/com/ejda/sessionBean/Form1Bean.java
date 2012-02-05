package com.ejda.sessionBean;

import java.util.Vector;

import com.tcd.ejda.model.Form1Model;
import com.tcd.ejda.model.FormDetail1Model;
import com.tcd.ejda.model.FormDetail2Model;
import com.tcd.ejda.model.FormDocAttachModel;

public class Form1Bean extends AbstractBean {
	
	public Form1Model form1ModelSP;
	public Form1Model form1ModelCri;
	public Vector form1Vt;
	public String actionName;
	public FormDetail1Model detail1ModelSP;
	public FormDetail2Model detail2ModelSP;
	public FormDocAttachModel docAttachModelSP;
	
	public Vector detail1MVt;
	public Vector detail2MVt;
	public Vector docAttachMVt;
	public Vector unitVt;
	public Vector tanliCodeVt;
	public Vector dutyRateVt;
	public Vector countryOriginVt;
	public Vector formConfigVt;
	
	public Vector getFormConfigVt() {
		return formConfigVt;
	}
	public void setFormConfigVt(Vector formConfigVt) {
		this.formConfigVt = formConfigVt;
	}
	public Vector getDocAttachMVt() {
		return docAttachMVt;
	}
	public void setDocAttachMVt(Vector docAttachMVt) {
		this.docAttachMVt = docAttachMVt;
	}
	public Vector getDetail1MVt() {
		return detail1MVt;
	}
	public void setDetail1MVt(Vector detail1mVt) {
		detail1MVt = detail1mVt;
	}
	public Vector getDetail2MVt() {
		return detail2MVt;
	}
	public void setDetail2MVt(Vector detail2mVt) {
		detail2MVt = detail2mVt;
	}
	
	
	public Vector getCountryOriginVt() {
		return countryOriginVt;
	}
	public void setCountryOriginVt(Vector countryOriginVt) {
		this.countryOriginVt = countryOriginVt;
	}
	public Vector getDutyRateVt() {
		return dutyRateVt;
	}
	public void setDutyRateVt(Vector dutyRateVt) {
		this.dutyRateVt = dutyRateVt;
	}
	public Vector getTanliCodeVt() {
		return tanliCodeVt;
	}
	public void setTanliCodeVt(Vector tanliCodeVt) {
		this.tanliCodeVt = tanliCodeVt;
	}
	public FormDocAttachModel getDocAttachModelSP() {
		return docAttachModelSP;
	}
	public void setDocAttachModelSP(FormDocAttachModel docAttachModelSP) {
		this.docAttachModelSP = docAttachModelSP;
	}
	public String getActionName() {
		return actionName;
	}
	public void setActionName(String actionName) {
		this.actionName = actionName;
	}
	public Form1Model getForm1ModelSP() {
		return form1ModelSP;
	}
	public void setForm1ModelSP(Form1Model form1ModelSP) {
		this.form1ModelSP = form1ModelSP;
	}
	public Vector getForm1Vt() {
		return form1Vt;
	}
	public void setForm1Vt(Vector form1Vt) {
		this.form1Vt = form1Vt;
	}
	public FormDetail1Model getDetail1ModelSP() {
		return detail1ModelSP;
	}
	public void setDetail1ModelSP(FormDetail1Model detail1ModelSP) {
		this.detail1ModelSP = detail1ModelSP;
	}
	public FormDetail2Model getDetail2ModelSP() {
		return detail2ModelSP;
	}
	public void setDetail2ModelSP(FormDetail2Model detail2ModelSP) {
		this.detail2ModelSP = detail2ModelSP;
	}
	public Vector getUnitVt() {
		return unitVt;
	}
	public void setUnitVt(Vector unitVt) {
		this.unitVt = unitVt;
	}
	public Form1Model getForm1ModelCri() {
		return form1ModelCri;
	}
	public void setForm1ModelCri(Form1Model form1ModelCri) {
		this.form1ModelCri = form1ModelCri;
	}
	
	
}

package com.sabpaisaPg_integration.entities;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.GeneratedValue;
import javax.persistence.GenerationType;
import javax.persistence.Id;
import javax.persistence.Table;
@Entity
@Table(name="sabpaisa_pg_data")
public class sabpaisaPgEntity {
	@Id
	@GeneratedValue(strategy=GenerationType.AUTO)
	@Column(name = "payer_name", length = 100)

	private String payerName;
	@Column(name = "payer_email", length = 100)

	private String payerEmail;
	@Column(name = "payer_mob", length = 20)

	private Integer payerMobile;
	@Column(name = "clientTxn_id", length = 20)

	private String clientTxnId;
	@Column(name = "amount", length = 50)

	private String amount;
	@Column(name = "client_code", length = 20)
	private String clientCode;
	@Column(name = "paid_amount", length = 50)

	private String paidAmount;
	@Column(name = "payer_mode", length = 20)

	private String payerMode;
	@Column(name = "bank_name", length = 20)

	private String bankName;
	@Column(name = "status", length = 10, columnDefinition = "varchar(255) default 'NA'")
	private String status;
	@Column(name = "status_code", length = 20)

	private String statusCode;
	@Column(name = "sabpaisaTxn_id", length = 20)

	private String sabpaisaTxnId;
	@Column(name = "mcc", length = 20)

	private Integer mcc;
	@Column(name = "trans_Date", length = 20)

	private Integer transDate;

	@Column(name = "udf1", columnDefinition = "varchar(255) default 'NA'")

	private String udf1;
	@Column(name = "udf2", columnDefinition = "varchar(255) default 'NA'")

	private String udf2;
	@Column(name = "udf3", columnDefinition = "varchar(255) default 'NA'")

	private String udf3;
	@Column(name = "udf4", columnDefinition = "varchar(255) default 'NA'")

	private String udf4;
	@Column(name = "udf5", columnDefinition = "varchar(255) default 'NA'")

	private String udf5;
	@Column(name = "udf6", columnDefinition = "varchar(255) default 'NA'")

	private String udf6;
	@Column(name = "udf7", columnDefinition = "varchar(255) default 'NA'")

	private String udf7;
	@Column(name = "udf8", columnDefinition = "varchar(255) default 'NA'")

	private String udf8;
	@Column(name = "udf9", columnDefinition = "varchar(255) default 'NA'")

	private String udf9;
	@Column(name = "udf10", columnDefinition = "varchar(255) default 'NA'")

	private String udf10;
	public String getPayerName() {
		return payerName;
	}
	public void setPayerName(String payerName) {
		this.payerName = payerName;
	}
	public String getPayerEmail() {
		return payerEmail;
	}
	public void setPayerEmail(String payerEmail) {
		this.payerEmail = payerEmail;
	}
	public Integer getPayerMobile() {
		return payerMobile;
	}
	public void setPayerMobile(Integer payerMobile) {
		this.payerMobile = payerMobile;
	}
	public String getClientTxnId() {
		return clientTxnId;
	}
	public void setClientTxnId(String clientTxnId) {
		this.clientTxnId = clientTxnId;
	}
	public String getAmount() {
		return amount;
	}
	public void setAmount(String amount) {
		this.amount = amount;
	}
	public String getClientCode() {
		return clientCode;
	}
	public void setClientCode(String clientCode) {
		this.clientCode = clientCode;
	}
	public String getPaidAmount() {
		return paidAmount;
	}
	public void setPaidAmount(String paidAmount) {
		this.paidAmount = paidAmount;
	}
	public String getPayerMode() {
		return payerMode;
	}
	public void setPayerMode(String payerMode) {
		this.payerMode = payerMode;
	}
	public String getBankName() {
		return bankName;
	}
	public void setBankName(String bankName) {
		this.bankName = bankName;
	}
	public String getStatus() {
		return status;
	}
	public void setStatus(String status) {
		this.status = status;
	}
	public String getStatusCode() {
		return statusCode;
	}
	public void setStatusCode(String statusCode) {
		this.statusCode = statusCode;
	}
	public String getSabpaisaTxnId() {
		return sabpaisaTxnId;
	}
	public void setSabpaisaTxnId(String sabpaisaTxnId) {
		this.sabpaisaTxnId = sabpaisaTxnId;
	}
	public Integer getMcc() {
		return mcc;
	}
	public void setMcc(Integer mcc) {
		this.mcc = mcc;
	}
	public Integer getTransDate() {
		return transDate;
	}
	public void setTransDate(Integer transDate) {
		this.transDate = transDate;
	}
	public sabpaisaPgEntity(String payerName, String payerEmail, Integer payerMobile, String clientTxnId, String amount,
			String clientCode, String paidAmount, String payerMode, String bankName, String status, String statusCode,
			String sabpaisaTxnId, Integer mcc, Integer transDate, String udf1, String udf2, String udf3, String udf4,
			String udf5, String udf6, String udf7, String udf8, String udf9, String udf10) {
		super();
		this.payerName = payerName;
		this.payerEmail = payerEmail;
		this.payerMobile = payerMobile;
		this.clientTxnId = clientTxnId;
		this.amount = amount;
		this.clientCode = clientCode;
		this.paidAmount = paidAmount;
		this.payerMode = payerMode;
		this.bankName = bankName;
		this.status = status;
		this.statusCode = statusCode;
		this.sabpaisaTxnId = sabpaisaTxnId;
		this.mcc = mcc;
		this.transDate = transDate;
		this.udf1 = udf1;
		this.udf2 = udf2;
		this.udf3 = udf3;
		this.udf4 = udf4;
		this.udf5 = udf5;
		this.udf6 = udf6;
		this.udf7 = udf7;
		this.udf8 = udf8;
		this.udf9 = udf9;
		this.udf10 = udf10;
	}
	public sabpaisaPgEntity() {
		super();
		// TODO Auto-generated constructor stub
		
	}
	@Override
	public String toString() {
		return "sabpaisaPgEntity [payerName=" + payerName + ", payerEmail=" + payerEmail + ", payerMobile="
				+ payerMobile + ", clientTxnId=" + clientTxnId + ", amount=" + amount + ", clientCode=" + clientCode
				+ ", paidAmount=" + paidAmount + ", payerMode=" + payerMode + ", bankName=" + bankName + ", status="
				+ status + ", statusCode=" + statusCode + ", sabpaisaTxnId=" + sabpaisaTxnId + ", mcc=" + mcc
				+ ", transDate=" + transDate + ", udf1=" + udf1 + ", udf2=" + udf2 + ", udf3=" + udf3 + ", udf4=" + udf4
				+ ", udf5=" + udf5 + ", udf6=" + udf6 + ", udf7=" + udf7 + ", udf8=" + udf8 + ", udf9=" + udf9
				+ ", udf10=" + udf10 + "]";
	}
	
	
	

}

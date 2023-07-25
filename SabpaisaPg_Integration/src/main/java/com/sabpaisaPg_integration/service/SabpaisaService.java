package com.sabpaisaPg_integration.service;

import java.io.UnsupportedEncodingException;
import java.net.URI;
import java.net.URISyntaxException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;
import java.util.UUID;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.apache.juli.logging.Log;
import org.json.JSONException;
import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Value;
import org.springframework.http.HttpEntity;
import org.springframework.http.HttpHeaders;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Service;
import org.springframework.util.LinkedMultiValueMap;
import org.springframework.util.MultiValueMap;
import org.springframework.web.client.RestClientException;
import org.springframework.web.client.RestTemplate;
import org.springframework.web.servlet.ModelAndView;

import com.sabpaisaPg_integration.controller.SabpaisaController;
import com.sabpaisaPg_integration.util.Encryptor;



@Service
public class SabpaisaService {



	@Value("${clientCode}")
	private String clientCode;

	@Value("${transUserName}")
	private String transUserName;

	@Value("${transUserPassword}")
	private String transUserPassword;

	@Value("${callbackUrl}")
	private String callbackUrl;

	@Value("${paymentUrl}")
	private String paymentUrl;

	@Value("${txnEnquiryUrl}")
	private String txnEnquiryUrl;
	
 	@Value("${refundUrl}")
    private String refundUrl;
	
	@Value("${acknowledgementUrl}")
	private  String acknowledgementUrl;
	
	@Value("${bankingListUrl}")
	private  String bankingListUrl;

	@Value("${authKey}")
	private String authKey;

	@Value("${authIV}")
	private String authIV;
	


	public ModelAndView sendPaymentRequest() {

		String payerName = "Karishma";
		String payerEmail = "karishmarao46@gmail.com";
		long payerMobile = 7880567930L;
		String clientTxnId = UUID.randomUUID().toString().replaceAll("-", "").substring(0, 14);
		System.out.println("clientTxnId :: " + clientTxnId);
		byte amount = 1;
		char channelId = 'W';
		int mcc = 1520;

		StringBuilder pgRequest = new StringBuilder();
		pgRequest.append("payerName=").append(payerName.trim());
		pgRequest.append("&payerEmail=").append(payerEmail.trim());
		pgRequest.append("&payerMobile=").append(payerMobile);
		pgRequest.append("&clientTxnId=").append(clientTxnId);
		pgRequest.append("&amount=").append(amount);
		pgRequest.append("&clientCode=").append(clientCode.trim());
		pgRequest.append("&transUserName=").append(transUserName.trim());
		pgRequest.append("&transUserPassword=").append(transUserPassword.trim());
		pgRequest.append("&callbackUrl=").append(callbackUrl);
		pgRequest.append("&channelId=").append(channelId);
		pgRequest.append("&mcc=").append(mcc);
		pgRequest.append("&transDate=").append(new Date());

		System.out.println("Sample Request string for payment api :: " + pgRequest.toString());

		String encryptedString = null;
		try {
			encryptedString = Encryptor.encrypt(authKey.trim(), authIV.trim(), pgRequest.toString());
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
				| InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchPaddingException
				| UnsupportedEncodingException e) {

			e.printStackTrace();
		}
		System.out.println("Encrypted Request string for payment api :: " + encryptedString);

		ModelAndView view = new ModelAndView("PgTest");

		view.addObject("encData", encryptedString);
		view.addObject("clientCode", clientCode);
		view.addObject("URL", paymentUrl);

		return view;

	}

	public String getPgResponseService(String pgRequest) {
	String arr[] = null;
	String decText = null;
	try {decText = Encryptor.decrypt(authKey, authIV, pgRequest);
	} catch (InvalidKeyException e) {
	
	e.printStackTrace();
	} catch (NoSuchAlgorithmException e) {
	
	e.printStackTrace();
	} catch (NoSuchPaddingException e) {

	
	e.printStackTrace();
	} catch (UnsupportedEncodingException e) {
	
	e.printStackTrace();
	} catch (InvalidAlgorithmParameterException e) {
	
	e.printStackTrace();
	} catch (IllegalBlockSizeException e) {
	
	e.printStackTrace();
	} catch (BadPaddingException e) {

	e.printStackTrace();
	}
	System.out.println(decText);
	System.out.println("\n\n");

	arr = decText.split("&");
	for (String str : arr)
	System.out.println(str);
	return decText;
	}
	public String sabpaisaTxnEnquiry(String clientCode, String clientTxnId) {

		String stringToEnquiry = "clientCode=" + clientCode.trim() + "&clientTxnId=" + clientTxnId.trim();

		System.out.println("Sample string to make statusTransEncData :: " + stringToEnquiry);

		String statusTransEncData = null;
		try {
			statusTransEncData = Encryptor.encrypt(authKey, authIV, stringToEnquiry);
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
				| InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchPaddingException
				| UnsupportedEncodingException e) {
			e.printStackTrace();
		}

		System.out.println("statusTransEncData :: " + statusTransEncData);

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("clientCode", clientCode.trim());
		jsonObject.put("statusTransEncData", statusTransEncData.trim());

		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Accept", "application/json");

		HttpEntity<String> httpRequest = new HttpEntity<>(jsonObject.toString(), httpHeaders);

		RestTemplate restTemplate = new RestTemplate();
		String enquiryResponse = restTemplate.postForObject(txnEnquiryUrl.trim(), httpRequest, String.class);

		System.out.println("response from Txn Enquiry API :: " + enquiryResponse);

		JSONObject jsonRes = new JSONObject(enquiryResponse);
		
		System.out.println("jsonRes :: " + jsonRes);
		String decryptedEnquiryRes=null;
		try {
			 decryptedEnquiryRes = Encryptor.decrypt(authKey, authIV, jsonRes.getString("statusResponseData"));
			System.out.println("decrypted enquiry Response :: " + decryptedEnquiryRes);
		} catch (InvalidKeyException | NoSuchAlgorithmException | NoSuchPaddingException | UnsupportedEncodingException
				| InvalidAlgorithmParameterException | IllegalBlockSizeException | BadPaddingException
				| JSONException e) {
			e.printStackTrace();
		}

		System.out.println("decryptedEnquiryRes :: " + decryptedEnquiryRes);
	
		return decryptedEnquiryRes;
	}


	public String refundRequest(String clientCode, String clientTxnId,String spTxnId,String amount,String message  ) throws RestClientException, URISyntaxException  {
		
		String refundQuery = "clientCode=" + clientCode.trim() + "&clientTxnid=" + 
				clientTxnId.trim()+"&spTxnId="+spTxnId.trim()+"&amount="+amount.trim()+"&message="+message;

		System.out.println("refundQuery for refund url"+refundQuery);
			
		String refundEnc=null;
		try {
			 refundEnc = Encryptor.encrypt(authKey, authIV, refundQuery);
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
				| InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchPaddingException
				| UnsupportedEncodingException e) {
			    e.printStackTrace();
			
		}

		String finalRefundReq=refundUrl.trim()+"clientCode="+clientCode+"&refundQuery="+refundEnc;
		
		System.out.println("Refund"+finalRefundReq);
		RestTemplate restTemplate = new RestTemplate();
		String refundResponse = restTemplate.getForObject(new URI(finalRefundReq.replaceAll("\\+", "%2B")), String.class);
		System.out.println("refundResponse :"+refundResponse);
		
		return refundResponse;
	}
	
	
	
	
	

	public String acknowledgement(String clientCode, String clientTxnId,String acknowledgeFlag  )  {
		
		String acknowledgement = "clientCode=" + clientCode.trim() + "&clientTxnid=" + 
				clientTxnId.trim()+"&acknowledgeFlag=true";
		
	
		
		String acknowledgeEnc = null;
		try {
			acknowledgeEnc = Encryptor.encrypt(authKey, authIV, acknowledgement);
		} catch (InvalidKeyException | IllegalBlockSizeException | BadPaddingException
				| InvalidAlgorithmParameterException | NoSuchAlgorithmException | NoSuchPaddingException
				| UnsupportedEncodingException e) {
			    e.printStackTrace();
			
		}

		JSONObject jsonObject = new JSONObject();
		jsonObject.put("clientCode", clientCode.trim());
		jsonObject.put("acknowledgeEnc", acknowledgeEnc.trim());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Accept", "application/json");

		HttpEntity<String> httpRequest = new HttpEntity<>(jsonObject.toString(), httpHeaders);
	
		System.out.println("httpRequest"+httpRequest);
		RestTemplate restTemplate = new RestTemplate();
		String acknowledgementResponse = restTemplate.postForObject(acknowledgementUrl.trim(), httpRequest, String.class);
 
		System.out.println("acknowledgementResponse"+acknowledgementResponse);
		
	
		return  acknowledgementResponse;
		
	}

	public String paymentMode(String  clientCode, String modeTransfer) {
	
//	modeTransfer="WALLET_MODE_TRANSFER”;
		String samModeTransfer =  "&modeTransfer="+modeTransfer;

		try {
			modeTransfer = Encryptor.encrypt(authKey, authIV, samModeTransfer);
			} catch (Exception e) {
			e.printStackTrace();
			}
	System.out.println("modeTransfer : "+modeTransfer);
		JSONObject jsonObject = new JSONObject();
		jsonObject.put("clientCode", clientCode.trim());
		jsonObject.put("modeTransfer", modeTransfer.trim());
		
		HttpHeaders httpHeaders = new HttpHeaders();
		httpHeaders.setContentType(MediaType.APPLICATION_JSON);
		httpHeaders.set("Accept", "application/json");

		HttpEntity<String> httpRequest = new HttpEntity<>(jsonObject.toString(), httpHeaders);
		System.out.println("httpRequest"+httpRequest);
		RestTemplate restTemplate = new RestTemplate();
		String bankListResponse = restTemplate.postForObject(bankingListUrl.trim(), httpRequest, String.class);
        System.out.println("bankListResponse"+bankListResponse);

	return bankListResponse;
	}


	
		
	
}


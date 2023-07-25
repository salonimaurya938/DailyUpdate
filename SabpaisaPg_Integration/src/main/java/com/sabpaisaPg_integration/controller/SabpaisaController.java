package com.sabpaisaPg_integration.controller;

import java.io.UnsupportedEncodingException;
import java.net.URISyntaxException;
import java.security.InvalidAlgorithmParameterException;
import java.security.InvalidKeyException;
import java.security.NoSuchAlgorithmException;
import java.util.Map;

import javax.crypto.BadPaddingException;
import javax.crypto.IllegalBlockSizeException;
import javax.crypto.NoSuchPaddingException;

import org.json.JSONObject;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;
import org.springframework.web.client.RestClientException;
import org.springframework.web.servlet.ModelAndView;

import com.mysql.cj.log.Log;

import com.sabpaisaPg_integration.entities.sabpaisaPgEntity;
import com.sabpaisaPg_integration.service.SabpaisaService;

@RestController

public class SabpaisaController {

	@Autowired
	private SabpaisaService sabpaisaService;

	@GetMapping("/paymentRequest")
	public ModelAndView getPaymentRequest() {

		return sabpaisaService.sendPaymentRequest();

	}

	@PostMapping(value = "/paymentResponse")
	public ResponseEntity<String> getPaymentResponse(@RequestParam("clientCode") String clientCode,
			@RequestParam("encResponse") String encResponse) {

		System.out.println("clientCode :: " + clientCode);
		System.out.println("encResponse :: " + encResponse);

		return ResponseEntity.ok(sabpaisaService.getPgResponseService(encResponse));

	}

	@GetMapping(value = "/paymentEnquiry")
	public ResponseEntity<String> getPaymentEnquiry(@RequestParam("clientCode") String clientCode,
			@RequestParam("clientTxnId") String clientTxnId) throws InvalidKeyException, NoSuchAlgorithmException, UnsupportedEncodingException, NoSuchPaddingException {

		System.out.println("clientCode :: " + clientCode);
		System.out.println("clientTxnId :: " + clientTxnId);

		return ResponseEntity.ok(sabpaisaService.sabpaisaTxnEnquiry(clientCode, clientTxnId));

	}



	@GetMapping(value = "/refundRequest")
	public ResponseEntity<String> getrefundRequest(@RequestParam("clientCode") String clientCode,
			@RequestParam("clientTxnId") String clientTxnId,
			@RequestParam("spTxnId") String spTxnId,
	@RequestParam("amount") String amount,
@RequestParam("message") String message) throws RestClientException, URISyntaxException{

		System.out.println("clientCode :: " + clientCode);
		System.out.println("clientTxnId :: " + clientTxnId);

		return ResponseEntity.ok(sabpaisaService.refundRequest(clientCode, clientTxnId, spTxnId, amount, message));

	}

	@PostMapping(value = "/acknowledgement")
	public  ResponseEntity<String> acknowledgement
	        (@RequestParam("clientCode") String clientCode,
			 @RequestParam("clientTxnid")String clientTxnid, 
             @RequestParam("acknowledgeFlag") String acknowledgeFlag)throws RestClientException, URISyntaxException, NoSuchAlgorithmException, InvalidAlgorithmParameterException
           {
	String acknowledgementRes = sabpaisaService.acknowledgement(clientCode, clientTxnid, acknowledgeFlag);
	return new ResponseEntity<>(acknowledgementRes, HttpStatus.OK);
	}
	
	@GetMapping(value = "/paymentMode")
	public  ResponseEntity<String> modeTransfer
	        (@RequestParam(required=false,name="clientCode") String clientCode,
			 @RequestParam(required=false,name="modeTransfer") String modeTransfer)
           {
	String bankModeResponse= sabpaisaService.paymentMode(clientCode,modeTransfer);
	return new ResponseEntity<>(bankModeResponse, HttpStatus.OK);


	}



	}

	




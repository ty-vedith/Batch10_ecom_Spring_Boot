package com.te.springboot.controller;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RestController;

import com.te.springboot.bean.EcomResponse;
import com.te.springboot.bean.Item;
import com.te.springboot.service.EcomService;

@RestController
public class EcomController {
	
	@Autowired
	EcomService service;
	
	@GetMapping(path = "/getItem", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE})
	public EcomResponse getItem(Integer id) {

		Item item = service.searchItem(id);
		EcomResponse response = new EcomResponse();
		
		if(item != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setItem(item);
		} else {
			response.setStatusCode(404);
			response.setMsg("item does not presesnt");
		}
		return response;
		
	}// end of getEmpData

	@GetMapping(path = "/getAll", produces = { MediaType.APPLICATION_JSON_VALUE, MediaType.APPLICATION_XML_VALUE })
	public EcomResponse getAllItem() {
		EcomResponse response = new EcomResponse();
		List<Item> infoBeans = service.getAllItems();

		if (infoBeans != null) {
			response.setStatusCode(200);
			response.setMsg("success");
			response.setItemList(infoBeans);
		} else {
			response.setStatusCode(400);
			response.setMsg("Datas not found");
		}

		return response;
	}// END OF GETALL

	@PostMapping(path = "/add", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EcomResponse addItem(@RequestBody Item item) {
		EcomResponse response = new EcomResponse();

		if(service.addItem(item)) {
			response.setStatusCode(200);
			response.setMsg("success");
	
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not add the data");
		}
		return response;
	}// end of addEmp

	@PutMapping(path = "/update", produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE }, consumes = { MediaType.APPLICATION_JSON_VALUE,
					MediaType.APPLICATION_XML_VALUE })
	public EcomResponse updateAdminData(@RequestBody Item item) {
		EcomResponse response = new EcomResponse();

		if (service.updateItem(item)) {
			response.setStatusCode(200);
			response.setMsg("success , Updated the record");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not update the record");
		}
		return response;
	} // update

	
	@DeleteMapping(path = "/delete/{empId}" , produces = { MediaType.APPLICATION_JSON_VALUE,
			MediaType.APPLICATION_XML_VALUE })
	public EcomResponse deleteItemData(@PathVariable(name = "empId")int id ) {
		EcomResponse response = new EcomResponse();

		if (service.removeItem(id)) {
			response.setStatusCode(200);
			response.setMsg("success , record deleted");
		} else {
			response.setStatusCode(400);
			response.setMsg("Failure , Could not delete the record");
		}
		return response;
	}
	

}


package com.tcs.hospitals;

import java.util.List;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestMethod;
import org.springframework.web.bind.annotation.ResponseBody;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/test/")
public class HospitalController {
	
	@Autowired
	private HospitalService hospitalService;
	
	@RequestMapping(value="/hospitals",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
	public @ResponseBody List<Hospital> getAllHospitals() {
		return hospitalService.getAllHospitals();
	}
	
	@RequestMapping(value="/hospitals/{id}",produces=MediaType.APPLICATION_JSON_VALUE,method=RequestMethod.GET)
	public @ResponseBody Hospital getHospital(@PathVariable("id") int id) {
		return hospitalService.getHospital(id);
	}
	
	@RequestMapping(value="/hospitals",method=RequestMethod.POST)
	public ResponseEntity<String> insertHospital(@RequestBody Hospital hospital) {
		hospitalService.insertHospital(hospital);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value="/hospitals",method=RequestMethod.PUT)
	public ResponseEntity<String> updateHospital(@RequestBody Hospital hospital) {
		hospitalService.updateHospital(hospital);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.OK);
		return responseEntity;
	}
	
	@RequestMapping(value="/hospitals",method=RequestMethod.DELETE)
	public ResponseEntity<String> deleteHospital(@RequestBody Hospital hospital) {
		hospitalService.deleteHospital(hospital);
		ResponseEntity<String> responseEntity = new ResponseEntity<>(HttpStatus.NO_CONTENT);
		return responseEntity;
	}

}

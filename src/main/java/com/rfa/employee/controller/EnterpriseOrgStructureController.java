package com.rfa.employee.controller;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import javax.validation.Valid;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.PutMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import com.rfa.employee.exception.DataNotFoundException;
import com.rfa.employee.model.EnterpriseOrgStructure;
import com.rfa.employee.repository.EnterpriseOrgStructureRepository;

@RestController
@RequestMapping("api/v1")
public class EnterpriseOrgStructureController {
	
	@Autowired
	private EnterpriseOrgStructureRepository enterpriseOrgStructureRepository;
	
	@GetMapping("ent")
	public List<EnterpriseOrgStructure> getAllEnterpriseOrgStructures() {
		return enterpriseOrgStructureRepository.findAll();
	}

	@PostMapping(value = "/entSave")
	public EnterpriseOrgStructure save(@RequestBody EnterpriseOrgStructure enterpriseOrgStructure) {
		return enterpriseOrgStructureRepository.save(enterpriseOrgStructure);
	}
	
	@PutMapping(value = "ent/{id}")
	public ResponseEntity<EnterpriseOrgStructure> UpdateEnterpriseOrgStructure(@Valid @RequestBody EnterpriseOrgStructure enterpriseRequest, @PathVariable(value = "id") Long enterpriseId) throws DataNotFoundException {
		EnterpriseOrgStructure enterpriseOrgStructure = enterpriseOrgStructureRepository.findById(enterpriseId)
				.orElseThrow(() -> new DataNotFoundException("Employee not found for this id ::" + enterpriseId));
		
		enterpriseOrgStructure.setESID(enterpriseRequest.getESID());
		enterpriseOrgStructure.setESName(enterpriseRequest.getESName());
		enterpriseOrgStructure.setESSubcoID(enterpriseRequest.getESSubcoID());
		enterpriseOrgStructure.setCreationSpecification(enterpriseRequest.getCreationSpecification());
		
		final EnterpriseOrgStructure updateEnterpriseOrgStructure = enterpriseOrgStructureRepository.save(enterpriseOrgStructure);
		
	return ResponseEntity.ok().body(updateEnterpriseOrgStructure);
	}
	
	@DeleteMapping("ent/{id}")
	public Map<String, Boolean> deleteEnterpriseOrgStructure(@PathVariable(value = "id") Long enterpriseId)
		throws DataNotFoundException {
		EnterpriseOrgStructure enterpriseOrgStructure = enterpriseOrgStructureRepository.findById(enterpriseId)
				.orElseThrow(() -> new DataNotFoundException("Employee not found for this id ::" + enterpriseId));
		
		enterpriseOrgStructureRepository.delete(enterpriseOrgStructure);
		Map<String, Boolean> response = new HashMap<>();
		response.put("deleted", Boolean.TRUE);
		
	return response;
	}
	
	

}
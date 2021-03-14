package com.aws.codestar.projecttemplates.service;

import java.util.List;

import com.aws.codestar.projecttemplates.dto.AddressDTO;




public interface AddressService {
	
	List<AddressDTO> getAddresses(String id);

	AddressDTO getAddressByAddressId(String id);

}

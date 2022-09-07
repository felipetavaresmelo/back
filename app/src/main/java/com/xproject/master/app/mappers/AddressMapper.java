package com.xproject.master.app.mappers;

import com.xproject.master.app.dataprovider.repository.jpa.po.AddressPo;
import com.xproject.master.app.dto.AddressDto;
import com.xproject.master.domain.entity.adreess.Address;
import org.mapstruct.Mapper;
import org.mapstruct.factory.Mappers;

import java.util.List;

@Mapper(componentModel = "spring")
public interface AddressMapper {

    AddressMapper INSTANCE = Mappers.getMapper(AddressMapper.class);

    AddressDto addressToAddressDto (Address address);

    AddressPo addressToAddressPo (Address address);

    List<AddressDto> addressListToAddressDtoList (List<Address> addressList);

    List<AddressPo> addressListToAddressPoList (List<Address> addressList);

    Address addressPoToAddress (AddressPo addressPo);

    List<Address> addressPOListToAddressList(List<AddressPo> addressPoList);

    Address addressDtoToAddress (AddressDto addressDto);

    List<Address> addressDtoListToAddressList(List<AddressDto> addressDtoList);

}

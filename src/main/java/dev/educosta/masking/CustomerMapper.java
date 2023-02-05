package dev.educosta.masking;

import org.mapstruct.Context;
import org.mapstruct.InheritInverseConfiguration;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;


@Mapper
public interface CustomerMapper {

    @Mapping(target = "id", expression = "java(UUID.randomUUID())")
    @Mapping(target = "address.zipCode", source = "zipCode")
    @Mapping(target = "address.street", source = "street")
    @Mapping(target = "address.city", source = "city")
    @Mapping(target = "address.number", source = "number")
    CustomerDomain toDomain(CustomerRequest customerRequest);


    @Mapping(target = "zipCode", source = "address.zipCode")
    @Mapping(target = "street", source = "address.street")
    @Mapping(target = "city", source = "address.city")
    @Mapping(target = "number", source = "address.number")
    CustomerEntity toEntity(CustomerDomain customerDomain, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    default CustomerEntity toEntity(CustomerDomain customerDomain) {
        return toEntity(customerDomain, new CycleAvoidingMappingContext());
    }

    @InheritInverseConfiguration
    CustomerDomain toDomain(CustomerEntity customerEntity, @Context CycleAvoidingMappingContext cycleAvoidingMappingContext);

    default CustomerDomain toDomain(CustomerEntity customerEntity) {
        return toDomain(customerEntity, new CycleAvoidingMappingContext());
    }


}

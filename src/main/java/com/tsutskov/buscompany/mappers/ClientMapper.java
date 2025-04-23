package com.tsutskov.buscompany.mappers;

import com.tsutskov.buscompany.dto.ClientRegistrationDTO;
import com.tsutskov.buscompany.dto.response.UserResponse;
import com.tsutskov.buscompany.entity.Client;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.factory.Mappers;

@Mapper(componentModel = "spring")
public interface ClientMapper {

    ClientMapper INSTANCE = Mappers.getMapper(ClientMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userType", constant = "client")
    @Mapping(target = "login", source = "dto.login")
    @Mapping(target = "password", ignore = true)
    @Mapping(target = "firstName", source = "dto.firstName")
    @Mapping(target = "lastName", source = "dto.lastName")
    @Mapping(target = "patronymic", source = "dto.patronymic")
    @Mapping(target = "email", source = "dto.email")
    @Mapping(target = "phone", source = "dto.phone")
    @Mapping(target = "lastActivityTime", ignore = true)
    Client toClient(ClientRegistrationDTO dto);

    @Mapping(target = "id", source = "client.id")
    @Mapping(target = "firstName", source = "client.firstName")
    @Mapping(target = "lastName", source = "client.lastName")
    @Mapping(target = "patronymic", source = "client.patronymic")
    @Mapping(target = "email", source = "client.email")
    @Mapping(target = "phone", source = "client.phone")
    @Mapping(target = "userType", constant = "client")
    @Mapping(target = "position", ignore = true)
    UserResponse toResponse(Client client);
}

package com.tsutskov.buscompany.mappers;

import com.tsutskov.buscompany.dto.AdminRegistrationDTO;
import com.tsutskov.buscompany.dto.response.AdminResponse;
import com.tsutskov.buscompany.dto.response.UserResponse;
import com.tsutskov.buscompany.entity.Admin;
import com.tsutskov.buscompany.entity.UserType;
import org.mapstruct.Mapper;
import org.mapstruct.Mapping;
import org.mapstruct.Named;

import java.util.Locale;

@Mapper(componentModel = "spring")
public interface AdminMapper {

   // AdminMapper INSTANCE = Mappers.getMapper(AdminMapper.class);

    @Mapping(target = "id", ignore = true)
    @Mapping(target = "userType", ignore = true)
    Admin toAdmin(AdminRegistrationDTO adminRegistrationDTO);

    @Mapping(source = "userType", target = "userType", qualifiedByName = "toLowerCase")
    AdminResponse toUserResponse(Admin admin);

    @Named("toLowerCase")
    default String toLowerCase(UserType type){
        return type.toString().toLowerCase(Locale.ROOT);
    }

//    @Mapping(target = "id", ignore = true)
//    @Mapping(target = "userType", constant = "admin")
//    @Mapping(target = "login", source = "dto.login")
//    @Mapping(target = "password", ignore = true)
//    @Mapping(target = "firstName", source = "dto.firstName")
//    @Mapping(target = "lastName", source = "dto.lastName")
//    @Mapping(target = "patronymic", source = "dto.patronymic")
//    @Mapping(target = "position", source = "dto.position")
//    Admin toAdmin(AdminRegistrationDTO dto);
//
//    @Mapping(target = "id", source = "admin.id")
//    @Mapping(target = "firstName", source = "admin.firstName")
//    @Mapping(target = "lastName", source = "admin.lastName")
//    @Mapping(target = "patronymic", source = "admin.patronymic")
//    @Mapping(target = "position", source = "admin.position")
//    @Mapping(target = "userType", constant = "admin")
//    @Mapping(target = "email", ignore = true)
//    @Mapping(target = "phone", ignore = true)
//    UserResponse toResponse(Admin admin);
}

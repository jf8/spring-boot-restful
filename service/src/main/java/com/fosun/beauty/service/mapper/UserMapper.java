package com.fosun.beauty.service.mapper;

import com.fosun.beauty.domain.SysRole;
import com.fosun.beauty.domain.User;
import com.fosun.beauty.repository.SysRoleRepository;
import com.fosun.beauty.service.dto.UserDTO;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Objects;
import java.util.Set;
import java.util.stream.Collectors;

/**
 * Mapper for the entity User and its DTO called UserDTO.
 *
 * Normal mappers are generated using MapStruct, this one is hand-coded as MapStruct
 * support is still in beta, and requires a manual step with an IDE.
 */
@Service
public class UserMapper {

    @Autowired
    SysRoleRepository sysRoleRepository;

    public UserDTO userToUserDTO(User user) {
        return new UserDTO(user);
    }

    public List<UserDTO> usersToUserDTOs(List<User> users) {
        return users.stream()
            .filter(Objects::nonNull)
            .map(this::userToUserDTO)
            .collect(Collectors.toList());
    }

    public User userDTOToUser(UserDTO userDTO) {
        if (userDTO == null) {
            return null;
        } else {
            User user = new User();
            user.setId(userDTO.getId());
            user.setLogin(userDTO.getLogin());
            user.setUserName(userDTO.getUserName());
            user.setEmail(userDTO.getEmail());
            user.setImageUrl(userDTO.getImageUrl());
            user.setActivated(userDTO.isActivated());
            user.setLangKey(userDTO.getLangKey());
           Set<SysRole> sysRoles=  userDTO.getRoles().stream().map(id-> sysRoleRepository.getOne(id)).collect(Collectors.toSet());
           user.setRoles(sysRoles);
            return user;
        }
    }

    public List<User> userDTOsToUsers(List<UserDTO> userDTOs) {
        return userDTOs.stream()
            .filter(Objects::nonNull)
            .map(this::userDTOToUser)
            .collect(Collectors.toList());
    }

    public User userFromId(Long id) {
        if (id == null) {
            return null;
        }
        User user = new User();
        user.setId(id);
        return user;
    }

//    public Set<Authority> authoritiesFromStrings(Set<String> strings) {
//        return strings.stream().map(string -> {
//            Authority auth = new Authority();
//            auth.setName(string);
//            return auth;
//        }).collect(Collectors.toSet());
//    }
//
//
//    public Set<SysRole> sysRolesFromStrings(Set<String> strings) {
//        return strings.stream().map(string -> {
//            Authority auth = new Authority();
//            auth.setName(string);
//            return auth;
//        }).collect(Collectors.toSet());
//    }
}

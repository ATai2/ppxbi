package com.ppx.ppxes.service.user;


import com.ppx.ppxes.entity.Role;
import com.ppx.ppxes.entity.User;
import com.ppx.ppxes.repository.RoleRepository;
import com.ppx.ppxes.repository.UserRepository;
import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.security.authentication.DisabledException;
import org.springframework.security.core.GrantedAuthority;
import org.springframework.security.core.authority.SimpleGrantedAuthority;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

@Service
public class UserServiceImpl implements UserService {

    @Autowired
    private UserRepository userRepository;

    @Autowired
    private RoleRepository roleRepository;

    @Autowired
    private ModelMapper modelMapper;

    @Override
    public User findUserByName(String username) {
        User user = userRepository.findByName(username);

        if(user == null){
            return null;
        }
        List<Role> roles = roleRepository.findRolesByUserId(user.getId());
        if(roles == null || roles.isEmpty()){
            throw new DisabledException("权限非法");
        }
        List<GrantedAuthority> authorities = new ArrayList<>();
        roles.forEach(role -> authorities.add(new SimpleGrantedAuthority("ROLE_" + role.getName())));
        user.setAuthorityList(authorities);
        return user;
    }

//    @Override
//    public ServiceResult<UserDTO> findById(Long userId) {
//        User user = userRepository.findOne(userId);
//        if (user == null) {
//            return ServiceResult.notFound();
//        }
//        UserDTO userDTO = modelMapper.map(user, UserDTO.class);
//        return ServiceResult.of(userDTO);
//    }
}

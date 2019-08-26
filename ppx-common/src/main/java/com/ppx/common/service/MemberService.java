package com.ppx.common.service;

import com.ppx.common.base.ResponseBase;
import com.ppx.common.entity.UserEntity;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;


@RequestMapping("/member")
public interface MemberService {

	// 使用userId查找用户信息
	@RequestMapping("/findUserById")
	ResponseBase findUserById(Long userId);

	@RequestMapping("/regUser")
	ResponseBase regUser(@RequestBody UserEntity user);

	// 用户登录
	@RequestMapping("/login")
	ResponseBase login(@RequestBody UserEntity user);
    // 使用token进行登录
	@RequestMapping("/findByTokenUser")
	ResponseBase findByTokenUser(@RequestParam("token") String token);
    //使用openid查找用户信息
	@RequestMapping("/findByOpenIdUser")
	ResponseBase findByOpenIdUser(@RequestParam("openid") String openid);
	// 用户登录
	@RequestMapping("/qqLogin")
	ResponseBase qqLogin(@RequestBody UserEntity user);
}

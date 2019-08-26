package com.ppx.common.service;

import com.ppx.common.base.ResponseBase;
import com.ppx.common.entity.UserEntity;
import org.springframework.web.bind.annotation.*;


@RequestMapping("/member")
public interface MemberService {

	// 使用userId查找用户信息
	@GetMapping("/findUserById")
	ResponseBase findUserById(Long userId);

	@PostMapping("/regUser")
	ResponseBase regUser(@RequestBody UserEntity user);

	// 用户登录
	@PostMapping("/login")
	ResponseBase login(@RequestBody UserEntity user);
    // 使用token进行登录
	@GetMapping("/findByTokenUser")
	ResponseBase findByTokenUser(@RequestParam("token") String token);
    //使用openid查找用户信息
	@GetMapping("/findByOpenIdUser")
	ResponseBase findByOpenIdUser(@RequestParam("openid") String openid);
	// 用户登录
	@PostMapping("/qqLogin")
	ResponseBase qqLogin(@RequestBody UserEntity user);
}

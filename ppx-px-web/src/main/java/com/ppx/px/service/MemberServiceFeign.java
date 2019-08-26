package com.ppx.px.service;

import org.springframework.cloud.openfeign.FeignClient;
import org.springframework.stereotype.Component;
import com.ppx.common.service.MemberService;

@Component
@FeignClient("ppx-member")
public interface MemberServiceFeign  extends MemberService {

}

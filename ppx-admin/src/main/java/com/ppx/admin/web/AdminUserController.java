package com.ppx.admin.web;

import com.ppx.admin.annotation.RequiresPermissionsDesc;
import com.ppx.admin.request.UserRequest;
import com.ppx.common.ppxutil.util.ResponseUtil;
import com.ppx.common.ppxutil.validator.Order;
import com.ppx.common.ppxutil.validator.Sort;
import com.ppx.ppxlitemalldb.domain.LitemallUser;
import com.ppx.ppxlitemalldb.service.LitemallUserService;
import org.apache.commons.logging.Log;
import org.apache.commons.logging.LogFactory;
import org.apache.shiro.authz.annotation.RequiresPermissions;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
//@RequestMapping("/admin/user")
@Validated
public class AdminUserController {
    private final Log logger = LogFactory.getLog(AdminUserController.class);

    @Autowired
    private LitemallUserService userService;

    @RequiresPermissions("admin:user:list")
    @RequiresPermissionsDesc(menu = {"用户管理", "会员管理"}, button = "查询")
    @GetMapping("/admin/user/list")
    public Object list(String username, String mobile,
                       @RequestParam(defaultValue = "1") Integer page,
                       @RequestParam(defaultValue = "10") Integer limit,
                       @Sort @RequestParam(defaultValue = "add_time") String sort,
                       @Order @RequestParam(defaultValue = "desc") String order) {
        List<LitemallUser> userList = userService.querySelective(username, mobile, page, limit, sort, order);
        return ResponseUtil.okList(userList);
    }

    @PostMapping("/user/add")
    public Object addUser(@RequestBody UserRequest user){
        logger.info(user.toString());
        return  ResponseUtil.ok();
    }
}

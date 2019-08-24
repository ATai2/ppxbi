package com.ppx.common.message.ppxusermgt.controller;

import com.ppx.common.message.ppxusermgt.dao.IpDao;
import com.ppx.common.message.ppxusermgt.entity.CommonResp;
import com.ppx.common.message.ppxusermgt.entity.IpBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

/**
 * @author Administrator
 */
@RequestMapping(value = "/ippool")
@RestController
public class IpController {

    @Autowired
    private IpDao ipDao;
    @GetMapping("/ip")
    public CommonResp<List<IpBean>> getIP(@RequestParam Integer pageIndex, @RequestParam Integer pageSize ){
        CommonResp<List<IpBean>> res=new CommonResp<>();

        List<IpBean> list=new ArrayList<>();
        Page<IpBean> all = ipDao.findAll(new PageRequest(1, 20));
        list.addAll(all.getContent());

        res.setData(list);
        return res;
    }
}

package com.ppx.ppxusermgt.controller;

import com.ppx.ppxusermgt.dao.IpDao;
import com.ppx.ppxusermgt.entity.CommonResp;
import com.ppx.ppxusermgt.entity.IpBean;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Page;
import org.springframework.data.domain.PageRequest;
import org.springframework.data.jpa.domain.Specification;
import org.springframework.web.bind.annotation.*;

import javax.persistence.criteria.CriteriaBuilder;
import javax.persistence.criteria.CriteriaQuery;
import javax.persistence.criteria.Predicate;
import javax.persistence.criteria.Root;
import java.awt.print.PageFormat;
import java.awt.print.Pageable;
import java.awt.print.Printable;
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

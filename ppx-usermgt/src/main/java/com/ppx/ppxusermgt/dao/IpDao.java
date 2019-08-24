package com.ppx.ppxusermgt.dao;

import com.ppx.ppxusermgt.entity.IpBean;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.data.jpa.repository.JpaSpecificationExecutor;
import org.springframework.stereotype.Repository;

/**
 * @author Administrator
 */
@Repository
public interface IpDao extends JpaRepository<IpBean, Long>  , JpaSpecificationExecutor<IpBean> {

}

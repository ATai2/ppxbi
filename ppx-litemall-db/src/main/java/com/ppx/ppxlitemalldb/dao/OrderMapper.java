package com.ppx.ppxlitemalldb.dao;

import org.apache.ibatis.annotations.Param;
import com.ppx.ppxlitemalldb.domain.LitemallOrder;

import java.time.LocalDateTime;

public interface OrderMapper {
    int updateWithOptimisticLocker(@Param("lastUpdateTime") LocalDateTime lastUpdateTime, @Param("order") LitemallOrder order);
}
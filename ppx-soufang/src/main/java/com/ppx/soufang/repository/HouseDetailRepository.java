package com.ppx.soufang.repository;

import com.ppx.soufang.entity.HouseDetail;
import org.springframework.data.repository.CrudRepository;

import java.util.List;

/**
 * Created by 瓦力.
 */
public interface HouseDetailRepository extends CrudRepository<HouseDetail, Long> {
    HouseDetail findByHouseId(Long houseId);

    List<HouseDetail> findAllByHouseIdIn(List<Long> houseIds);
}

package com.ppx.soufang.service.search;


import com.ppx.soufang.service.ServiceMultiResult;
import com.ppx.soufang.service.ServiceResult;
import com.ppx.soufang.web.form.MapSearch;
import com.ppx.soufang.web.form.RentSearch;

import java.util.List;

/**
 * 检索接口
 * Created by 瓦力.
 */
public interface ISearchService {
    /**
     * 索引目标房源
     * @param houseId
     */
    void index(Long houseId);

    /**
     * 移除房源索引
     * @param houseId
     */
    void remove(Long houseId);

    /**
     * 查询房源接口
     * @param rentSearch
     * @return
     */
    ServiceMultiResult<Long> query(RentSearch rentSearch);

    /**
     * 获取补全建议关键词
     */
    ServiceResult<List<String>> suggest(String prefix);

    /**
     * 聚合特定小区的房间数
     */
    ServiceResult<Long> aggregateDistrictHouse(String cityEnName, String regionEnName, String district);

    /**
     * 聚合城市数据
     * @param cityEnName
     * @return
     */
    ServiceMultiResult<HouseBucketDTO> mapAggregate(String cityEnName);

    /**
     * 城市级别查询
     * @return
     */
    ServiceMultiResult<Long> mapQuery(String cityEnName, String orderBy,
                                      String orderDirection, int start, int size);
    /**
     * 精确范围数据查询
     * @param mapSearch
     * @return
     */
    ServiceMultiResult<Long> mapQuery(MapSearch mapSearch);
}

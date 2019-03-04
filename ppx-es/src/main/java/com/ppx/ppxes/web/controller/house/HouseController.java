//package com.ppx.ppxes.web.controller.house;
//
//import com.google.common.collect.Lists;
//import com.sofang.base.*;
//import com.sofang.service.house.AddressService;
//import com.sofang.service.house.HouseService;
//import com.sofang.service.search.SearchService;
//import com.sofang.service.user.UserService;
//import com.sofang.web.dto.*;
//import com.sofang.web.form.RentFilter;
//import org.springframework.beans.factory.annotation.Autowired;
//import org.springframework.stereotype.Controller;
//import org.springframework.ui.Model;
//import org.springframework.web.bind.annotation.*;
//import org.springframework.web.servlet.mvc.support.RedirectAttributes;
//
//import javax.servlet.http.HttpSession;
//import java.util.List;
//import java.util.Map;
//
///**
// * Created by gegf
// */
//@Controller
//public class HouseController {
//
//    @Autowired
//    private AddressService addressService;
//
//    @Autowired
//    private HouseService houseService;
//
//    @Autowired
//    private UserService userService;
//
//    @Autowired
//    private SearchService searchService;
//
//    @ResponseBody
//    @GetMapping("rent/house/autocomplete")
//    public ResponseEntity autoComplete(@RequestParam(value="prefix") String prefix){
//        if(prefix.isEmpty()){
//            return ResponseEntity.createByErrorCodeMessage(StatusCode.BAD_REQUEST);
//        }
//        ServiceResult<List<String>> result = searchService.suggest(prefix);
//        return ResponseEntity.ofSuccess(result);
//    }
//
//
//
//    /**
//     * 获取所有支持的城市
//     * @return
//     */
//    @ResponseBody
//    @GetMapping("address/support/cities")
//    public ResponseEntity getSupportCities(){
//        ServiceMultiResult<SupportAddressDTO> result = addressService.findAllCities();
//        if(result.getResultSize() == 0){
//            return ResponseEntity.createByErrorCodeMessage(StatusCode.NOT_FOUND);
//        }
//        return ResponseEntity.createBySuccess(result.getResult());
//    }
//
//    /**
//     * 获取指定城市下的区/县
//     * @param cityEnName
//     * @return
//     */
//    @ResponseBody
//    @RequestMapping("address/support/regions")
//    public ResponseEntity getSupportRegions(@RequestParam(name="city_name")String cityEnName){
//        ServiceMultiResult<SupportAddressDTO> addressResult = addressService.findAllRegionByCityName(cityEnName);
//        if (addressResult.getResult() == null || addressResult.getTotal() < 1) {
//            return ResponseEntity.createByErrorCodeMessage(StatusCode.NOT_FOUND);
//        }
//        return ResponseEntity.createBySuccess(addressResult.getResult());
//    }
//
//    /**
//     * 获取具体城市所支持的地铁线路
//     * @param cityEnName
//     * @return
//     */
//    @GetMapping("address/support/subway/line")
//    @ResponseBody
//    public ResponseEntity getSupportSubwayLine(@RequestParam(name = "city_name") String cityEnName) {
//        List<SubwayDTO> subways = addressService.findAllSubwayByCity(cityEnName);
//        return ResponseEntity.createBySuccess(subways);
//    }
//
//    /**
//     * 获取对应地铁线路所支持的地铁站点
//     * @param subwayId
//     * @return
//     */
//    @GetMapping("address/support/subway/station")
//    @ResponseBody
//    public ResponseEntity getSupportSubwayStation(@RequestParam(name = "subway_id") Long subwayId) {
//        List<SubwayStationDTO> stationDTOS = addressService.findAllStationBySubway(subwayId);
//        if (stationDTOS.isEmpty()) {
//            return ResponseEntity.createByErrorCodeMessage(StatusCode.NOT_FOUND);
//        }
//
//        return ResponseEntity.createBySuccess(stationDTOS);
//    }
//
//    @GetMapping("rent/house")
//    public String rentHousePage(@ModelAttribute RentFilter rentFilter,
//                                Model model, HttpSession session,
//                                RedirectAttributes redirectAttributes) {
//        if (rentFilter.getCityEnName() == null) {
//            String cityEnNameInSession = (String) session.getAttribute("cityEnName");
//            if (cityEnNameInSession == null) {
//                redirectAttributes.addAttribute("msg", "must_chose_city");
//                return "redirect:/index";
//            } else {
//                rentFilter.setCityEnName(cityEnNameInSession);
//            }
//        } else {
//            session.setAttribute("cityEnName", rentFilter.getCityEnName());
//        }
//
//        ServiceResult<SupportAddressDTO> city = addressService.findCity(rentFilter.getCityEnName());
//        if (!city.isSuccess()) {
//            redirectAttributes.addAttribute("msg", "must_chose_city");
//            return "redirect:/index";
//        }
//        model.addAttribute("currentCity", city.getResult());
//
//        ServiceMultiResult<SupportAddressDTO> addressResult = addressService.findAllRegionsByCityName(rentFilter.getCityEnName());
//        if (addressResult.getResult() == null || addressResult.getTotal() < 1) {
//            redirectAttributes.addAttribute("msg", "must_chose_city");
//            return "redirect:/index";
//        }
//
//        ServiceMultiResult<HouseDTO> serviceMultiResult = houseService.query(rentFilter);
//
//        model.addAttribute("total", serviceMultiResult.getTotal());
//        model.addAttribute("houses", serviceMultiResult.getResult());
//
//        if (rentFilter.getRegionEnName() == null) {
//            rentFilter.setRegionEnName("*");
//        }
//
//        model.addAttribute("searchBody", rentFilter);
//        model.addAttribute("regions", addressResult.getResult());
//
//        model.addAttribute("priceBlocks", RentValueBlock.PRICE_BLOCK);
//        model.addAttribute("areaBlocks", RentValueBlock.AREA_BLOCK);
//
//        model.addAttribute("currentPriceBlock", RentValueBlock.matchPrice(rentFilter.getPriceBlock()));
//        model.addAttribute("currentAreaBlock", RentValueBlock.matchArea(rentFilter.getAreaBlock()));
//
//        return "rent-list";
//    }
//
//    @GetMapping("rent/house/show/{id}")
//    public String show(@PathVariable(value = "id") Long houseId,
//                       Model model) {
//        if (houseId <= 0) {
//            return "404";
//        }
//
//        ServiceResult<HouseDTO> serviceResult = houseService.findCompleteOne(houseId);
//        if (!serviceResult.isSuccess()) {
//            return "404";
//        }
//
//        HouseDTO houseDTO = serviceResult.getResult();
//        Map<Level, SupportAddressDTO> addressMap = addressService.findCityAndRegion(houseDTO.getCityEnName(), houseDTO.getRegionEnName());
//
//        SupportAddressDTO city = addressMap.get(Level.CITY);
//        SupportAddressDTO region = addressMap.get(Level.REGION);
//
//        model.addAttribute("city", city);
//        model.addAttribute("region", region);
//
//        ServiceResult<UserDTO> userDTOServiceResult = userService.findById(houseDTO.getAdminId());
//        model.addAttribute("agent", userDTOServiceResult.getResult());
//        model.addAttribute("house", houseDTO);
//
//       /* ServiceResult<Long> aggResult = searchService.aggregateDistrictHouse(city.getEnName(), region.getEnName(), houseDTO.getDistrict());
//        model.addAttribute("houseCountInDistrict", aggResult.getResult());*/
//
//        return "house-detail";
//    }
//
//}

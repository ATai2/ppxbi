package com.ppx.ppxes.web.controller.admin;

import com.google.common.base.Strings;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.http.HttpStatus;
import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.ui.Model;
import org.springframework.validation.BindingResult;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.multipart.MultipartFile;

import javax.validation.Valid;
import java.io.IOException;
import java.io.InputStream;
import java.util.Map;

/**
 * 后台管理
 *
 * @since 1.0
 *
 * @version 1.0
 *
 * @author gegf
 */
@Controller
public class AdminController {
//    @Autowired
//    private QiNiuService qiNiuService;
//
//    @Autowired
//    private Gson gson;
//
//    @Autowired
//    private AddressService addressService;
//
//    @Autowired
//    private HouseService houseService;

    @GetMapping("/admin/center")
    public String adminCenterPage(){
        return "admin/center";
    }

    @GetMapping("/admin/welcome")
    public String welcomePage(){
        return "admin/welcome";
    }

    @GetMapping("/admin/login")
    public String login(){
        return "admin/login";
    }

    @GetMapping("/admin/add/house")
    public String addHousePage(){
        return "admin/house-add";
    }

    /**
     * 房源列表页
     * @return
     */
    @GetMapping("admin/house/list")
    public String houseListPage() {
        return "admin/house-list";
    }

//    @ResponseBody
//    @PostMapping("admin/houses")
//    public DataTablesResponse houses(@ModelAttribute DataTableSearch search){
//        ServiceMultiResult<HouseDTO> result = houseService.adminQuery(search);
//        DataTablesResponse dataTablesResponse = new DataTablesResponse(StatusCode.SUCCESS.getCode());
//        dataTablesResponse.setData(result.getResult());
//        dataTablesResponse.setRecordsFiltered(result.getTotal());
//        dataTablesResponse.setRecordsTotal(result.getTotal());
//        dataTablesResponse.setDraw(search.getDraw());
//        return dataTablesResponse;
//    }
//
//    /**
//     * 上传图片接口
//     * @param file
//     * @return
//     */
//    @PostMapping(value = "admin/upload/photo", consumes = MediaType.MULTIPART_FORM_DATA_VALUE)
//    @ResponseBody
//    public ResponseEntity uploadPhoto(@RequestParam("file") MultipartFile file) {
//        if (file.isEmpty()) {
//            return ResponseEntity.createByErrorCodeMessage(StatusCode.NOT_VALID_PARAM);
//        }
//        try {
//            InputStream inputStream = file.getInputStream();
//            Response response = qiNiuService.uploadFile(inputStream);
//            if (response.isOK()) {
//                QiNiuPutRet ret = gson.fromJson(response.bodyString(), QiNiuPutRet.class);
//                return ResponseEntity.ofSuccess(ret);
//            } else {
//                return ResponseEntity.createByErrorCodeMessage(StatusCode.INTERNAL_SERVER_ERROR);
//            }
//
//        } catch (QiniuException e) {
//            Response response = e.response;
//            try {
//                return ResponseEntity.createByErrorCodeMessage(response.statusCode, response.bodyString());
//            } catch (QiniuException e1) {
//                e1.printStackTrace();
//                return ResponseEntity.createByErrorCodeMessage(StatusCode.INTERNAL_SERVER_ERROR);
//            }
//        } catch (IOException e) {
//            return ResponseEntity.createByErrorCodeMessage(StatusCode.INTERNAL_SERVER_ERROR);
//        }
//    }
//
//    @ResponseBody
//    @PostMapping("admin/add/house")
//    public ResponseEntity addHouse(@Valid @ModelAttribute("form-house-add") HouseForm houseForm,
//                                   BindingResult bindingResult){
//        if(bindingResult.hasErrors()){
//            return new ResponseEntity(HttpStatus.BAD_REQUEST.value(),
//                    bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
//        }
//        if(houseForm.getPhotos() == null || houseForm.getCover() == null){
//            return ResponseEntity.createByErrorCodeMessage(HttpStatus.BAD_REQUEST.value(), "图片必须上传");
//        }
//        Map<Level, SupportAddressDTO> map = addressService.findCityAndRegion(houseForm.getCityEnName(), houseForm.getRegionEnName());
//        if(map.keySet().size() != 2){
//            return ResponseEntity.createByErrorCodeMessage(StatusCode.NOT_VALID_PARAM);
//        }
//        ServiceResult<HouseDTO> result = houseService.save(houseForm);
//        if(result.isSuccess()){
//           return ResponseEntity.createBySuccess(result.getResult());
//        }else{
//            return ResponseEntity.createByErrorCodeMessage(StatusCode.NOT_VALID_PARAM);
//        }
//
//    }
//
//    @GetMapping("admin/house/edit")
//    public String houseEditPage(@RequestParam(value = "id") Long id, Model model){
//        if(id ==null || id < 1){
//            return "404";
//        }
//
//        ServiceResult<HouseDTO> serviceResult = houseService.findCompleteOne(id);
//        if(!serviceResult.isSuccess()){
//            return "404";
//        }
//
//        HouseDTO result = serviceResult.getResult();
//        model.addAttribute("house", result);
//
//        Map<Level, SupportAddressDTO> addressDTOMap = addressService.findCityAndRegion(result.getCityEnName(), result.getRegionEnName());
//        model.addAttribute("city", addressDTOMap.get(Level.CITY));
//        model.addAttribute("region", addressDTOMap.get(Level.REGION));
//
//        HouseDetailDTO detailDTO = result.getHouseDetail();
//        ServiceResult<SubwayDTO> subwayDTOServiceResult = addressService.findSubway(detailDTO.getSubwayLineId());
//        if(subwayDTOServiceResult.isSuccess()){
//            model.addAttribute("subway", subwayDTOServiceResult.getResult());
//        }
//        ServiceResult<SubwayStationDTO> subwayStationDTOServiceResult = addressService.findSubwayStation(detailDTO.getSubwayStationId());
//        if(subwayStationDTOServiceResult.isSuccess()){
//            model.addAttribute("station", subwayStationDTOServiceResult.getResult());
//        }
//        return "admin/house-edit";
//    }
//
//    /**
//     * 编辑接口
//     */
//    @PostMapping("admin/house/edit")
//    @ResponseBody
//    public ResponseEntity saveHouse(@Valid @ModelAttribute("form-house-edit") HouseForm houseForm, BindingResult bindingResult) {
//        if (bindingResult.hasErrors()) {
//            return new ResponseEntity(HttpStatus.BAD_REQUEST.value(), bindingResult.getAllErrors().get(0).getDefaultMessage(), null);
//        }
//
//        Map<Level, SupportAddressDTO> addressMap = addressService.findCityAndRegion(houseForm.getCityEnName(), houseForm.getRegionEnName());
//
//        if (addressMap.keySet().size() != 2) {
//            return ResponseEntity.ofSuccess(StatusCode.NOT_VALID_PARAM);
//        }
//
//        ServiceResult result = houseService.update(houseForm);
//        if (result.isSuccess()) {
//            return ResponseEntity.ofSuccess(null);
//        }
//
//        ResponseEntity response = ResponseEntity.createByErrorCodeMessage(StatusCode.BAD_REQUEST);
//        response.setMessage(result.getMessage());
//        return response;
//    }
//
//    /**
//     * 移除图片接口
//     * @param id
//     * @return
//     */
//    @DeleteMapping("admin/house/photo")
//    @ResponseBody
//    public ResponseEntity removeHousePhoto(@RequestParam(value = "id") Long id) {
//        ServiceResult result = this.houseService.removePhoto(id);
//
//        if (result.isSuccess()) {
//            return ResponseEntity.createBySuccess();
//        } else {
//            return ResponseEntity.createByErrorCodeMessage(HttpStatus.BAD_REQUEST.value(), result.getMessage());
//        }
//    }
//
//    /**
//     * 修改封面接口
//     * @param coverId
//     * @param targetId
//     * @return
//     */
//    @PostMapping("admin/house/cover")
//    @ResponseBody
//    public ResponseEntity updateCover(@RequestParam(value = "cover_id") Long coverId,
//                                   @RequestParam(value = "target_id") Long targetId) {
//        ServiceResult result = this.houseService.updateCover(coverId, targetId);
//
//        if (result.isSuccess()) {
//            return ResponseEntity.createBySuccess();
//        } else {
//            return ResponseEntity.createByErrorCodeMessage(HttpStatus.BAD_REQUEST.value(), result.getMessage());
//        }
//    }
//
//    /**
//     * 增加标签接口
//     * @param houseId
//     * @param tag
//     * @return
//     */
//    @PostMapping("admin/house/tag")
//    @ResponseBody
//    public ResponseEntity addHouseTag(@RequestParam(value = "house_id") Long houseId,
//                                   @RequestParam(value = "tag") String tag) {
//        if (houseId < 1 || Strings.isNullOrEmpty(tag)) {
//            return ResponseEntity.createByErrorCodeMessage(StatusCode.BAD_REQUEST);
//        }
//
//        ServiceResult result = this.houseService.addTag(houseId, tag);
//        if (result.isSuccess()) {
//            return ResponseEntity.createBySuccess();
//        } else {
//            return ResponseEntity.createByErrorCodeMessage(HttpStatus.BAD_REQUEST.value(), result.getMessage());
//        }
//    }
//
//    /**
//     * 移除标签接口
//     * @param houseId
//     * @param tag
//     * @return
//     */
//    @DeleteMapping("admin/house/tag")
//    @ResponseBody
//    public ResponseEntity removeHouseTag(@RequestParam(value = "house_id") Long houseId,
//                                      @RequestParam(value = "tag") String tag) {
//        if (houseId < 1 || Strings.isNullOrEmpty(tag)) {
//            return ResponseEntity.createByErrorCodeMessage(StatusCode.BAD_REQUEST);
//        }
//
//        ServiceResult result = this.houseService.removeTag(houseId, tag);
//        if (result.isSuccess()) {
//            return ResponseEntity.createBySuccess();
//        } else {
//            return ResponseEntity.createByErrorCodeMessage(HttpStatus.BAD_REQUEST.value(), result.getMessage());
//        }
//    }
//
//    /**
//     * 审核接口
//     * @param id
//     * @param operation
//     * @return
//     */
//    @PutMapping("admin/house/operate/{id}/{operation}")
//    @ResponseBody
//    public ResponseEntity operateHouse(@PathVariable(value = "id") Long id,
//                                    @PathVariable(value = "operation") int operation) {
//        if (id <= 0) {
//            return ResponseEntity.createByErrorCodeMessage(StatusCode.NOT_VALID_PARAM);
//        }
//        ServiceResult result;
//
//        switch (operation) {
//            case HouseOperation.PASS:
//                result = this.houseService.updateStatus(id, HouseStatus.PASSES.getValue());
//                break;
//            case HouseOperation.PULL_OUT:
//                result = this.houseService.updateStatus(id, HouseStatus.NOT_AUDITED.getValue());
//                break;
//            case HouseOperation.DELETE:
//                result = this.houseService.updateStatus(id, HouseStatus.DELETED.getValue());
//                break;
//            case HouseOperation.RENT:
//                result = this.houseService.updateStatus(id, HouseStatus.RENTED.getValue());
//                break;
//            default:
//                return ResponseEntity.createByErrorCodeMessage(StatusCode.BAD_REQUEST);
//        }
//
//        if (result.isSuccess()) {
//            return ResponseEntity.ofSuccess(null);
//        }
//        return ResponseEntity.createByErrorCodeMessage(HttpStatus.BAD_REQUEST.value(),
//                result.getMessage());
//    }

}

package com.kaltok.gogobest.demo.controller

import com.kaltok.gogobest.demo.model.NaviData
import com.kaltok.gogobest.demo.model.NaviInfo
import com.kaltok.gogobest.demo.response.NaviListResponse
import com.kaltok.gogobest.demo.response.NaviNickNameListResponse
import com.kaltok.gogobest.demo.response.NaviNumberListResponse
import com.kaltok.gogobest.demo.service.NaviInfoService
import org.springframework.beans.factory.annotation.Autowired
import org.springframework.stereotype.Controller
import org.springframework.web.bind.annotation.GetMapping
import org.springframework.web.bind.annotation.PostMapping
import org.springframework.web.bind.annotation.RequestParam
import org.springframework.web.bind.annotation.ResponseBody
import org.springframework.web.servlet.ModelAndView

@Controller
class NaviController {

    @Autowired
    lateinit var service: NaviInfoService

    @ResponseBody
    @PostMapping("/navi/new")
    fun add(naviData: NaviData): Long {
        val naviInfo = NaviInfo().apply {
            number = naviData.number
            nickName = naviData.nickName
            timeStamp = naviData.timeStamp
            geoLati = naviData.geoLati
            geoLong = naviData.geoLong
        }
        return service.add(naviInfo)
    }

    @ResponseBody
    @GetMapping("/navi/nickNameList")
    fun getNickNameList(): NaviNickNameListResponse {
        val allList = service.getAll()
        val nickNameList = service.getNickNameList(allList)
        return NaviNickNameListResponse("200", nickNameList)
    }

    @ResponseBody
    @GetMapping("/navi/numberList")
    fun getNumberList(): NaviNumberListResponse {
        val allList = service.getAll()
        val numberList = service.getNumberList(allList)
        return NaviNumberListResponse("200", numberList)
    }

    @ResponseBody
    @GetMapping("/navi/list")
    fun getList(
        @RequestParam(value = "number", defaultValue = "") number: String,
        @RequestParam(value = "nickName", defaultValue = "") nickName: String,
        @RequestParam(value = "count", defaultValue = "0") count: Int
    ): NaviListResponse {
        val paramMap = mutableMapOf<String, String>()
        if (number.isNotEmpty()) {
            paramMap["number"] = number
        }
        if (nickName.isNotEmpty()) {
            paramMap["nickName"] = nickName
        }

        val resultList = service.findListByParamMap(paramMap, count)

        return NaviListResponse("200", resultList)
    }

    @ResponseBody
    @PostMapping("/navi/clear")
    fun clear(): Boolean {
        service.deleteAll()
        return true
    }

    @GetMapping("/navi/map")
    fun showMap(
        @RequestParam(value = "number", defaultValue = "") number: String,
        @RequestParam(value = "nickName", defaultValue = "") nickName: String,
        @RequestParam(value = "count", defaultValue = "10") count: Int
    ): ModelAndView {
        val mv = ModelAndView("navi/navimap")

        val paramMap = mutableMapOf<String, String>()
        if (number.isNotEmpty()) {
            paramMap["number"] = number
        }
        if (nickName.isNotEmpty()) {
            paramMap["nickName"] = nickName
        }

        val resultList = service.findListByParamMap(paramMap, count)
        val allList = service.getAll()
        val nickNameList = service.getNickNameList(allList)
        val numberList = service.getNumberList(allList)

        mv.addObject("infoList", resultList)
        mv.addObject("lastInfo", resultList[0])
        mv.addObject("nickNameList", nickNameList)
        mv.addObject("numberList", numberList)
        return mv
    }
}


/*  참고
foreach

mv.addObject("infoList", service.getAll())
/*<![CDATA[*/

    /*[# th:each="tmp : ${infoList}"]*/
    console.log(/*[[${tmp.geoLati}]]*/)
    /*[/]*/

    /*]]*/




mv.addObject("testValue", "ksh_test")
/*<![CDATA[*/
    var result = /*[[ ${testValue} ]]*/;
    console.log(result)
    /*]]>*/
 */
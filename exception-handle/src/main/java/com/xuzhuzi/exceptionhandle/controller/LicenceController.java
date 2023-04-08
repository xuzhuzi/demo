package com.xuzhuzi.exceptionhandle.controller;

import com.xuzhuzi.exceptionhandle.enums.ResponseEnum;
import com.xuzhuzi.exceptionhandle.model.po.Licence;
import com.xuzhuzi.exceptionhandle.response.Response;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RequestParam;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/licence")
public class LicenceController {

	@GetMapping("/detail")
	public Response<Licence> detail(@RequestParam("id") Long id){
		// 从后台查询licence
		Licence licence = null;
		// 校验 licence 是否存在
		ResponseEnum.LICENCE_NOT_FOUND.assertNotNull(licence);
		return new Response(1, licence);
	}
}

/*
 * Copyright (c) 2018. paascloud.net All Rights Reserved.
 * 项目名称：paascloud快速搭建企业级分布式微服务平台
 * 类名称：MallUserController.java
 * 创建人：刘兆明
 * 联系方式：paascloud.net@gmail.com
 * 开源地址: https://github.com/paascloud
 * 博客地址: http://blog.paascloud.net
 * 项目官网: http://paascloud.net
 */

package com.paascloud.mall.controller;

import com.paascloud.core.support.BaseController;
import com.paascloud.provider.model.dto.user.UserInfoDto;
import com.paascloud.provider.model.service.MallUserFeignApi;
import com.paascloud.wrapper.WrapMapper;
import com.paascloud.wrapper.Wrapper;
import io.swagger.annotations.Api;
import io.swagger.annotations.ApiOperation;
import org.springframework.http.MediaType;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

import javax.annotation.Resource;

/**
 * The class Mall user controller.
 *
 * @author paascloud.net@gmail.com
 */
@RestController
@RequestMapping(value = "/user", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
@Api(value = "WEB - MallUserController", produces = MediaType.APPLICATION_JSON_UTF8_VALUE)
public class MallUserController extends BaseController {

	@Resource
	private MallUserFeignApi mallUserFeignApi;

	/**
	 * 更新用户信息.
	 *
	 * @param userInfoDto the user info dto
	 *
	 * @return the wrapper
	 */
	@PostMapping(value = "/updateInformation")
	@ApiOperation(httpMethod = "POST", value = "更新用户信息")
	public Wrapper<UserInfoDto> updateInformation(@RequestBody UserInfoDto userInfoDto) {
		mallUserFeignApi.updateInformation(userInfoDto);
		return WrapMapper.ok();
	}

	/**
	 * 获取用户信息.
	 *
	 * @return the information
	 */
	@PostMapping(value = "/getInformation")
	@ApiOperation(httpMethod = "POST", value = "获取用户信息")
	public Wrapper<UserInfoDto> getInformation() {
		mallUserFeignApi.getInformation();
		return WrapMapper.ok();
	}
}

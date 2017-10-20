package com.tqy.service;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.HashMap;
import java.util.Map;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;

import com.tqy.bean.Admin;
import com.tqy.dao.AdminMapper;

@Service
public class AdminService {
	
	@Autowired
	AdminMapper adminMapper;

	public Map<String, Object> adminLogin(Admin admin){
		Admin admin2 = adminMapper.adminLogin(admin);
		Map<String, Object> map = new HashMap<String,Object>();
		if (admin2 == null){
			map.put("id",-1);
		} else{
			map.put("id",admin2.getAdminId());
		}
		String time = admin2.getAdminLastTime();
		if (time == null){
			map.put("lastTime", null);
		} else {
			map.put("lastTime", time);
		}
		return map;
	}
	
	public boolean setLoginTime(int id){
		Admin admin = new Admin();
		admin.setAdminId(id);
		SimpleDateFormat format = new SimpleDateFormat("yyyy-MM-dd HH:mm:ss");
		String time = format.format(new Date());
		admin.setAdminLastTime(time);
		int flag = adminMapper.setLoginTime(admin);
		return flag == 1? true : false;
	}
}

package service;

import java.util.List;

import com.alibaba.fastjson.JSONArray;

import DAO.SensorDAO;
import Vo.SensorVo;


public class SensorService {
	
	public String getSensorVo(int page,int rows){
		String rtn = "{'total':0,'rows':[ ]}" ;
		SensorDAO sd = new SensorDAO();
		int total = sd.getSensorTotal();
		if(total>0){
			List<SensorVo> list = sd.getSensorVo(page, rows);
			String json_str = JSONArray.toJSONString(list);
			rtn =  "{\"total\":"+total+",\"rows\":"+json_str+"}" ;
		}
		return rtn;
	}
	
	public String getSensorVo(){
		String json_str = "";
		SensorDAO sd = new SensorDAO();
		int total = sd.getSensorTotal();
		if(total>0){
			List<SensorVo> list = sd.getSensorVo();
			json_str = JSONArray.toJSONString(list);
			
		}
		return json_str;
	}
	
	public static void main(String[] args){
		SensorService ss = new SensorService();
		String str = ss.getSensorVo();
		System.out.println(str);
	}
}

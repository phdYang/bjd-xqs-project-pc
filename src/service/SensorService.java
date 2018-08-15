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
	
	/**
	 * 根据传感器类型查询传感器
	 * @param page 当前页码
	 * @param rows 当前页面显示行数
	 * @param typeId 传感器类型
	 * @return
	 */
	public String getSensorVo(int page,int rows,int typeId){
		String rtn = "{'total':0,'rows':[ ]}" ;
		SensorDAO sd = new SensorDAO();
		int total = sd.getSensorTotal(typeId);
		if(total>0){
			List<SensorVo> list = sd.getSensorVo(page, rows,typeId);
			String json_str = JSONArray.toJSONString(list);
			rtn =  "{\"total\":"+total+",\"rows\":"+json_str+"}" ;
		}
		return rtn;
	}
	
	public String getSensorTypeVo() {
		String json_str = "";
		SensorDAO sd = new SensorDAO();
		List list = sd.getAllSensorTypeVo();
		json_str = JSONArray.toJSONString(list);
		return json_str;
	}
}

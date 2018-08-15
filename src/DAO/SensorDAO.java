package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Vo.SensorTypeVo;
import Vo.SensorVo;
import utils.BaseDAO;

public class SensorDAO {
	
	/**
	 *  所有的传感器
	 * @return 传感器总数
	 */
	public List getSensorVo(){
		List<SensorVo> svList = new ArrayList<SensorVo>();
 		Connection conn = BaseDAO.getConn();
		String sql = "SELECT SensorId,SensorName FROM t_sensor";
		try {
			PreparedStatement preStat = conn.prepareStatement(sql);
			ResultSet rs = preStat.executeQuery();
			while(rs.next()){
				SensorVo sv = new SensorVo();
				sv.setSensorId(rs.getInt(1));
				sv.setSensorName(rs.getString(2));
				svList.add(sv);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return svList;
	}
	/**
	 * 分页获取传感器表的id和传感器姓名
	 * @return 传感器列表
	 */
	public List getSensorVo(int page,int rows){
		List<SensorVo> svList = new ArrayList<SensorVo>();
 		Connection conn = BaseDAO.getConn();
 		int n = (page-1)*rows;
 		int m = rows;
		String sql = "SELECT a.SensorId,a.SensorName,b.TypeName "
				+ "FROM t_sensor a,t_sensor_type b "
				+ "where a.TypeId = b.TypeId limit ?,?";
		try {
			PreparedStatement preStat = conn.prepareStatement(sql);
			preStat.setInt(1, n);
			preStat.setInt(2, m);
			ResultSet rs = preStat.executeQuery();
			while(rs.next()){
				SensorVo sv = new SensorVo();
				sv.setSensorId(rs.getInt(1));
				sv.setSensorName(rs.getString(2));
				sv.setSensorType(rs.getString(3));
				svList.add(sv);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return svList;
	}
	
	/**
	 * 根据传感器类型查询传感器
	 * @param page 当前页码
	 * @param rows 当前页面显示行数
	 * @param typeId 传感器类型
	 * @return
	 */
	public List getSensorVo(int page,int rows,int typeId){
		List<SensorVo> svList = new ArrayList<SensorVo>();
 		Connection conn = BaseDAO.getConn();
 		int n = (page-1)*rows;
 		int m = rows;
		String sql = "SELECT a.SensorId,a.SensorName,b.TypeName "
				+ "FROM t_sensor a,t_sensor_type b "
				+ "where a.TypeId = b.TypeId and a.TypeId = ? limit ?,?";
		try {
			PreparedStatement preStat = conn.prepareStatement(sql);
			preStat.setInt(1, typeId);
			preStat.setInt(2, n);
			preStat.setInt(3, m);
			ResultSet rs = preStat.executeQuery();
			while(rs.next()){
				SensorVo sv = new SensorVo();
				sv.setSensorId(rs.getInt(1));
				sv.setSensorName(rs.getString(2));
				sv.setSensorType(rs.getString(3));
				svList.add(sv);
			}
	
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return svList;
	}
	
	
	/**
	 * 计算传感器总数
	 * @return 返回传感器的总条数
	 */
	public int getSensorTotal(){
		int total = 0;
 		Connection conn = BaseDAO.getConn();
		String sql = "SELECT count(*) FROM t_sensor";
		try {
			PreparedStatement preStat = conn.prepareStatement(sql);

			ResultSet rs = preStat.executeQuery();
			while(rs.next()){
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	/**
	 * 
	 * @param typeId
	 * @return
	 */
	public int getSensorTotal(int typeId){
		int total = 0;
 		Connection conn = BaseDAO.getConn();
		String sql = "SELECT count(*) FROM t_sensor where TypeId = ? ";
		try {
			PreparedStatement preStat = conn.prepareStatement(sql);
			preStat.setInt(1, typeId);
			ResultSet rs = preStat.executeQuery();
			while(rs.next()){
				total = rs.getInt(1);
			}
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return total;
	}
	
	/**
	 * 返回所有传感器的类别
	 * @return 传感器类别列表list[SensorTypeVo]
	 */
	public List getAllSensorTypeVo() {
		List<SensorTypeVo> stvList = new ArrayList<SensorTypeVo>();
 		Connection conn = BaseDAO.getConn();
		String sql = "SELECT TypeId,TypeName,Unit FROM t_sensor_type";
		try {
			PreparedStatement preStat = conn.prepareStatement(sql);
			ResultSet rs = preStat.executeQuery();
			while(rs.next()){
				SensorTypeVo stv = new SensorTypeVo();
				stv.setTypeId(rs.getInt(1));
				stv.setTypeName(rs.getString(2));
				stv.setUnit(rs.getString(3));
				stvList.add(stv);
			}
		
		} catch (SQLException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}
		return stvList;
	}
	
	
	
}

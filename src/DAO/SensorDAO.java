package DAO;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.ArrayList;
import java.util.List;

import Vo.SensorVo;
import utils.BaseDAO;

public class SensorDAO {
	
	/**
	 * ��ȡ���������id�ʹ���������
	 * @return �������б�
	 */
	public List getSensorVo(int page,int rows){
		List<SensorVo> svList = new ArrayList<SensorVo>();
 		Connection conn = BaseDAO.getConn();
 		int n = (page-1)*rows;
 		int m = rows;
		String sql = "SELECT SensorId,SensorName FROM t_sensor limit ?,?";
		try {
			PreparedStatement preStat = conn.prepareStatement(sql);
			preStat.setInt(1, n);
			preStat.setInt(2, m);
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
	
	public static void main(String[] args){
		SensorDAO sd = new SensorDAO();
//		List list = sd.getSensorVo(1,10);
//		for(int i = 0;i<list.size();i++){
//			System.out.println(list.get(i));
//		}
		System.out.println(sd.getSensorTotal());
	}
}

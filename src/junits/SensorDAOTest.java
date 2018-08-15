package junits;

import static org.junit.Assert.*;

import java.util.List;

import org.junit.Test;

import DAO.SensorDAO;

public class SensorDAOTest {

	@Test
	public void testGetSensorVoIntInt() {
		SensorDAO sd = new SensorDAO();
		List list = sd.getSensorVo(1,10);
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

	@Test
	public void testGetSensorTotal() {
		fail("Not yet implemented");
	}

	@Test
	public void testGetSensorVo() {
		fail("Not yet implemented");
	}
	
	@Test
	public void testGetAllSensorTypeVo() {
		SensorDAO sd = new SensorDAO();
		List list = sd.getAllSensorTypeVo();
		for (int i = 0; i < list.size(); i++) {
			System.out.println(list.get(i));
		}
	}

}

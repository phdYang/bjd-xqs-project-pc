package Vo;

public class SensorVo {
	private int sensorId;
	private String sensorName;
	public SensorVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SensorVo(int sensorId, String sensorName) {
		super();
		this.sensorId = sensorId;
		this.sensorName = sensorName;
	}
	public int getSensorId() {
		return sensorId;
	}
	public void setSensorId(int sensorId) {
		this.sensorId = sensorId;
	}
	public String getSensorName() {
		return sensorName;
	}
	public void setSensorName(String sensorName) {
		this.sensorName = sensorName;
	}
	@Override
	public String toString() {
		return "SensorVo [sensorId=" + sensorId + ", sensorName=" + sensorName + "]";
	}
	
}

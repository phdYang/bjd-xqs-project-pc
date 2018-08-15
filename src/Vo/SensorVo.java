package Vo;

public class SensorVo {
	private int sensorId;
	private String sensorName;
	private String sensorType;
	public SensorVo() {
		super();
		// TODO Auto-generated constructor stub
	}
	public SensorVo(int sensorId, String sensorName, String sensorType) {
		super();
		this.sensorId = sensorId;
		this.sensorName = sensorName;
		this.sensorType = sensorType;
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
	public String getSensorType() {
		return sensorType;
	}
	public void setSensorType(String sensorType) {
		this.sensorType = sensorType;
	}
	@Override
	public String toString() {
		return "SensorVo [sensorId=" + sensorId + ", sensorName=" + sensorName + ", sensorType=" + sensorType + "]";
	}
	
}

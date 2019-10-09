package com.uhf.structures;

import java.util.Arrays;

public class RwData
{
	public byte[] fromDev;          // 设备信息(对于串口为COMXX, 对于网络为xxx.xxx.xxx.xxx)
									// 内存分配/释放在lib层进行
	public int antennaPort = 0;	    // 天线号
	public int epcLen = 0; 			// EPC字节长度
	public byte[] epc; 	            // EPC信息
	public int rwDataLen = 0;	    // 读取到的数据长度
	public byte[] rwData;           // 读取到的数据
	public int rssi = 0;		    // RSSI
	public int status = 0;          // 返回的状态码
	public int type = 0;            // 读,写,锁,销毁类型

	
	public byte[] getFromDev() {
		return fromDev;
	}


	public void setFromDev(byte[] fromDev) {
		this.fromDev = fromDev;
	}


	public int getAntennaPort() {
		return antennaPort;
	}


	public void setAntennaPort(int antennaPort) {
		this.antennaPort = antennaPort;
	}


	public int getEpcLen() {
		return epcLen;
	}


	public void setEpcLen(int epcLen) {
		this.epcLen = epcLen;
	}


	public byte[] getEpc() {
		return epc;
	}


	public void setEpc(byte[] epc) {
		this.epc = epc;
	}


	public int getRwDataLen() {
		return rwDataLen;
	}


	public void setRwDataLen(int rwDataLen) {
		this.rwDataLen = rwDataLen;
	}


	public byte[] getRwData() {
		return rwData;
	}


	public void setRwData(byte[] rwData) {
		this.rwData = rwData;
	}


	public int getRssi() {
		return rssi;
	}


	public void setRssi(int rssi) {
		this.rssi = rssi;
	}


	public int getStatus() {
		return status;
	}


	public void setStatus(int status) {
		this.status = status;
	}


	public int getType() {
		return type;
	}


	public void setType(int type) {
		this.type = type;
	}


	@Override
	public String toString()
	{
		return "RwData{" +
				"fromDev=" + Arrays.toString(fromDev) +
				", antennaPort=" + antennaPort +
				", epcLen=" + epcLen +
				", epc=" + Arrays.toString(epc) +
				", rwDataLen=" + rwDataLen +
				", rwData=" + Arrays.toString(rwData) +
				", rssi=" + rssi +
				", status=" + status +
				", type=" + type +
				'}';
	}
}

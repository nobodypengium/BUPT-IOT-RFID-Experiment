package com.uhf.structures;

import java.util.Arrays;

/**
 * Description：
 * author：lei
 * date：2017/7/31 上午10:24
 */

public class InventoryData
{
	public byte[] fromDev;          // 设备信息(对于串口为COMXX, 对于网络为xxx.xxx.xxx.xxx)
	                                // 内存分配/释放在lib层进行
	public int antennaPort = 0;	    // 天线号
	public int pc = 0;		        // PC值
	public int epcLen = 0; 			// EPC字节长度
	public byte[] epc; 	            // EPC信息
	public int epc_crc = 0; 		// ecp的2字节CRC;
	public int externalDataLen = 0;	// TID/USR字节长度
	public byte[] externalData;     // TID/USR数据信息
	public int rssi = 0;		    // RSSI
    
    @Override
    public String toString()
    {
        return "InventoryData{" +
                "fromDev=" + Arrays.toString(fromDev) +
                ", antennaPort=" + antennaPort +
                ", pc=" + pc +
                ", epcLen=" + epcLen +
                ", epc=" + Arrays.toString(epc) +
                ", epc_crc=" + epc_crc +
                ", externalDataLen=" + externalDataLen +
                ", externalData=" + Arrays.toString(externalData) +
                ", rssi=" + rssi +
                '}';
    }

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

	public int getPc() {
		return pc;
	}

	public void setPc(int pc) {
		this.pc = pc;
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

	public int getEpc_crc() {
		return epc_crc;
	}

	public void setEpc_crc(int epc_crc) {
		this.epc_crc = epc_crc;
	}

	public int getExternalDataLen() {
		return externalDataLen;
	}

	public void setExternalDataLen(int externalDataLen) {
		this.externalDataLen = externalDataLen;
	}

	public byte[] getExternalData() {
		return externalData;
	}

	public void setExternalData(byte[] externalData) {
		this.externalData = externalData;
	}

	public int getRssi() {
		return rssi;
	}

	public void setRssi(int rssi) {
		this.rssi = rssi;
	}
    
    
}

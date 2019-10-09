package com.uhf.structures;

public class SerialNumber {
	public byte[] snData = new byte[64];
	public int snLen = 0;
	
	public void setValue(byte[] snData, int snLen) 
	{
		this.snData = snData;
		this.snLen = snLen;
	}
}

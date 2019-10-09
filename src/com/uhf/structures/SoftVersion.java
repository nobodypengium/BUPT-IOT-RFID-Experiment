package com.uhf.structures;

public class SoftVersion {
	public byte[] version = new byte[64];
	public int versionLen = 0;
	
	public void setValue(byte[] version, int versionLen) 
	{
		this.version = version;
		this.versionLen = versionLen;
	}
}

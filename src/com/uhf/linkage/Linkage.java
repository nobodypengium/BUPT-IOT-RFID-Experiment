package com.uhf.linkage;

import com.uhf.detailwith.InventoryDetailWith;
import com.uhf.detailwith.RwDataDetailWith;
import com.uhf.structures.InventoryArea;
import com.uhf.structures.InventoryData;
import com.uhf.structures.OnInventoryListener;
import com.uhf.structures.OnRwListener;
import com.uhf.structures.RwData;
import com.uhf.structures.SerialNumber;
import com.uhf.structures.SoftVersion;
import com.uhf.utils.StringUtils;

public class Linkage {
	private OnInventoryListener onInventoryListener;
	private OnRwListener onRwListener;
	private static String path;

	
	
	public Linkage(String strLibPath) {
		System.load(strLibPath + "\\uhf.dll");
		System.load(strLibPath + "\\uhfJni.dll");
//		System.load("D:\\dll\\uhf.dll");
//		System.load("D:\\dll\\uhfJni.dll");
	}

	public Linkage() {
		System.loadLibrary("uhf");
		System.loadLibrary("uhfJni");

	}

	// 实现单例模式,外部直接可以用instance调用
	private static Linkage instance = null;

	public static Linkage getInstance(String strLibPath) {
		if (instance == null) {
			instance = new Linkage(strLibPath);
		}
		return instance;
	}

	public static Linkage getInstance() {
		if (instance == null) {
			instance = new Linkage();
		}
		return instance;
	}

	public void setOnInventoryListener(OnInventoryListener onInventoryListener) {
		this.onInventoryListener = onInventoryListener;
	}

	public void setOnRwListener(OnRwListener onRwListener) {
		this.onRwListener = onRwListener;
	}

	// 初始化系统参数,uhf回调通过Listener传回
	public native int initRFID();

	public native int deinitRFID();

	public native int setRFModuleType(int moduleType);

	public native int setRFConnectMode(int flag);

	public native int openCom(String port, long baud);

	public native int closeCom();

	public native int setInventoryArea(InventoryArea inventoryArea);

	public native int getInventoryArea(InventoryArea inventoryArea);

	public native int getModuleSerialNumber(SerialNumber serialNumber);

	public native int getModuleSoftVersion(SoftVersion softVersion);

	public native int startInventory(int mode, int maskFlag);

	public native int stopInventory();

	public native int readTagSync(byte[] accessPassword, int memBank, int startAddr, int wordLen, int timeOutMs,
			RwData rwData);

	public native int writeTagSync(byte[] accessPassword, int memBank, int startAddr, int wordLen, byte[] pWriteData,
			int timeOutMs, RwData rwData);

	// 初始化方法，连接设备
	public static int initial(String port) {
		Linkage.getInstance().setRFModuleType(0);
		Linkage.getInstance().setRFConnectMode(0);
		if (Linkage.getInstance().initRFID() == 0) {
			// System.out.println("Init success!");
		} else {
			// System.out.println("初始化失败");
			return -1;
		}
		if (Linkage.getInstance().openCom(port, 115200L) == 0) {

			SerialNumber serialNumber = new SerialNumber();

			// System.out.println("Open com success!");

			if (Linkage.getInstance().getModuleSerialNumber(serialNumber) == 0) {
				String serialNo = com.uhf.utils.StringUtils.byteToHexString(serialNumber.snData, serialNumber.snLen);
				serialNo = StringUtils.convertHexToString(serialNo);
				// System.out.println("序列号" + serialNo);
			} else {
				System.out.println("序列号获取失败");
				return -1;
			}

			SoftVersion softVersion = new SoftVersion();
			if (Linkage.getInstance().getModuleSoftVersion(softVersion) == 0) {
				String versionNo = StringUtils.byteToHexString(softVersion.version, softVersion.versionLen);
				versionNo = StringUtils.convertHexToString(versionNo);
				// System.out.println("版本号" + versionNo);
			}
			InventoryDetailWith.getInstance().setListener(Linkage.getInstance());
			RwDataDetailWith.getInstance().setListener(Linkage.getInstance());
			// System.out.println("连接成功");
			return 0;
		} else {
			// System.out.println("打开串口失败");
			return -1;
		}

	}

	// 断开连接
	public static void deinit() {
		int status = Linkage.getInstance().closeCom();
		Linkage.getInstance().deinitRFID();
		if (status == 0) {
			System.out.println("断开成功");
			return;
		}
		System.out.println("断开失败");
	}

	/**
	 * RFID回调函数接口,目前处理盘点返回信息
	 */
	public void inventoryCallBack(InventoryData inventoryData) {
		if (inventoryData != null && onInventoryListener != null)
			onInventoryListener.getInventoryData(inventoryData);
	}

	/**
	 * RFID回调函数接口,处理读写返回信息
	 */
	public void rwCallBack(RwData rwData) {
		System.out.println("rwCallBack");
		if (rwData != null && onRwListener != null)
			onRwListener.getRwData(rwData);
	}

}

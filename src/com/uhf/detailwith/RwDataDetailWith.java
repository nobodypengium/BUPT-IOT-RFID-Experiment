package com.uhf.detailwith;

import com.uhf.linkage.Linkage;
import com.uhf.structures.OnRwListener;
import com.uhf.structures.RwData;

public class RwDataDetailWith implements OnRwListener {

	private static RwDataDetailWith rwDataDetailWith = new RwDataDetailWith();

	public static RwDataDetailWith getInstance() {
		return rwDataDetailWith;
	}

	public static RwData rw = new RwData();
	public static int flag = 0;

	@Override
	public void getRwData(RwData rwData) {
		System.out.println(rwData.toString());
		if (null != rwData) {
			flag = 1;
			rw = rwData;
		}
	}

	public void setListener(Linkage linkage) {
		linkage.setOnRwListener(this);
	}

}

package com.uhf.detailwith;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

import com.uhf.linkage.Linkage;
import com.uhf.structures.InventoryData;
import com.uhf.structures.OnInventoryListener;
import com.uhf.utils.StringUtils;

public class InventoryDetailWith implements OnInventoryListener {

	private static InventoryDetailWith inventoryDetailWith = new InventoryDetailWith();
	public static List<Map<String, Object>> list = new ArrayList<>();
	public static Long startTime;
	public static int tagCount;
	public static int totalCount;

	public static Map<String, String> inventoryMap = new HashMap<String, String>();

	public static InventoryDetailWith getInstance() {
		return inventoryDetailWith;
	}

	@Override
	public void getInventoryData(InventoryData inventoryData) {
		// System.out.println(inventoryData.toString());
		if (null != inventoryData) {
			String epc = "";
			String rss = "";
			String port = "";
			String tidUser = "";
			String key = "";
			String data = "";
			totalCount++;
			if (inventoryData.epcLen > 0) {
				epc = StringUtils.byteToHexString(inventoryData.epc,
						inventoryData.epcLen);
				rss = String.valueOf(inventoryData.rssi);
			}
			if (inventoryData.externalDataLen > 0) {
				tidUser = StringUtils.byteToHexString(
						inventoryData.externalData,
						inventoryData.externalDataLen);
			}
			port = String.valueOf(inventoryData.antennaPort);
			if (tidUser != null && tidUser != "") {
				key = "externalData";
				// data = tidUser;
				data = epc + tidUser;
			} else {
				key = "epc";
				data = epc;
			}
			if (inventoryMap.containsKey(data)) {
				// System.out.println("-----containsKey----" + epc
				// + "-----list----" + list.size());
				for (int i = 0; i < list.size(); i++) {
					String tempData = list.get(i).get("epc").toString() + list.get(i).get("externalData").toString();
					if (data.equals(tempData)) {
						String t = (String) list.get(i).get("count");
						t = String.valueOf(Integer.valueOf(t) + 1);
						list.get(i).put("count", t);
						break;
					}
				}
				if (!list.isEmpty()) {
					tagCount++;
				}

			} else {
				tagCount++;
				inventoryMap.put(data, data);
				Map<String, Object> map = new HashMap<>();
				map.put("antennaPort", port);
				map.put("epc", epc);
				map.put("externalData", tidUser);
				map.put("count", "1");
				map.put("rssi", rss);
				list.add(map);
				// System.out.println(list);
			}
		}

	}

	public void setListener(Linkage linkage) {
		linkage.setOnInventoryListener(this);
	}

}

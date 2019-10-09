package com.uhf.structures;

import com.uhf.linkage.Linkage;

/**
 * Description：
 * author：lei
 * date：2017/8/7 下午2:16
 */

public interface OnInventoryListener
{
    void getInventoryData(InventoryData inventoryData);
	void setListener(Linkage linkage);
}

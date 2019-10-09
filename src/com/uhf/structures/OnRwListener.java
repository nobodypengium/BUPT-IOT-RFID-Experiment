package com.uhf.structures;

import com.uhf.linkage.Linkage;

/**
 * Description：
 * author：lei
 * date：2017/8/9 上午10:15
 */

public interface OnRwListener
{
    void getRwData(RwData rwData);
    void setListener(Linkage linkage);
}

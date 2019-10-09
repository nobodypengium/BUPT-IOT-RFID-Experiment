package com.uhf.structures;

public class InventoryArea
{
    public int area;
    public int startAddr;
    public int wordLen;

    public void setValue(int area, int startAddr, int wordLen)
    {
        this.area = area;
        this.startAddr = startAddr;
        this.wordLen = wordLen;
    }
}

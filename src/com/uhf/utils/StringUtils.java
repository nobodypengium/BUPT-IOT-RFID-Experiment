package com.uhf.utils;

/**
 * Description： author：lei date：2017/8/7 下午3:09
 */

public class StringUtils {
	public static String byteToHexString(byte[] b, int length) {
		String ret = "";
		for (int i = 0; i < length; i++) {
			String hex = Integer.toHexString(b[i] & 0xFF);
			if (hex.length() == 1) {
				hex = '0' + hex;
			}
			ret += hex.toUpperCase();
		}
		return ret;
	}

	// 十六进制转换为ASCII码
	public static String convertHexToString(String hex) {

		StringBuilder sb = new StringBuilder();
		StringBuilder temp = new StringBuilder();

		// 49204c6f7665204a617661 split into two characters 49, 20, 4c...
		for (int i = 0; i < hex.length() - 1; i += 2) {

			// grab the hex in pairs
			String output = hex.substring(i, (i + 2));
			// convert hex to decimal
			int decimal = Integer.parseInt(output, 16);
			// convert the decimal to character
			sb.append((char) decimal);

			temp.append(decimal);
		}

		return sb.toString();
	}

	/**
	 * 16进制的字符串表示转成字节数组 sl
	 *
	 * @param hexString
	 *            16进制格式的字符串
	 * @return 转换后的字节数组
	 **/
	public static byte[] stringToByte(String hexString) {
		hexString = hexString.toLowerCase();
		int length = hexString.length();
		if (length % 2 != 0) {
			length = length + 1;
		}
		final byte[] byteArray = new byte[length / 2];
		int k = 0;
		for (int i = 0; i < byteArray.length; i++) {// 因为是16进制，最多只会占用4位，转换成字节需要两个16进制的字符，高位在先
			byte low;
			byte high = (byte) (Character.digit(hexString.charAt(k), 16) & 0xff);
			if ((k + 1) == hexString.length()) {
				low = 0;
			} else {
				low = (byte) (Character.digit(hexString.charAt(k + 1), 16) & 0xff);
			}
			byteArray[i] = (byte) (high << 4 | low);
			k += 2;
		}
		return byteArray;
	}

	/**
	 * 从时间(毫秒)中提取出时间(时:分:秒) 时间格式: 时:分
	 *
	 * @param millisecond
	 *            毫秒
	 * @return 时间字符串
	 */
	public static String getTimeFromMillisecond(Long millisecond) {
		String milli;
		long hours = millisecond / (60 * 60 * 1000); // 根据时间差来计算小时数
		long minutes = (millisecond - hours * (60 * 60 * 1000)) / (60 * 1000); // 根据时间差来计算分钟数
		long second = (millisecond - hours * (60 * 60 * 1000) - minutes * (60 * 1000)) / 1000; // 根据时间差来计算秒数
		long milliSecond = millisecond - hours * (60 * 60 * 1000) - minutes * (60 * 1000) - second * 1000; // 根据时间差来计算秒数
		if (milliSecond < 100) {
			milli = "0" + milliSecond;
		} else {
			milli = "" + milliSecond;
		}
		return hours + "时 " + minutes + "分" + second + "秒" + milli + "毫秒";
		// return hours + ":时 " + minutes + ":分 " + second + ":秒" + milli +
		// ":毫秒";
	}

	// 将127.0.0.1形式的IP地址转换成十进制整数，这里没有进行任何错误处理
	public static long ipToLong(String strIp) {
		long[] ip = new long[4];
		// 先找到IP地址字符串中.的位置
		int position1 = strIp.indexOf(".");
		int position2 = strIp.indexOf(".", position1 + 1);
		int position3 = strIp.indexOf(".", position2 + 1);
		// 将每个.之间的字符串转换成整型
		ip[0] = Long.parseLong(strIp.substring(0, position1));
		ip[1] = Long.parseLong(strIp.substring(position1 + 1, position2));
		ip[2] = Long.parseLong(strIp.substring(position2 + 1, position3));
		ip[3] = Long.parseLong(strIp.substring(position3 + 1));
		return (ip[0] << 24) + (ip[1] << 16) + (ip[2] << 8) + ip[3];
	}

	// 将十进制整数形式转换成127.0.0.1形式的ip地址
	public static String longToIP(long longIp) {
		StringBuffer sb = new StringBuffer("");
		// 直接右移24位
		sb.append(String.valueOf((longIp >>> 24)));
		sb.append(".");
		// 将高8位置0，然后右移16位
		sb.append(String.valueOf((longIp & 0x00FFFFFF) >>> 16));
		sb.append(".");
		// 将高16位置0，然后右移8位
		sb.append(String.valueOf((longIp & 0x0000FFFF) >>> 8));
		sb.append(".");
		// 将高24位置0
		sb.append(String.valueOf((longIp & 0x000000FF)));
		return sb.toString();
	}

	/**
	 * 把IP地址转化为int
	 * 
	 * @param ipAddr
	 * @return int
	 */
	public static byte[] ipToBytesByReg(String ipAddr) {
		byte[] ret = new byte[4];
		try {
			String[] ipArr = ipAddr.split("\\.");
			ret[0] = (byte) (Integer.parseInt(ipArr[0]) & 0xFF);
			ret[1] = (byte) (Integer.parseInt(ipArr[1]) & 0xFF);
			ret[2] = (byte) (Integer.parseInt(ipArr[2]) & 0xFF);
			ret[3] = (byte) (Integer.parseInt(ipArr[3]) & 0xFF);
			return ret;
		} catch (Exception e) {
			throw new IllegalArgumentException(ipAddr + " is invalid IP");
		}
	}

	/**
	 * 字节数组转化为IP
	 * 
	 * @param bytes
	 * @return int
	 */
	public static String bytesToIp(byte[] bytes) {
		return new StringBuffer().append(bytes[0] & 0xFF).append('.').append(bytes[1] & 0xFF).append('.')
				.append(bytes[2] & 0xFF).append('.').append(bytes[3] & 0xFF).toString();
	}

}

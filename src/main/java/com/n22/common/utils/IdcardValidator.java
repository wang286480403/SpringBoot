package com.n22.common.utils;

import java.util.StringTokenizer;

/**
 * @author wangsiyong
 * @description: 身份证验证工具类
 * @create: 2018-07-16 15:31
 */
public class IdcardValidator {

	//验证身份证格式
	public static boolean isValidatedIdcard(String idno){
		try{
			if(idno.length()!= 15 && idno.length() != 18){
				  return false;
		 	 }else if(idno.length() == 15 && !isNumberForID(idno)){ 
		 	      return false;
		      }else if (idno.length() == 18 && !isNumberForID(idno.substring(0,17))) {
		 	      return false;
		 	 }else if (idno.length() == 18 && !isNumberForID(idno.substring(17,18)) && !("X".equalsIgnoreCase(idno.substring(17,18)))) {
		 	      return false;
		      }else if(!isDateTimeString(getBirthFromID(idno))){
		    	  return false;
		      }else{
		          return true;
		     }
		}catch(Exception e){
			e.printStackTrace();
			return false;
		}
	}	
	
	private static boolean isNumberForID(String anum1) {
	    String numstr = "0123456789";
	    for(int i=0; i < anum1.length(); i++){
	        if(numstr.indexOf(anum1.charAt(i)) == -1)
	        {
	            return false;
	        }
	    }
	    return true;
	}
	
	
	public static String getBirthFromID(String idno){
		String nian="",yue="",ri="";
		if(idno.length()==15){
			nian="19"+idno.substring(6, 8);
			yue=idno.substring(8,10);
			ri=idno.substring(10,12);
		}else if(idno.length()==18){
			nian=idno.substring(6,10);
			yue=idno.substring(10,12);
			ri=idno.substring(12,14);
		}
		return nian+"-"+yue+"-"+ri;
	}
	
	
	public static boolean isDateTimeString(String sDate) {
		String separator = "-";
		StringTokenizer token = new StringTokenizer(sDate, separator);
		String year = token.nextToken();
		String month = token.nextToken();
		String day = token.nextToken();

		if (day.indexOf(" ") != -1) {
			String subday = day.substring(0, day.indexOf(" "));
			boolean is_date = isDate(year, month, subday);

			String time = day.substring(day.indexOf(" ") + 1);
			return is_date && isTime(time);
		} else {
			return isDate(year, month, day);
		}
	}    
	
	private static boolean isDate(String year, String month, String day) {
		return isDate(Integer.valueOf(year).intValue(),
				Integer.valueOf(month).intValue(),
				Integer.valueOf(day).intValue());

	}
	
	private static boolean isDate(int year, int month, int day) {
		int[] day_of_months = { 31, 28, 31, 30, 31, 30, 31, 31, 30, 31, 30, 31 };
		try {
			boolean bLeapYear = false;
			if ((year+"").length() != 4)
				return false;

			if (isLeapYear(year))
				day_of_months[1] = 29;
			if (month < 1 || month > 12)
				return false;
			if (day < 1 || day > day_of_months[month - 1])
				return false;
			return true;
		} catch (Throwable e) {
			e.printStackTrace();
			return false;
		}

	}	
	
	private static boolean isLeapYear(int year) {
		if (year % 4 != 0)
			return false;
		if ((year % 100 == 0) && (year % 400 != 0))
			return false;
		return true;
	}
	
	
	private static boolean isTime(String time) {

		if (time == null || time.equals(""))
			time = "00:00:00.000";

		String[] s = time.split(":");
		/**add by gxy,2010-4-8,如果s长度小于3，不符合时间要求**/
		if(s.length<3) return false;
		
		String[] s1 = null;
		//
		if(s[2].indexOf("\\.") !=-1){
			s1= s[2].split("\\.");
		}

		boolean ret = (Integer.parseInt(s[0]) < 24 && Integer.parseInt(s[1]) < 60);

		if (s1 != null && s1.length == 2) {
			ret = ret && Integer.parseInt(s1[0]) < 60
					&& Integer.parseInt(s1[1]) < 1000;
		} else if (s1 != null && s1.length == 0) {
			ret = ret && Integer.parseInt(s[2]) < 60;
		} else if(s1 != null){
			ret = false;
		}
		return ret;

	}	
	
	 /**
     * 根据身份编号获取性别
     *
     * @param idCard 身份编号
     * @return 性别(M-男，F-女，N-未知)
     */
    public static String getGenderByIdCard(String idCard) {
        String sGender = "未知";

        String sCardNum = idCard.substring(16, 17);
        if (Integer.parseInt(sCardNum) % 2 != 0) {
            sGender = "M";//男
        } else {
            sGender = "F";//女
        }
        return sGender;
    }

	
	public static void main(String[] args)
    {
		System.out.println(getGenderByIdCard("150103199901012067"));
    }
}
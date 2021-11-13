package com.rmgyantra.GenericUtility;

	import java.util.Date;
	import java.util.Random;

	public class JavaUtility {
		
		/**
		 * author @MD G MOHIDDIN
		 */
	/**
	 * This method is generate random number to avoid duplicates
	 * @return
	 */
		public static String getRandomData() {
			Random random=new Random();
			
			int ran = random.nextInt(1000);
			return ""+ran;	
		}
		
		/**
		 * This method is used to generate current date 
		 */
		public static String getCurrentDate() {
			Date date=new Date();
			String currentdate = date.toString();
			return currentdate;
	     }
		
		public static String getSystemDateAndTime()
		{
			Date date = new Date();
			String currentdateandtime= date.toString().replaceAll(" ","_").replace(":","_");
			return currentdateandtime;
			
		}
	}




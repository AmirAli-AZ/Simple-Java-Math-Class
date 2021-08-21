
package com.math;

import java.util.Random;
import android.content.Context;
import android.util.DisplayMetrics;
import android.content.res.Resources;
import java.io.File;
import java.text.DecimalFormat;

public class MathClass {
	
	   // π
	   public static final double PI = 3.14159265358979323846;
	
	    // Circle and cylinder
	    public static double perimeterCircle(double n){
			return n * (2.0 * PI);
		}
		public static double AreaCircle(double r){
		  return r* (r * PI);
		  
		}
		public static String getInfo(){
		  String information = "created by amir ali in Mon,16Aug 2021";
		  return information;
		}
		public static double CylindricalVolume(double radius , double height){
		   return AreaCircle(radius) * height;
		}
		public static double LAC(double radius , double height){
		  return perimeterCircle(radius) * height;
		}
		// get random numbers
		public static int getRandom(int min, int max) {
	      Random random = new Random();
	      return random.nextInt(max - min + 1) + min;
		}
		// find prime numbers
		public static boolean isPrime(double n){
		  boolean is_prime = true;
		  if (n == 1){
			 is_prime = false;
			 return false;
		  }else{
		  
			if (n == 2){
			 is_prime = true;
			 return true;
			}else{
			
			 for (int j = 2; j <= Math.sqrt(n); j++) { 
				 if (n % j == 0){
				  is_prime = false;
				  break;
				 }
			   
			 }
			 return is_prime;
			}
		  }
	    }
		// square
		public static double SquareEnvironment(double length){
		   return length * 4.0;
		}
		public static double SquareArea(double length){
		   return length * length;    
		}
        public static double SquareVolume(double length , double height){
		  return SquareArea(length) * height;
		}
		public static double LAS(double length , double height){
		  return SquareEnvironment(length) * height;
		}
		// device
        public static float convertDpToPixel(float dp, Context context){
          Resources resources = context.getResources();
          DisplayMetrics metrics = resources.getDisplayMetrics();
          float px = dp * (metrics.densityDpi / 160f);
          return px;
        }
		public static float convertPixelsToDp(float px ,Context context){
		  Resources resources = context.getResources();
		  DisplayMetrics metrics = resources.getDisplayMetrics();
		  float dp = px / (metrics.densityDpi / 160f);
		  return dp;
		}
        public static float getScreenXDpi() {
          return Resources.getSystem().getDisplayMetrics().xdpi;
        }
		public static float getScreenYDpi() {
          return Resources.getSystem().getDisplayMetrics().ydpi;
        }
		public static int getDisplayWidthPixels(Context context) {
	      return context.getResources().getDisplayMetrics().widthPixels;
		}

		public static int getDisplayHeightPixels(Context context) {
	      return context.getResources().getDisplayMetrics().heightPixels;
		}
		// Sphere
		public static double VolumeSphere(double radius){
		  double volume = (4.0/3.0)*PI*(radius*radius*radius);
		  return volume;
		}
		public static double AreaSphere(double radius){
		  double area_sphere = 4.0*PI*(radius*radius);
		  return area_sphere;
		}
		// file
        // convert bytes to kB , Mb , GB , TB, PB 
        public static String getFileSize(String path){
		  File file = new File(path);
          if (file.exists() && !file.isDirectory()) {
	          double filesize = getFileLength(path);
	          double B = 1024;
	          double KB = B * B;
	          double MB = B * (B * B);
	          double GB = B * (B * (B * B));
	          double TB = B * (B * (B * (B * B)));
	          String returnedSize = "";
	          if (filesize < B) {
			     returnedSize = String.valueOf((long)(filesize)).concat("B");
	          }
	          else {
			     if (filesize < KB) {
					 returnedSize = new DecimalFormat("0.00").format(filesize / B).concat("KB");
			     }
			     else {
					if (filesize < MB) {
						returnedSize = new DecimalFormat("0.00").format(filesize / KB).concat("MB");
					}
					else {
					   if (filesize < GB) {
						    returnedSize = new DecimalFormat("0.00").format(filesize / MB).concat("GB");
					   }
					   else {
						 if (filesize < TB) {
							 returnedSize = new DecimalFormat("0.00").format(filesize / GB).concat("TB");
						 }
						 else {
							returnedSize = new DecimalFormat("0.00").format(filesize / TB).concat("PB");
						 }
					   }
					}
			     }
	          }
	          return returnedSize;
          }
          else {
	        return "";

		  }
		}
        // bytes
        public static long getFileLength(String path){
			File file = new File(path);
			if (!file.exists()) return 0;
            return file.length();
		}
		// times
        // time unit method , if you want this method , first import , java.util.concurrent.TimeUnit
        /*public static long MinutesToMilliSeconds(long timeInput){
		*   return TimeUnit.MINUTES.toMillis(timeInput);
		*}
		*public static long SecondsToMinutes(long timeInput){
		*   return TimeUnit.SECONDS.toMinutes(timeInput);
		*}
		*public static long SecondsToMiliseconds(long timeInput){
		*   return TimeUnit.SECONDS.toMillis(timeInput);
		}*/
		
		
		public static double MilliSecondsToSeconds(double input){
		    return input / 1000;
		}
		public static double MilliSecondsToMinutes(double input){
		    return input / (1000 / 60);
		}
		public static double MilliSecondsToHours(double input){
		    return input / (1000 / (60 / 60));
		}
		public static double SecondsToMilliSeconds(double input){
			return input * 1000;
	    }
		public static double SecondsToMinutes(double input){
			return input / 60;
		}
		public static double SecondsToHours(double input){
			return input / (60 / 60);
		}
		public static double MinutesToMilliSeconds(double input){
			return input * (60 * 1000); 
		}
		public static double MinutesToSeconds(double input){
			return input * 60;
		}
		public static double MinutesToHours(double input){
		    return input / 60;
		}
		public static double HoursToMilliSeconds(double input){
			return input * (60 * (60 * 1000));
		}
		public static double HoursToSeconds(double input){
			return input * (60 * 60);
		}
		public static double HoursToMinutes(double input){
			return input * 60;
		}
}

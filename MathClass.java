package com.math;

import java.util.Random;
import android.content.Context;
import android.util.DisplayMetrics;
import android.content.res.Resources;

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

}

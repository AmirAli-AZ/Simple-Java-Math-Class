package com.math;

import java.util.Random;
import android.content.Context;
import android.util.DisplayMetrics;
import android.content.res.Resources;
import android.util.TypedValue;
import java.io.File;
import java.text.DecimalFormat;
import java.lang.Math;
import java.util.ArrayList;

// created by amir ali in Mon,16Aug 2021
// warning We need to create this class for all types of variables

public class MathClass {
	
	public static final double PI = 3.14159265358979323846;
	public static final double E = 2.7182818284590452354;
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
		double num = abs(n);
		if (num == 1){
			return false;
		}
		else{
			if (num == 2){
			     return true;
			}
			else{
				boolean is_prime = true;
				for (int j = 2; j <= Math.sqrt(num); j++) {
					if (num % j == 0){
						is_prime = false;
						break;
					}
				}
				return is_prime;
			}
		}
	}
	public static void PrimesList(double n , ArrayList<Double> list){
		double num = abs(n);
		for(int j = 2; j <= num; j++){
			if(isPrime(j)){
			   list.add(Double.valueOf(j));
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
	public static float getDip(Context context, int n){
        return TypedValue.applyDimension(TypedValue.COMPLEX_UNIT_DIP, n, context.getResources().getDisplayMetrics());
	}
	public static int getStatusBarHeight(Context context) { 
	    Resources resources = context.getResources();
		int result = 0;
        int resourceId = resources.getIdentifier("status_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId);
        } 
        return result;
	}
	public static int getNavBarHeight(Context context) {
        Resources resources = context.getResources();
		int result = 0;
        int resourceId = resources.getIdentifier("navigation_bar_height", "dimen", "android");
        if (resourceId > 0) {
            result = resources.getDimensionPixelSize(resourceId);
        } 
        return result;
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
		if (file.exists() && !file.isDirectory()){
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
			else{
				if (filesize < KB) {
					returnedSize = new DecimalFormat("0.00").format(filesize / B).concat("KB");
				}
				else {
					if (filesize < MB) {
						returnedSize = new DecimalFormat("0.00").format(filesize / KB).concat("MB");
					}
					else{
						if (filesize < GB) {
							returnedSize = new DecimalFormat("0.00").format(filesize / MB).concat("GB");
					    }
						else{
							if (filesize < TB) {
								returnedSize = new DecimalFormat("0.00").format(filesize / GB).concat("TB");
							}
							else{
								returnedSize = new DecimalFormat("0.00").format(filesize / TB).concat("PB");
							}
						}
					}
				}
			}
			return returnedSize;
		}
		else{
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
	public static double abs(double d){
	    return (d <= 0) ? 0 - d : d;
	}
    public static int abs(int i){
        return (i < 0) ? -i : i;
    }
	public static long abs(long l)  {
		return (l < 0) ? -l : l;
	}
	public static float abs(float f){
        return (f <= 0) ? 0 - f : f;
    }
	public static float percent(int score , int total){
		float percentage = (score * 100/ total);
		return percentage;
	}
	public static double min(double a , double b){
		if(a != a)
			return a;
		if (a == 0 && b == 0)
			return -(-a - b);
			return (a < b) ? a : b;
	}
	public static double max(double a , double b){
		if (a != a)
		   return a;
		if (a == 0 && b == 0)
		   return a - -b;
		   return (a > b) ? a : b;
	}
	public static double toRadians(double degrees){
		return (degrees * PI) / 180;
	}
	public static double toDegrees(double rads){
		return (rads * 180) / PI;
	}
	public static double sin(double x){
        double sin=x,term, numerator=x, denominator=1, xsquare=x*x, factorial=1, sign=-1;
        do{
            numerator *= xsquare;
            denominator=denominator*(factorial+1)*(factorial+2);
            factorial=factorial+2;
            term=numerator/denominator;
            sin=sin+(sign*term);
            sign*=-1;
        }while(term>0.00001);
        return sin;
    }
	public static int factorial(int n){
		if(n == 1){
		   return 1;
		}else{
		   return n * factorial(n - 1);
		}
		
	}
	public static boolean isDecimal(double num){
		boolean result = false;
		if(num % 1 != 0){
			result = true;
		}
		return result;
	}
	
	//Least Common Multiple
	public static long lcm(long x, long y){
		long a = abs(x);
		long b = abs(y);
		
        return a * (b / gcd(a, b));
	}

    //Greatest Common Divisor
    public static long gcd(long x, long y){
		long a = abs(x);
		long b = abs(y);
		
        while (b > 0)
		{
			long temp = b;
			b = a % b; 
			a = temp;
		}
		return a;

    }
}

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
import android.graphics.Color;
import java.util.NavigableMap;
import java.util.Map;
import java.util.TreeMap;

// created by amir ali in Mon,16Aug 2021
// Some of these methods are for Class StrictMath.

public class MathClass {

	public static final double PI = 3.14159265358979323846;
	public static final double E = 2.7182818284590452354;


	private static final double TWO_31 = 0x80000000L, // Long bits 0x41e0000000000000L.
	TWO_52 = 0x10000000000000L, // Long bits 0x4330000000000000L.
	TWO_54 = 0x40000000000000L, // Long bits 0x4350000000000000L.
	TWO_64 = 1.8446744073709552e19; // Long bits 0x7fe0000000000000L.
    private static final double L1 = 0.5999999999999946, // Long bits 0x3fe3333333333303L.
	L2 = 0.4285714285785502, // Long bits 0x3fdb6db6db6fabffL.
	L3 = 0.33333332981837743, // Long bits 0x3fd55555518f264dL.
	L4 = 0.272728123808534, // Long bits 0x3fd17460a91d4101L.
	L5 = 0.23066074577556175, // Long bits 0x3fcd864a93c9db65L.
	L6 = 0.20697501780033842, // Long bits 0x3fca7e284a454eefL.
	P1 = 0.16666666666666602, // Long bits 0x3fc555555555553eL.
	P2 = -2.7777777777015593e-3, // Long bits 0xbf66c16c16bebd93L.
	P3 = 6.613756321437934e-5, // Long bits 0x3f11566aaf25de2cL.
	P4 = -1.6533902205465252e-6, // Long bits 0xbebbbd41c5d26bf1L.
	P5 = 4.1381367970572385e-8, // Long bits 0x3e66376972bea4d0L.
	DP_H = 0.5849624872207642, // Long bits 0x3fe2b80340000000L.
	DP_L = 1.350039202129749e-8, // Long bits 0x3e4cfdeb43cfd006L.
	OVT = 8.008566259537294e-17; // Long bits 0x3c971547652b82feL.
    private static final double SQRT_1_5 = 1.224744871391589, // Long bits 0x3ff3988e1409212eL.
	SQRT_3 = 1.7320508075688772, // Long bits 0x3ffbb67ae8584caaL.
	CP = 0.9617966939259756, // Long bits 0x3feec709dc3a03fdL.
	CP_H = 0.9617967009544373, // Long bits 0x3feec709e0000000L.
	CP_L = -7.028461650952758e-9, // Long bits 0xbe3e2fe0145b01f5L.
	LN2 = 0.6931471805599453, // Long bits 0x3fe62e42fefa39efL.
	LN2_H = 0.6931471803691238, // Long bits 0x3fe62e42fee00000L.
	LN2_L = 1.9082149292705877e-10, // Long bits 0x3dea39ef35793c76L.
	INV_LN2 = 1.4426950408889634, // Long bits 0x3ff71547652b82feL.
	INV_LN2_H = 1.4426950216293335, // Long bits 0x3ff7154760000000L.
	INV_LN2_L = 1.9259629911266175e-8; // Long bits 0x3e54ae0bf85ddf44L.
	
	
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
	// random
	public static int getRandom(int min, int max) {
	    return RandomGenerator.random.nextInt(max - min + 1) + min;
	}
	public static int getRandomColors(){
		int color = Color.argb(255, RandomGenerator.random.nextInt(256), RandomGenerator.random.nextInt(256), RandomGenerator.random.nextInt(256));
		return color;
	}
	public static double random(){
		return RandomGenerator.random.nextDouble();
	}
	// find prime numbers
	public static boolean isPrime(Long n){
		long num = abs(n);
		if (num == 1){
			return false;
		}
		else{
			if (num == 2){
				return true;
			}
			else{
				boolean is_prime = true;
				for (long j = 2; j <= sqrt(num); j++) {
					if (num % j == 0){
						is_prime = false;
						break;
					}
				}
				return is_prime;
			}
		}
	}
	
	public static long nextPrime(long n) {
		long num = abs(n);
		num++;
		for (int i = 2; i < num; i++) {
			if(num%i == 0) {
				num++;
				i=2;
			} else {
				continue;
			}
		}
		return num;
	}
	
	public static ArrayList<Long> primesList(long n){
		ArrayList<Long> list = new ArrayList<>();
		long num = abs(n);
		for(long j = 2; j <= num; j++){
			if(isPrime(j)){
				list.add((j));
			}
		}
		return list;
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
	private static long getFileLength(String path){
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
		return MilliSecondsToSeconds(input) / 60;
	}
	public static double MilliSecondsToHours(double input){
		return MilliSecondsToMinutes(input) / 60;
	}
	public static double SecondsToMilliSeconds(double input){
		return input * 1000;
	}
	public static double SecondsToMinutes(double input){
		return input / 60;
	}
	public static double SecondsToHours(double input){
		return SecondsToMinutes(input) / 60;
	}
	public static double MinutesToMilliSeconds(double input){
		return input * 60 * 1000;
	}
	public static double MinutesToSeconds(double input){
		return input * 60;
	}
	public static double MinutesToHours(double input){
		return input / 60;
	}
	public static double HoursToMilliSeconds(double input){
		return MinutesToMilliSeconds(input) * 60;
	}
	public static double HoursToSeconds(double input){
		return input * 60 * 60;
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
	public static int min(int a, int b){
		return (a < b) ? a : b; 
	}
	public static long min(long a, long b){
		return (a < b) ? a : b;
	}
	public static float min(float a, float b){
		if (a != a)
			return a;

		if (a == 0 && b == 0)
			return -(-a - b);
		return (a < b) ? a : b;
	}
	public static double min(double a , double b){
		if(a != a)
			return a;
		if (a == 0 && b == 0)
			return -(-a - b);
		return (a < b) ? a : b;
	}
	public static int max(int a, int b){
		return (a > b) ? a : b;
	} 
	public static long max(long a, long b){
		return (a > b) ? a : b;
	}
	public static float max(float a, float b){
		if (a != a)
			return a;

		if (a == 0 && b == 0)
			return a - -b;
		return (a > b) ? a : b;
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
	public static ArrayList<Long> primeFactors(long numbers) {
		ArrayList<Long> list = new ArrayList<>();
		long n = abs(numbers);
		for (long i = 2; i <= n / i; i++) {
			while (n % i == 0) {
				list.add(i);
				n /= i;
			}
		}
		if (n > 1) {
			list.add(n);
		}
	    return list;
	}
	public static long factorial(long n){
		long num = abs(n);

		if(num == 1){
			return 1;
		}else{
			return num * factorial(num - 1);
		}

	}
	public static ArrayList<Long> listFactors(long numbers){
		ArrayList<Long> list = new ArrayList<>();
		long n = abs(numbers);
		for(long a = 1; a <= n; a++){
			if(n % a == 0){
				list.add(a);
			}
		}
		return list;

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
	public static int round(float f){
		return (int) floor(f + 0.5f);
	}
	public static long round(double d){
		return (long) floor(d + 0.5);
	}
	public static double floor(double a){
		double x = abs(a);
		if (! (x < TWO_52) || (long) a == a)
			return a;
		if (x < 1) 
			return a >= 0 ? 0 * a : -1; 
	    return a < 0 ? (long) a - 1.0 : (long) a;
	}
	public static double ceil(double a){
		return -floor(-a);
	}
	public static long GaussSeidel(long n){
		return (n * (n + 1)) / 2;
	}
	// number format
	private static final NavigableMap<Long, String> suffixes = new TreeMap<> ();
	static {
		suffixes.put(1_000L, "K");
		suffixes.put(1_000_000L, "M");
		suffixes.put(1_000_000_000L, "G");
		suffixes.put(1_000_000_000_000L, "T");
		suffixes.put(1_000_000_000_000_000L, "P");
		suffixes.put(1_000_000_000_000_000_000L, "E");
	}

	public static String format(long value) {
		//Long.MIN_VALUE == -Long.MIN_VALUE so we need an adjustment here
		if (value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1);
		if (value < 0) return "-" + format(-value);
		if (value < 1000) return Long.toString(value); //deal with easy case

		Map.Entry<Long, String> e = suffixes.floorEntry(value);
		Long divideBy = e.getKey();
		String suffix = e.getValue();
 
		long truncated = value / (divideBy / 10); //the number part of the output times 10
		boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
		return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
	}
	public static double ulp(double d){
		return Math.ulp(d);
	}
	public static float ulp(float f){
		return Math.ulp(f);
	}
	public static double log(double x) {
        return 1000.0 * (pow(x, (1 / 1000.0)) - 1);
    }

    public static double log10(double x) {
        return log(x) / log(10);
    }
	
	public static double pow(double x, double y){
		// Special cases first.
		if (y == 0)
			return 1;
		if (y == 1)
			return x;
		if (y == -1)
			return 1 / x;
		if (x != x || y != y)
			return Double.NaN;

		// When x < 0, yisint tells if y is not an integer (0), even(1),
		// or odd (2).
		int yisint = 0;
		if (x < 0 && floor(y) == y)
			yisint = (y % 2 == 0) ? 2 : 1;
		double ax = abs(x);
		double ay = abs(y);

		// More special cases, of y.
		if (ay == Double.POSITIVE_INFINITY)
		{
			if (ax == 1)
				return Double.NaN;
			if (ax > 1)
				return y > 0 ? y : 0;
			return y < 0 ? -y : 0;
		}
		if (y == 2)
			return x * x;
		if (y == 0.5)
			return sqrt(x);

		// More special cases, of x.
		if (x == 0 || ax == Double.POSITIVE_INFINITY || ax == 1)
		{
			if (y < 0)
				ax = 1 / ax;
			if (x < 0)
			{
				if (x == -1 && yisint == 0)
					ax = Double.NaN;
				else if (yisint == 1)
					ax = -ax;
			}
			return ax;
		}
		if (x < 0 && yisint == 0)
			return Double.NaN;

		// Now we can start!
		double t;
		double t1;
		double t2;
		double u;
		double v;
		double w;
		if (ay > TWO_31)
		{
			if (ay > TWO_64) // Automatic over/underflow.
				return ((ax < 1) ? y < 0 : y > 0) ? Double.POSITIVE_INFINITY : 0;
			// Over/underflow if x is not close to one.
			if (ax < 0.9999995231628418)
				return y < 0 ? Double.POSITIVE_INFINITY : 0;
			if (ax >= 1.0000009536743164)
				return y > 0 ? Double.POSITIVE_INFINITY : 0;
			// Now |1-x| is <= 2**-20, sufficient to compute
			// log(x) by x-x^2/2+x^3/3-x^4/4.
			t = x - 1;
			w = t * t * (0.5 - t * (1 / 3.0 - t * 0.25));
			u = INV_LN2_H * t;
			v = t * INV_LN2_L - w * INV_LN2;
			t1 = (float) (u + v);
			t2 = v - (t1 - u);
		}
		else
		{
			long bits = Double.doubleToLongBits(ax);
			int exp = (int) (bits >> 52);
			if (exp == 0) // Subnormal x.
			{
				ax *= TWO_54;
				bits = Double.doubleToLongBits(ax);
				exp = (int) (bits >> 52) - 54;
			}
			exp -= 1023; // Unbias exponent.
			ax = Double.longBitsToDouble((bits & 0x000fffffffffffffL)
										 | 0x3ff0000000000000L);
			boolean k;
			if (ax < SQRT_1_5)  // |x|<sqrt(3/2).
				k = false;
			else if (ax < SQRT_3) // |x|<sqrt(3).
				k = true;
			else
			{
				k = false;
				ax *= 0.5;
				exp++;
			}

			// Compute s = s_h+s_l = (x-1)/(x+1) or (x-1.5)/(x+1.5).
			u = ax - (k ? 1.5 : 1);
			v = 1 / (ax + (k ? 1.5 : 1));
			double s = u * v;
			double s_h = (float) s;
			double t_h = (float) (ax + (k ? 1.5 : 1));
			double t_l = ax - (t_h - (k ? 1.5 : 1));
			double s_l = v * ((u - s_h * t_h) - s_h * t_l);
			// Compute log(ax).
			double s2 = s * s;
			double r = s_l * (s_h + s) + s2 * s2
				* (L1 + s2 * (L2 + s2 * (L3 + s2 * (L4 + s2 * (L5 + s2 * L6)))));
			s2 = s_h * s_h;
			t_h = (float) (3.0 + s2 + r);
			t_l = r - (t_h - 3.0 - s2);
			// u+v = s*(1+...).
			u = s_h * t_h;
			v = s_l * t_h + t_l * s;
			// 2/(3log2)*(s+...).
			double p_h = (float) (u + v);
			double p_l = v - (p_h - u);
			double z_h = CP_H * p_h;
			double z_l = CP_L * p_h + p_l * CP + (k ? DP_L : 0);
			// log2(ax) = (s+..)*2/(3*log2) = exp + dp_h + z_h + z_l.
			t = exp;
			t1 = (float) (z_h + z_l + (k ? DP_H : 0) + t);
			t2 = z_l - (t1 - t - (k ? DP_H : 0) - z_h);
		}

		// Split up y into y1+y2 and compute (y1+y2)*(t1+t2).
		boolean negative = x < 0 && yisint == 1;
		double y1 = (float) y;
		double p_l = (y - y1) * t1 + y * t2;
		double p_h = y1 * t1;
		double z = p_l + p_h;
		if (z >= 1024) // Detect overflow.
		{
			if (z > 1024 || p_l + OVT > z - p_h)
				return negative ? Double.NEGATIVE_INFINITY
					: Double.POSITIVE_INFINITY;
		}
		else if (z <= -1075) // Detect underflow.
		{
			if (z < -1075 || p_l <= z - p_h)
				return negative ? -0.0 : 0;
		}

		// Compute 2**(p_h+p_l).
		int n = round((float) z);
		p_h -= n;
		t = (float) (p_l + p_h);
		u = t * LN2_H;
		v = (p_l - (t - p_h)) * LN2 + t * LN2_L;
		z = u + v;
		w = v - (z - u);
		t = z * z;
		t1 = z - t * (P1 + t * (P2 + t * (P3 + t * (P4 + t * P5))));
		double r = (z * t1) / (t1 - 2) - (w + z * w);
		z = scale(1 - (r - z), n);
		return negative ? -z : z;
	}
	
	public static double sqrt(double x){
		if (x < 0)
			return Double.NaN;
		if (x == 0 || ! (x < Double.POSITIVE_INFINITY))
			return x;

		// Normalize x.
		long bits = Double.doubleToLongBits(x);
		int exp = (int) (bits >> 52);
		if (exp == 0) // Subnormal x.
		{
			x *= TWO_54;
			bits = Double.doubleToLongBits(x);
			exp = (int) (bits >> 52) - 54;
		}
		exp -= 1023; // Unbias exponent.
		bits = (bits & 0x000fffffffffffffL) | 0x0010000000000000L;
		if ((exp & 1) == 1) // Odd exp, double x to make it even.
			bits <<= 1;
		exp >>= 1;

		// Generate sqrt(x) bit by bit.
		bits <<= 1;
		long q = 0;
		long s = 0;
		long r = 0x0020000000000000L; // Move r right to left.
		while (r != 0)
		{
			long t = s + r;
			if (t <= bits)
			{
				s = t + r;
				bits -= t;
				q += r;
			}
			bits <<= 1;
			r >>= 1;
		}

		// Use floating add to round correctly.
		if (bits != 0)
			q += q & 1;
		return Double.longBitsToDouble((q >> 1) + ((exp + 1022L) << 52));
	}
	
	private static double scale(double x, int n){
		/* if (Configuration.DEBUG && abs(n) >= 2048)
			throw new InternalError("Assertion failure"); */
		if (x == 0 || x == Double.NEGATIVE_INFINITY
			|| ! (x < Double.POSITIVE_INFINITY) || n == 0)
			return x;
		long bits = Double.doubleToLongBits(x);
		int exp = (int) (bits >> 52) & 0x7ff;
		if (exp == 0) // Subnormal x.
		{
			x *= TWO_54;
			exp = ((int) (Double.doubleToLongBits(x) >> 52) & 0x7ff) - 54;
		}
		exp += n;
		if (exp > 0x7fe) // Overflow.
			return Double.POSITIVE_INFINITY * x;
		if (exp > 0) // Normal.
			return Double.longBitsToDouble((bits & 0x800fffffffffffffL)
										   | ((long) exp << 52));
		if (exp <= -54)
			return 0 * x; // Underflow.
		exp += 54; // Subnormal result.
		x = Double.longBitsToDouble((bits & 0x800fffffffffffffL)
									| ((long) exp << 52));
		return x * (1 / TWO_54);
	}
	
	private static final class RandomGenerator {
		static final Random random = new Random();
	}
	
} 

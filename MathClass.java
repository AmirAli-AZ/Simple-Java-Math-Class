package com.math;

import android.content.Context;
import android.content.res.Resources;
import android.graphics.Color;
import android.util.DisplayMetrics;
import android.util.TypedValue;
import java.io.File;
import java.text.DecimalFormat;
import java.util.ArrayList;
import java.util.Map;
import java.util.NavigableMap;
import java.util.Random;
import java.util.TreeMap;

// created by amir ali in Mon,16Aug 2021

public class MathClass {

    public static final double PI = 3.14159265358979323846;
    public static final double E = 2.7182818284590452354;

    private static final double longBit = 0x10000000000000L;
    // Circle and cylinder
    public static double perimeterCircle(double n) {
        return n * (2.0 * PI);
    }

    public static double AreaCircle(double r) {
        return r * (r * PI);
    }

    public static String getInfo() {
        String information = "created by amir ali in Mon,16Aug 2021";
        return information;
    }

    public static double CylindricalVolume(double radius, double height) {
        return AreaCircle(radius) * height;
    }

    public static double LAC(double radius, double height) {
        return perimeterCircle(radius) * height;
    }
    // random
    public static int getRandom(int min, int max) {
        Random random = new Random();
        return random.nextInt(max - min + 1) + min;
    }

    public static int getRandomColors() {
        Random random = new Random();
        int color = Color.argb(255, random.nextInt(256), random.nextInt(256), random.nextInt(256));
        return color;
    }
    // find prime numbers
    public static boolean isPrime(Long n) {
        long num = abs(n);
        if (num == 1) {
            return false;
        } else {
            if (num == 2) {
                return true;
            } else {
                boolean is_prime = true;
                for (long j = 2; j <= Math.sqrt(num); j++) {
                    if (num % j == 0) {
                        is_prime = false;
                        break;
                    }
                }
                return is_prime;
            }
        }
    }

    public static ArrayList<Long> primesList(long n) {
        ArrayList<Long> list = new ArrayList<>();
        long num = abs(n);
        for (long j = 2; j <= num; j++) {
            if (isPrime(j)) {
                list.add((j));
            }
        }
        return list;
    }
    // square
    public static double SquareEnvironment(double length) {
        return length * 4.0;
    }

    public static double SquareArea(double length) {
        return length * length;
    }

    public static double SquareVolume(double length, double height) {
        return SquareArea(length) * height;
    }

    public static double LAS(double length, double height) {
        return SquareEnvironment(length) * height;
    }
    // device
    public static float convertDpToPixel(float dp, Context context) {
        Resources resources = context.getResources();
        DisplayMetrics metrics = resources.getDisplayMetrics();
        float px = dp * (metrics.densityDpi / 160f);
        return px;
    }

    public static float convertPixelsToDp(float px, Context context) {
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

    public static float getDip(Context context, int n) {
        return TypedValue.applyDimension(
                TypedValue.COMPLEX_UNIT_DIP, n, context.getResources().getDisplayMetrics());
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
    public static double VolumeSphere(double radius) {
        double volume = (4.0 / 3.0) * PI * (radius * radius * radius);
        return volume;
    }

    public static double AreaSphere(double radius) {
        double area_sphere = 4.0 * PI * (radius * radius);
        return area_sphere;
    }
    // file
    // convert bytes to kB , Mb , GB , TB, PB
    public static String getFileSize(String path) {
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
                returnedSize = String.valueOf((long) (filesize)).concat("B");
            } else {
                if (filesize < KB) {
                    returnedSize = new DecimalFormat("0.00").format(filesize / B).concat("KB");
                } else {
                    if (filesize < MB) {
                        returnedSize = new DecimalFormat("0.00").format(filesize / KB).concat("MB");
                    } else {
                        if (filesize < GB) {
                            returnedSize =
                                    new DecimalFormat("0.00").format(filesize / MB).concat("GB");
                        } else {
                            if (filesize < TB) {
                                returnedSize =
                                        new DecimalFormat("0.00")
                                                .format(filesize / GB)
                                                .concat("TB");
                            } else {
                                returnedSize =
                                        new DecimalFormat("0.00")
                                                .format(filesize / TB)
                                                .concat("PB");
                            }
                        }
                    }
                }
            }
            return returnedSize;
        } else {
            return "";
        }
    }
    // bytes
    public static long getFileLength(String path) {
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
    public static double MilliSecondsToSeconds(double input) {
        return input / 1000;
    }

    public static double MilliSecondsToMinutes(double input) {
        return input / (1000 / 60);
    }

    public static double MilliSecondsToHours(double input) {
        return input / (1000 / (60 / 60));
    }

    public static double SecondsToMilliSeconds(double input) {
        return input * 1000;
    }

    public static double SecondsToMinutes(double input) {
        return input / 60;
    }

    public static double SecondsToHours(double input) {
        return input / (60 / 60);
    }

    public static double MinutesToMilliSeconds(double input) {
        return input * (60 * 1000);
    }

    public static double MinutesToSeconds(double input) {
        return input * 60;
    }

    public static double MinutesToHours(double input) {
        return input / 60;
    }

    public static double HoursToMilliSeconds(double input) {
        return input * (60 * (60 * 1000));
    }

    public static double HoursToSeconds(double input) {
        return input * (60 * 60);
    }

    public static double HoursToMinutes(double input) {
        return input * 60;
    }

    public static double abs(double d) {
        return (d <= 0) ? 0 - d : d;
    }

    public static int abs(int i) {
        return (i < 0) ? -i : i;
    }

    public static long abs(long l) {
        return (l < 0) ? -l : l;
    }

    public static float abs(float f) {
        return (f <= 0) ? 0 - f : f;
    }

    public static float percent(int score, int total) {
        float percentage = (score * 100 / total);
        return percentage;
    }

    public static int min(int a, int b) {
        return (a < b) ? a : b;
    }

    public static long min(long a, long b) {
        return (a < b) ? a : b;
    }

    public static float min(float a, float b) {
        if (a != a) return a;

        if (a == 0 && b == 0) return -(-a - b);
        return (a < b) ? a : b;
    }

    public static double min(double a, double b) {
        if (a != a) return a;
        if (a == 0 && b == 0) return -(-a - b);
        return (a < b) ? a : b;
    }

    public static int max(int a, int b) {
        return (a > b) ? a : b;
    }

    public static long max(long a, long b) {
        return (a > b) ? a : b;
    }

    public static float max(float a, float b) {
        if (a != a) return a;

        if (a == 0 && b == 0) return a - -b;
        return (a > b) ? a : b;
    }

    public static double max(double a, double b) {
        if (a != a) return a;
        if (a == 0 && b == 0) return a - -b;
        return (a > b) ? a : b;
    }

    public static double toRadians(double degrees) {
        return (degrees * PI) / 180;
    }

    public static double toDegrees(double rads) {
        return (rads * 180) / PI;
    }

    public static double sin(double x) {
        double sin = x,
                term,
                numerator = x,
                denominator = 1,
                xsquare = x * x,
                factorial = 1,
                sign = -1;
        do {
            numerator *= xsquare;
            denominator = denominator * (factorial + 1) * (factorial + 2);
            factorial = factorial + 2;
            term = numerator / denominator;
            sin = sin + (sign * term);
            sign *= -1;
        } while (term > 0.00001);
        return sin;
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

    public static long factorial(long n) {
        long num = abs(n);

        if (num == 1) {
            return 1;
        } else {
            return num * factorial(num - 1);
        }
    }

    public static ArrayList<Long> listFactors(long numbers) {
        ArrayList<Long> list = new ArrayList<>();
        long n = abs(numbers);
        for (long a = 1; a <= n; a++) {
            if (n % a == 0) {
                list.add(a);
            }
        }
        return list;
    }

    public static boolean isDecimal(double num) {
        boolean result = false;
        if (num % 1 != 0) {
            result = true;
        }
        return result;
    }

    // Least Common Multiple
    public static long lcm(long x, long y) {
        long a = abs(x);
        long b = abs(y);

        return a * (b / gcd(a, b));
    }

    // Greatest Common Divisor
    public static long gcd(long x, long y) {
        long a = abs(x);
        long b = abs(y);

        while (b > 0) {
            long temp = b;
            b = a % b;
            a = temp;
        }
        return a;
    }

    public static int round(float f) {
        return (int) floor(f + 0.5f);
    }

    public static long round(double d) {
        return (long) floor(d + 0.5);
    }

    public static double floor(double a) {
        double x = abs(a);
        if (!(x < longBit) || (long) a == a) return a;
        if (x < 1) return a >= 0 ? 0 * a : -1;
        return a < 0 ? (long) a - 1.0 : (long) a;
    }

    public static double ceil(double a) {
        return -floor(-a);
    }

    public static long GaussSeidel(long n) {
        return (n * (n + 1)) / 2;
    }
    // number format
    private static final NavigableMap<Long, String> suffixes = new TreeMap<>();

    static {
        suffixes.put(1_000L, "K");
        suffixes.put(1_000_000L, "M");
        suffixes.put(1_000_000_000L, "G");
        suffixes.put(1_000_000_000_000L, "T");
        suffixes.put(1_000_000_000_000_000L, "P");
        suffixes.put(1_000_000_000_000_000_000L, "E");
    }

    public static String format(long value) {
        // Long.MIN_VALUE == -Long.MIN_VALUE so we need an adjustment here
        if (value == Long.MIN_VALUE) return format(Long.MIN_VALUE + 1);
        if (value < 0) return "-" + format(-value);
        if (value < 1000) return Long.toString(value); // deal with easy case

        Map.Entry<Long, String> e = suffixes.floorEntry(value);
        Long divideBy = e.getKey();
        String suffix = e.getValue();

        long truncated = value / (divideBy / 10); // the number part of the output times 10
        boolean hasDecimal = truncated < 100 && (truncated / 10d) != (truncated / 10);
        return hasDecimal ? (truncated / 10d) + suffix : (truncated / 10) + suffix;
    }

    public static double ulp(double d) {
        return Math.ulp(d);
    }

    public static float ulp(float f) {
        return Math.ulp(f);
    }
	public static double log(double x){
		return 1000.0 * (Math.pow(x , (1 / 1000.0)) - 1);
	}
	public static double log10(double x){
		return log(x) / log(10);
	}
}

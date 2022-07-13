package de.tum.in.ase.eist;

import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.Arrays;

@Service
public class QueryProcessor {

    public String process(String query) {
		query = query.toLowerCase();
        if (query.contains("shakespeare")) {
            return "William Shakespeare (26 April 1564 - 23 April 1616) was an " +
                    "English poet, playwright, and actor, widely regarded as the greatest " +
                    "writer in the English language and the world's pre-eminent dramatist.";
        } else if (query.contains("name")) {
           return "Philipp";
        } else if (query.contains("plus")){
            String[] a = query.split(" ");
            int res = Integer.parseInt(a[3]) + Integer.parseInt(a[5]);
            return "" + res;
        }
        else if (query.contains("largest")){
            String[] a = query.split(": ");
            String[] b = a[2].split(", ");
            ArrayList<Integer> res = new ArrayList<>();

            for (String k : b) {
                res.add(Integer.parseInt(k));
            }
            return Arrays.stream(res.toArray()).mapToInt(r -> (int) r).max() + "";
        }
        else if (query.contains("multiplied")) {
            String [] a = query.split(" ");
            int res = Integer.parseInt(a[3]) + Integer.parseInt(a[6]);
            return res + "";
        }
        else if (query.contains("square")) {
            //"d7067f50: which of the following numbers is both a square and a cube: 289, 16, 606, 94"
            String [] a = query.split(": ");
            String [] b = a[2].split(", ");
            return Arrays.stream(b).mapToInt(k -> (int) Integer.parseInt(k)).filter(t -> t%2 == 0).filter(t -> t > 0).filter(t -> Math.sqrt(t) * Math.sqrt(t) == (float) t).filter(t -> Math.pow(t, (1.0/3.0)) * Math.pow(t, (1.0/3.0)) * Math.pow(t, (1.0/3.0)) == t).max().getAsInt() + "";
        }
        else if (query.contains("primes")) {
            //"bcac2fb0: which of the following numbers are primes: 29, 753"
            String [] a = query.split(": ");
            String [] b = a[2].split(", ");
            return Arrays.stream(b).mapToInt(Integer::parseInt).max().getAsInt() + "";

        }
        else {
            return"";
        }
    }
}

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
        else {
            return"";
        }
    }
}

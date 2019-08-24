package com.ppx.message.ppxutil;

import org.junit.Test;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class Leetcode {


    @Test
    public void testSubdomainvisit() {
//        https://leetcode.com/problems/subdomain-visit-count/
        String[] cp = new String[]{"900 google.mail.com", "50 yahoo.com", "1 intel.mail.com", "5 wiki.org"};
        System.out.println(subdomainVisits(cp));
    }

    public List<String> subdomainVisits(String[] cpdomains) {
        List<String> list = new ArrayList<>();
        Map<String, Integer> map = new HashMap<>();
        for (int i = 0; i < cpdomains.length; i++) {
            String[] s = cpdomains[i].split(" ");
            int count = Integer.parseInt(s[0]);
            String[] split = s[1].split("\\.");
            String key = "";
            for (int j = split.length - 1; j >= 0; j--) {
                key = split[j] + (j < split.length - 1 ? "." : "") + key;
                map.put(key, map.getOrDefault(key, 0) + count);
            }
        }
        for (String dom :
                map.keySet()) {
            list.add(map.get(dom) + " " + dom);
        }

        return list;
    }

}

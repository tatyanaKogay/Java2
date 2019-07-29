package dictionary;

import java.util.*;

public class Main {
    public static void main(String[] args) {
        String[] text = {"nothing", "twice", "one", "this",
                "in", "take", "and", "should", "comes", "arm",
                "twice", "ever", "chance", "we", "their", "we",
                "must", "do", "it","at", "all", "take", "costs",
                "chance", "take", "nothing", "all"};
        findUniqueWords(text);
        countWords(text);
    }

    private static void findUniqueWords(String[] words){
//        int i, n=0;
//        String[] list = new String[words.length];
//
//        for (i=0; i<words.length;i++){
//            if (isNew(list, words[i])) {
//                list[n] = words[i];
//                System.out.println(list[n++]);
//            }
//        }
        TreeSet<String> set = new TreeSet<>();
        for (int i=0; i<words.length; i++){
            set.add(words[i]);
        }
        System.out.println(set);
    }

//    private static boolean isNew(String[] strings, String s){
//        boolean got = true;
//        for (int j = 0; j<strings.length; j++){
//            if (strings[j] == null) break;
//            if (s.equals(strings[j])){
//                got = false;
//                break;
//            }
//        }
//        return got;
//    }

    private static void countWords(String[] list){
        TreeMap<String, Integer> map = new TreeMap<>();
        for (int l=0; l<list.length; l++){
            if (!map.containsKey(list[l])) map.put(list[l], 1);
            else {
                Integer i = map.get(list[l]);
                map.put(list[l], ++i);
            }
        }
        System.out.println(map);
    }
}

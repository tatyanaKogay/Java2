package phonebook;

import java.util.ArrayList;
import java.util.HashMap;

public class PhoneBook {
    private HashMap<String,ArrayList<String[]>> map;
    public PhoneBook(){
        map = new HashMap<>();
    }
    public void add(String secN, long num, String email){
        String[] strings = {String.valueOf(num), email};
        ArrayList list;
        if (!map.containsKey(secN)) list = new ArrayList();
        else list = map.get(secN);
        list.add(strings);
        map.put(secN, list);
    }
    public void findNum(String secN){
        String[] strings;
        ArrayList l = map.get(secN);
        for(int i=0; i<l.size(); i++){
            strings = (String[])l.get(i);
            System.out.println("Phone of " + secN + "[" + i + "]:\n" + strings[0]);
        }
    }
    public void findEmail(String secN){
        String[] strings;
        ArrayList l = map.get(secN);
        for(int i=0; i<l.size(); i++){
            strings = (String[])l.get(i);
            System.out.println("Email of " + secN + "[" + i + "]:\n" + strings[1]);
        }
    }

    @Override
    public String toString(){
        return "PhoneBook with " + map.size() + " accounts";
    }
}

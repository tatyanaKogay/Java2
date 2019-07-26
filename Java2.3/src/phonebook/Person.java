package phonebook;

public class Person {

    private String secName;
    private int number;

    public Person(String sn, int n){
        secName = sn;
        number = n;
    }

    public String getSecName() {
        return secName;
    }

    public int getNumber() {
        return number;
    }
}

package phonebook;

public class Main {
    public static void main(String[] args) {
        PhoneBook pb = new PhoneBook();
        pb.add("Brown", 87776251369L, "browm@mail.com");
        pb.add("Gray", 87725926743L, "gray@mail.com");
        pb.add("Black", 96831574269L, "black@mail.com");
        pb.add("Gosling", 3298764442L, "gosling@mail.com");
        pb.add("Gates", 89866666351L, "gates@mail.com");
        pb.add("Gray", 84487936943L, "gray120596@mail.com");
        pb.findEmail("Gray");
        pb.findNum("Gray");
        System.out.println(pb);
    }

}

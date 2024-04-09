public class Main {
    public static void main(String[] args) {
        BinaryTree<String> family = new BinaryTree<>();
        family.insert("Natalie");
        family.insert("Leo");
        family.insert("Sylvester");
        family.insert("Bear");
        family.insert("Raquel");
        family.insert("Danny");
        family.insert("Nick");
        family.insert("Hayden");
        family.print();
        System.out.println();
        System.out.println(family.search("alexis"));
    }
}

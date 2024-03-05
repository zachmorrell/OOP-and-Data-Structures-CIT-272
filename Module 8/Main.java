public class Main{
    public static void main(String[] args) {
        LinkedList<String> names = new LinkedList<>();
        names.add("Luke");
        names.add("Leia");
        names.add("Han Solo");
        names.add("Spock");
        names.add("Obeewon");
        names.add("Seven of Nine");

        names.set(4, "Obi-Wan");
        if (names.get(4).equals("Obi-Wan")){
            System.out.println("Set and Get Passed");
        }

        names.remove("Spock");
        if (names.get(3).equals("Obi-Wan")){
            System.out.println("remove(Object) Passed");
        }
        if (names.indexOf("Obi-Wan") == 3){
            System.out.println("indexOf() Passed");
        }
        names.remove(4);

        if (names.contains("Luke")){
            System.out.println("contains() with existing element Passed");
        }
        if (!names.contains("Yoda")){
            System.out.println("contains() with non-existing element Passed");
        }

        names.clear();
        if (names.isEmpty()){
            System.out.println("clear() and isEmpty() Passed");
        }

    }
}
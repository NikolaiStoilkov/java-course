package JavaBasics;

class Main {
    public void main(String[] args) {
        Order order = new Order(1, "Pencho");

        order.updateStatus(Order.OrderStatus.PROCESSING);
        order.getOrderInfo(
                1,
                "Gosho"
        );

        // ----------------------------------------------------------------------------------------------

        Book book = new Book(
                "The Lord of the Rings",
                "J.R.R. Tolkien",
                1954,
                "978-0618260274"
        );


        book.displayBookInfo();

        // ----------------------------------------------------------------------------------------------

        Student unknown = new Student();
        Student std1 = new Student(
                "1",
                "one"
        );
        Student std2 = new Student(
                "2",
                "two",
                15,
                6.0
        );

        IO.println(unknown.getName() + " | " + unknown.getID() + " | " + unknown.age() + " | " + unknown.gpa());
        IO.println(std1.getName() + " | " + std1.getID() + " | " + std1.age() + " | " + std1.gpa());
        IO.println(std2.getName() + " | " + std2.getID() + " | " + std2.age() + " | " + std2.gpa());
    }
}
public class MultipleClassesInSameFile {
    public static void main(String[] args) {
        IO.println(GenerateMessage.generateMessage());
        IO.println(AnotherMessage.anotherMessage());
    }
}

class GenerateMessage {
    static String generateMessage(){
        return "This is a generated message.";
    }
}

class AnotherMessage{
    static String anotherMessage() {
        return "This is another message.";
    }
}

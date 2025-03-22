interface Messenger{
    void sendMessage (String message);
}
class  ChatMessenger implements  Messenger{
    @Override
    public void sendMessage(String message) {
        System.out.println("Send message:" + message);
    }
}
class Main {
    public static void main(String[] args) {
        Messenger chat = new ChatMessenger();
        chat.sendMessage("Hello");
    }
}
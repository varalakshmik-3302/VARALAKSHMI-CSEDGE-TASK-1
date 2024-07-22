import java.io.IOException;
import java.util.Scanner;

public class ChatbotApp {
    private Scanner scanner;

    public ChatbotApp() {
        scanner = new Scanner(System.in);
    }

    public void startChat() {
        System.out.println("Hello! I am your chatbot. How can I assist you?");
        System.out.println("Enter a command or 'exit' to end:");

        boolean chatting = true;
        while (chatting) {
            String input = scanner.nextLine().toLowerCase();

            try {
                if (input.startsWith("open ")) {
                    openApplication(input.substring(5));
                } else if (input.equals("search")) {
                    searchWeb();
                } else if (input.equals("exit")) {
                    chatting = false;
                } else {
                    System.out.println("Command not recognized. Please try again.");
                }
            } catch (IOException e) {
                System.out.println("Error: " + e.getMessage());
            }
        }

        System.out.println("Goodbye! Have a nice day.");
        scanner.close();
    }

    private void openApplication(String applicationPath) throws IOException {
        Runtime.getRuntime().exec(applicationPath);
        System.out.println("Opening " + applicationPath);
    }

    private void searchWeb() throws IOException {
        System.out.println("Enter your search query:");
        String query = scanner.nextLine().replaceAll("\\s+", "+");
        String url = "https://www.google.com/search?q=" + query;
        Runtime.getRuntime().exec("cmd /c start " + url);
        System.out.println("Searching for: " + query);
    }

    public static void main(String[] args) {
        ChatbotApp chatbot = new ChatbotApp();
        chatbot.startChat();
    }
}
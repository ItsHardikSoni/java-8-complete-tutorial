import java.util.ArrayDeque;
import java.util.Deque;

class BrowserHistoryDeque {
    private final Deque<String> history = new ArrayDeque<>();

    void visit(String url) {
        history.push(url);
    }

    String back() {
        if (history.isEmpty()) {
            return "No previous page";
        }
        return history.pop();
    }

    public static void main(String[] args) {
        BrowserHistoryDeque browser = new BrowserHistoryDeque();
        browser.visit("google.com");
        browser.visit("github.com");
        browser.visit("stackoverflow.com");

        System.out.println("Back: " + browser.back());
        System.out.println("Back: " + browser.back());
    }
}

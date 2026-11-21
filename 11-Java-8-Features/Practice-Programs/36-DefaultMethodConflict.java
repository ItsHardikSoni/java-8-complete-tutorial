interface FirstGreeting {
    default String message() {
        return "First interface";
    }
}

interface SecondGreeting {
    default String message() {
        return "Second interface";
    }
}

class DefaultMethodConflict implements FirstGreeting, SecondGreeting {
    @Override
    public String message() {
        return FirstGreeting.super.message();
    }

    public static void main(String[] args) {
        System.out.println(new DefaultMethodConflict().message());
    }
}

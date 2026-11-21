class SuperParent {
    String message = "Parent variable";

    SuperParent() {
        System.out.println("Parent constructor");
    }

    void show() {
        System.out.println(message);
    }
}

class SuperChild extends SuperParent {
    String message = "Child variable";

    SuperChild() {
        super();
        System.out.println("Child constructor");
    }

    @Override
    void show() {
        System.out.println(super.message);
        super.show();
        System.out.println(message);
    }
}

class SuperKeyword {
    public static void main(String[] args) {
        new SuperChild().show();
    }
}

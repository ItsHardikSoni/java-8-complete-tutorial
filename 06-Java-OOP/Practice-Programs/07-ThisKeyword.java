class ThisKeyword {
    private String name;

    ThisKeyword(String name) {
        this.name = name;
    }

    void setName(String name) {
        this.name = name;
    }

    void display() {
        System.out.println("Name: " + this.name);
    }

    public static void main(String[] args) {
        ThisKeyword example = new ThisKeyword("Example");
        example.display();
    }
}

class StaticVsInstance {
    static int objectCount;
    int instanceId;

    StaticVsInstance(int instanceId) {
        this.instanceId = instanceId;
        objectCount++;
    }

    public static void main(String[] args) {
        StaticVsInstance first = new StaticVsInstance(1);
        StaticVsInstance second = new StaticVsInstance(2);
        System.out.println("Instance ID: " + first.instanceId);
        System.out.println("Object count: " + objectCount);
    }
}

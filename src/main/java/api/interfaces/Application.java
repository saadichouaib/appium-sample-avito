package api.interfaces;

public interface Application {
    void forceStop();
    void clearData();
    Object open();
    String packageID();
    String mainActivityID();
}

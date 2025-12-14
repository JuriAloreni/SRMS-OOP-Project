import java.util.ArrayList;
public class AutoSave extends Thread {

    private final StudentRecordManager manager;
    private final FileManager fileManager;
    private final int interval;
    private boolean running = true;

    public AutoSave(StudentRecordManager manager, String fileName, int intervalSeconds) {
        this.manager = manager;
        this.fileManager = new FileManager(fileName);
        this.interval = intervalSeconds * 1000;
        setDaemon(true);
    }

    public void stopautosave() {
        running = false;
        interrupt();
    }

    @Override
    public void run() {
        while (running) {
            try {
                fileManager.saveStudents(manager.getStudents());
                System.out.println("AutoSave done!");
                Thread.sleep(interval);

            } catch (InterruptedException e) {
                System.out.println("AutoSave stopped.");
                return;

            } catch (IOException e) {
                System.out.println("AutoSave error: " + e.getMessage());
            }
        }
    }
}


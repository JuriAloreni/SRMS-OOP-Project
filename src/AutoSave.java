public class AutoSave extends Thread {

    private final StudentRecordManager manager;
    private final String fileName;
    private final int interval;
    private  boolean running = true;

    public AutoSave(StudentRecordManager manager, String fileName, int intervalSeconds) {
        this.manager = manager;
        this.fileName = fileName;
        this.interval = intervalSeconds * 1000;//convert from seconds to milliseconds
    }
//method to stop autosave 
    public void stopautosave() {
        running = false;
    }

    @Override
    public void run() {

        while (running) {
            try {
                FileManager.saveReport(new ArrayList<>(manager.getStudents()), fileName);
                System.out.println("AutoSave done!");

                Thread.sleep(interval);
//specific catch 
            } catch (InterruptedException e) {
                System.out.println("AutoSave stopped.");
                return;
//generic catch
            } catch (Exception e) {
                System.out.println("Error: " + e.getMessage());
            }
        }
    }
}

public class RepeatableTask extends Task {
    private int repeatCount;
    private String repeatTime;

    public RepeatableTask(String name, String definition, String createdBy, int repeatCount, String repeatTime) {
        super(name, definition, createdBy);
        this.repeatCount = repeatCount;
        this.repeatTime = repeatTime;
    }

    public int getRepeatCount() {
        return repeatCount;
    }

    public void setRepeatCount(int repeatCount) {
        this.repeatCount = repeatCount;
    }

    public void setRepeatTime(String repeatTime) {
        this.repeatTime = repeatTime;
    }

    public String getRepeatTime() {
        return repeatTime;
    }

    @Override
    public String getDetails() {
        return "RepeatableTask:\nName: " + name + "\nDefinition: " + definition +
                "\nRepeats: " + repeatCount + " times, " + repeatTime +
                "\nCreated by: " + createdBy;
    }
}

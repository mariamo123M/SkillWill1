import java.time.LocalDateTime;
import java.time.format.DateTimeFormatter;

public class LimitedTimeTask extends Task {
    private LocalDateTime deadline;

    public LimitedTimeTask(String name, String definition, String createdBy, LocalDateTime deadline) {
        super(name, definition, createdBy);
        this.deadline = deadline;  // Directly assign the LocalDateTime object
    }

    @Override
    public String getDetails() {
        return "LimitedTimeTask:\nName: " + name + "\nDefinition: " + definition +
                "\nDeadline: " + deadline.format(DateTimeFormatter.ofPattern("yyyy-MM-dd HH:mm")) + "\nCreated by: " + createdBy;
    }

    public String getDeadline() {
        return "";
    }

    public void setDeadline(LocalDateTime deadline) {
        this.deadline = deadline;
    }
}



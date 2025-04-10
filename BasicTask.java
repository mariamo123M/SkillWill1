public class BasicTask extends Task{
    public BasicTask(String name, String definition, String createdBy) {
        super(name, definition, createdBy);
    }

    @Override
    public String getDetails() {
        return "BasicTask:\nName: " + name + "\nDefinition: " + definition + "\nCreated by: " + createdBy;
    }


}

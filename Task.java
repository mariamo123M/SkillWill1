public abstract class Task {
    protected String name;
    protected String definition;
    protected String createdBy;

    public Task(String name, String definition, String createdBy) {
        this.name = name;
        this.definition = definition;
        this.createdBy = createdBy;
    }

    public String getName() {
        return name;
    }

    public String getDefinition() {
        return definition;
    }

    public String getCreatedBy() {
        return createdBy;
    }

    public abstract String getDetails();

    public void setDefinition(String definition) {
        this.definition = definition;
    }
    public void setName(String name) {
        this.name = name;
    }

    public void setCreatedBy(String createdBy) {
        this.createdBy = createdBy;
    }
}

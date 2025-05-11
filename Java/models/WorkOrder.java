package models;

import java.text.SimpleDateFormat;
import java.util.Date;
import java.util.Set;

public class WorkOrder {

    private int id;
    private String title;
    private String description;
    private String status;
    private Date creationDate;
    private int priority;

    public WorkOrder(int id, String title, String description, String status, Date creationDate, int priority) {
        this.id = id;
        this.title = title;
        this.description = description;
        this.status = status;
        this.creationDate = creationDate;
        this.priority = priority;
    }

    public int getId() {
        return id;
    }

    public void setId(int id) {
        this.id = id;
    }

    public String getTitle() {
        return title;
    }

    public void setTitle(String title) {
        this.title = title;
    }

    public String getDescription() {
        return description;
    }

    public void setDescription(String description) {
        this.description = description;
    }

    public String getStatus() {
        return status;
    }

    private static final Set<String> VALID_STATUSES = Set.of("OPEN", "IN PROGRESS", "CLOSED");

    public void setStatus(String status) {
        if (!VALID_STATUSES.contains(status)) {
            throw new IllegalArgumentException("Invalid status: " + status + ". Please enter open, in progress, or closed.");
        }
        this.status = status;
    }

    public Date getCreationDate() {
        return creationDate;
    }

    public void setCreationDate(Date creationDate) {
        this.creationDate = creationDate;
    }

    public int getPriority() {
        return priority;
    }

    public void setPriority(int priority) {
        this.priority = priority;
    }

    @Override
    public String toString() {
        SimpleDateFormat df = new SimpleDateFormat("dd-MM-yyyy");
        String date = df.format(creationDate);
        return String.format("\nID: %d\nTitle: %s\nDescription: %s\nStatus: %s\nCreated on: %s\nPriority: %d", id, title, description, status, date, priority);
    }
}

package model;

import java.time.LocalDate;

public class Project {
    private String title;
    private int id;
    private String description;
    private LocalDate created;
    private int nextTaskId;
    public Project(String title, int id, String description, LocalDate created, int nextTaskId) {
        this.title = title;
        this.id = id;
        this.description = description;
        this.created = created;
        this.nextTaskId = nextTaskId;
    }
}

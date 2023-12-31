package main.model;

import javax.persistence.*;
import javax.validation.constraints.NotBlank;
import java.time.LocalDateTime;

@Entity
public class Task {

    public Task(String title) {
        this.dateTimeOfCreate = LocalDateTime.now();
    }

    public Task() {
        this.dateTimeOfCreate = LocalDateTime.now();
    }
    @Id
    @GeneratedValue(strategy = GenerationType.AUTO)
    private int id;
    @NotBlank
    private String title;

    @Column(columnDefinition = "date_time_of_create")
    private LocalDateTime dateTimeOfCreate;

    public int getId() {
        return id;
    }

    public Task setId(int id) {
        this.id = id;
        return this;
    }

    public String getTitle() {
        return title;
    }

    public Task setTitle(String title) {
        this.title = title;
        return this;
    }

    public LocalDateTime getDateTimeOfCreate() {
        return dateTimeOfCreate;
    }

    public void setDateTimeOfCreate(LocalDateTime dateTimeOfCreate) {
        this.dateTimeOfCreate = dateTimeOfCreate;
    }
}
package com.kodilla.hibernate.task;

import javax.persistence.*;
import javax.validation.constraints.NotNull;
import java.util.Date;

@Entity
@Table(name = "TASKS")
public final class Task {
    private int id;
    private String description;
    private Date created;
    private int duration;
    private TaskFinancialDetails taskFinancialDetails;

    public Task() {
    }

    public Task(String description, int duration) {
        this.description = description;
        this.created = new Date();
        this.duration = duration;
    }

    @Id
    @GeneratedValue
    @NotNull
    @Column(name = "ID", unique = true)
    public int getId() {
        return id;
    }

    @Column(name = "DESCRIPTION")
    public String getDescription() {
        return description;
    }

    @NotNull
    @Column(name="CREATED")
    public Date getCreated() {
        return created;
    }

    @Column(name="DURATION")
    public int getDuration() {
        return duration;
    }

    /**
     * cascade - określa co ma się dziać z rekordami w tabeli zależnej (czyli TASKS_FINANCIALS) w momencie, gdy usuwamy lub zapisujemy rekord w tabeli TASKS.
     * fetch - określa czy podczas wczytywania encji Task z bazy danych mają być automatycznie odczytywane ("dociągane") wszystkie zależne rekordy z tabeli TASK_FINANCIALS.
     * */

    @OneToOne(cascade = CascadeType.ALL, fetch = FetchType.EAGER)
    @JoinColumn(name="TASKS_FINANCIALS_ID")
    public TaskFinancialDetails getTaskFinancialDetails() {
        return taskFinancialDetails;
    }

    public void setTaskFinancialDetails(TaskFinancialDetails taskFinancialDetails) {
        this.taskFinancialDetails = taskFinancialDetails;
    }

    private void setId(int id) {
        this.id = id;
    }

    private void setDescription(String description) {
        this.description = description;
    }

    private void setCreated(Date created) {
        this.created = created;
    }

    private void setDuration(int duration) {
        this.duration = duration;
    }
}

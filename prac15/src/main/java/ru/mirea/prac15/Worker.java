package ru.mirea.prac15;

import lombok.Data;
import lombok.Getter;
import lombok.Setter;
import org.hibernate.query.Query;

import javax.persistence.Column;
import javax.persistence.Entity;
import javax.persistence.Id;
import javax.persistence.Table;
import java.util.List;

@Data
@Entity
@Table(name = "workers")
public class Worker {
    @Id
    @Column(name = "id")
    private int id;
    @Column(name = "manufacture_id")
    private int manufactureId;
    @Column(name = "first_name")
    private String firstName;
    @Column(name = "last_name")
    private String lastName;
    @Column(name = "middle_name")
    private String middleName;

    public Worker() {
        this.manufactureId = 0;
        this.firstName = null;
        this.lastName = null;
        this.middleName = null;
    }

    public Worker(int manufactureId, String firstName, String lastName, String middleName) {
        this.manufactureId = manufactureId;
        this.firstName = firstName;
        this.lastName = lastName;
        this.middleName = middleName;
    }

    public String toString() {
        /*AppService appService = new AppService();
        String queryString = "SELECT m.name FROM Manufacture m WHERE m.id = :manufactureId";
        Query query = appService.getSession().createQuery(queryString, String.class);
        query.setParameter(":manufactureId", manufactureId);
        List <String> manufactureNameList = query.list();*/
        return "id" + id + ": Worker from manufacture " + manufactureId + ": " + firstName + " " + lastName + " " + middleName;
    }
}


package ru.mirea.prac15;

import org.hibernate.Transaction;
import org.hibernate.query.Query;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.List;

@Controller
@RequestMapping("/manufacture")
public class ManufactureController {
    AppService appService;

    public ManufactureController() {
        appService = new AppService();
    }

    @GetMapping("/out")
    public @ResponseBody
    String out() {
        Transaction transaction = appService.getSession().beginTransaction();
        String queryString = "SELECT m FROM Manufacture m";
        List<Manufacture> manufactureList = appService.getSession().createQuery(queryString, Manufacture.class).getResultList();
        String res = "";
        for (Manufacture manufacture: manufactureList) {
            res += manufacture.toString() + "<br>";
            queryString = "SELECT w FROM Worker w WHERE w.manufactureId = :manufactureId";
            Query query = appService.getSession().createQuery(queryString, Worker.class);
            query.setParameter("manufactureId", manufacture.getId());
            List<Worker> workerList = query.list();
            for (Worker worker: workerList) {
                res += worker.toString() + "<br>";
            }
        }
        transaction.commit();
        return res;
    }

    @GetMapping("/out/{id}")
    public @ResponseBody
    String out(@PathVariable int id) {
        Transaction transaction = appService.getSession().beginTransaction();
        String queryString = "SELECT m FROM Manufacture m WHERE id = :id";
        Query query = appService.getSession().createQuery(queryString, Manufacture.class);
        query.setParameter("id", id);
        List<Manufacture> manufactureList = query.list();
        String res = "";
        for (Manufacture manufacture: manufactureList) {
            res += manufacture.toString() + "<br>";
            queryString = "SELECT w FROM Worker w WHERE w.manufactureId = :manufactureId";
            query = appService.getSession().createQuery(queryString, Worker.class);
            query.setParameter("manufactureId", manufacture.getId());
            List<Worker> workerList = query.list();
            for (Worker worker: workerList) {
                res += worker.toString() + "<br>";
            }
        }
        transaction.commit();
        return res;
    }

    @GetMapping("/add")
    public @ResponseBody
    String add(String name, String address) {
        Manufacture manufacture = new Manufacture(name, address);
        Transaction transaction = appService.getSession().beginTransaction();
        appService.getSession().saveOrUpdate(manufacture);
        transaction.commit();
        return "New Manufacture: " + manufacture.toString();
    }

    @GetMapping("/delete/{id}")
    public @ResponseBody
    String delete(@PathVariable int id) {
        Transaction transaction = appService.getSession().beginTransaction();
        String queryString = "DELETE Manufacture m WHERE m.id = :id";
        Query query = appService.getSession().createQuery(queryString);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        //int result = query.executeUpdate();
        return "Manufacture with id:" + id + " deleted";
    }
}

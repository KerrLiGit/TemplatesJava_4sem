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
@RequestMapping("/worker")
public class WorkerController {
    AppService appService;

    public WorkerController() {
        appService = new AppService();
    }

    @GetMapping("/out")
    public @ResponseBody
    String out() {
        Transaction transaction = appService.getSession().beginTransaction();
        List<Worker> workerList =
                appService.getSession().createQuery("SELECT w FROM Worker w", Worker.class).getResultList();
        transaction.commit();
        String res = "";
        for (Worker worker: workerList) {
            res += worker.toString() + "<br>";
        }
        return res;
    }

    @GetMapping("/out/{id}")
    public @ResponseBody
    String out(@PathVariable int id) {
        Transaction transaction = appService.getSession().beginTransaction();
        String queryString = "SELECT w FROM Worker w WHERE w.id = :id";
        Query query = appService.getSession().createQuery(queryString, Worker.class);
        query.setParameter("id", id);
        Worker worker = (Worker) query.list().get(0);
        transaction.commit();
        return worker.toString();
    }

    @GetMapping("/add")
    public @ResponseBody
    String add(int manufactureId, String firstName, String lastName, String middleName) {
        Worker worker = new Worker(manufactureId, firstName, lastName, middleName);
        Transaction transaction = appService.getSession().beginTransaction();
        appService.getSession().saveOrUpdate(worker);
        transaction.commit();
        return "New Worker: " + worker.toString();
    }

    @GetMapping("/delete/{id}")
    public @ResponseBody
    String delete(@PathVariable int id) {
        Transaction transaction = appService.getSession().beginTransaction();
        String queryString = "DELETE Worker w WHERE w.id = :id";
        Query query = appService.getSession().createQuery(queryString);
        query.setParameter("id", id);
        query.executeUpdate();
        transaction.commit();
        return "Worker with id:" + id + " deleted";
    }
}

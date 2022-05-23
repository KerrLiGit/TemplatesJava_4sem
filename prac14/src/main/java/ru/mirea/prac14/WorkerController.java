package ru.mirea.prac14;

import org.springframework.http.MediaType;
import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;

@Controller
public class WorkerController {
    ArrayList<Worker> workerArray = new ArrayList<Worker>();

    @GetMapping(value = "/worker/create")
    public @ResponseBody
    String createWorker(@PathVariable String firstName, @PathVariable String lastName, @PathVariable String middleName) {
        Worker worker = new Worker(firstName, lastName, middleName);
        workerArray.add(worker);
        return "Worker " + firstName + " " + lastName + " " + middleName + " created with id"
                + (workerArray.size() - 1);
    }

    @GetMapping(value = "/worker/out/{id}")
    public @ResponseBody
    String outWorker(@PathVariable int id) {
        return "Worker with id" + id + ": " + workerArray.get(id).firstName + " "
                + workerArray.get(id).lastName + " " + workerArray.get(id).middleName;
    }

    @GetMapping(value = "/worker/out/all")
    public @ResponseBody
    String outAllWorker() {
        String res = "";
        for (int id = 0; id < workerArray.size(); id++) {
            res += "Worker with id" + id + ": " + workerArray.get(id).firstName + " "
                    + workerArray.get(id).lastName + " " + workerArray.get(id).middleName + "<br>";
        }
        return res;
    }

    @GetMapping(value = "/worker/delete/{id}")
    public @ResponseBody
    String deleteWorker(@PathVariable int id) {
        Worker worker = workerArray.remove(id);
        return "Worker with id" + id + ": " + worker.firstName + " "
                + worker.lastName + " " + worker.middleName + " deleted";
    }

    @GetMapping(value = "/worker/delete/all")
    public @ResponseBody
    String deleteAllWorker() {
        workerArray.clear();
        return "All workers deleted";
    }
}

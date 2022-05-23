package ru.mirea.prac14;

import org.springframework.stereotype.Controller;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.ResponseBody;

import java.util.ArrayList;

@Controller
public class ManufactureController {
    ArrayList<Manufacture> manufactureArray = new ArrayList<Manufacture>();

    @GetMapping(value = "/manufacture/create")
    public @ResponseBody
    String createManufacture(String name, String address) {
        Manufacture manufacture = new Manufacture(name, address);
        manufactureArray.add(manufacture);
        return "Manufacture " + name + " " + address + " created with id"
                + (manufactureArray.size() - 1);
    }

    @GetMapping(value = "/manufacture/out/{id}")
    public @ResponseBody
    String outManufacture(@PathVariable int id) {
        return "Manufacture with id" + id + ": " + manufactureArray.get(id).name + " "
                + manufactureArray.get(id).address;
    }

    @GetMapping(value = "/manufacture/out/all")
    public @ResponseBody
    String outAllManufacture() {
        String res = "";
        for (int id = 0; id < manufactureArray.size(); id++) {
            res += "Manufacture with id" + id + ": " + manufactureArray.get(id).name + " "
                    + manufactureArray.get(id).address + "<br>";
        }
        return res;
    }

    @GetMapping(value = "/manufacture/delete/{id}")
    public @ResponseBody
    String deleteWorker(@PathVariable int id) {
        Manufacture manufacture = manufactureArray.remove(id);
        return "Manufacture with id" + id + ": " + manufacture.name + " "
                + manufacture.address + " deleted";
    }

    @GetMapping(value = "/manufacture/delete/all")
    public @ResponseBody
    String deleteAllWorker() {
        manufactureArray.clear();
        return "All manufactures deleted";
    }
}

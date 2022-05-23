package ru.mirea.prac20;

import org.springframework.boot.SpringApplication;
import org.springframework.boot.autoconfigure.SpringBootApplication;
import ru.mirea.prac20.entity.Worker;
import ru.mirea.prac20.service.WorkerService;

@SpringBootApplication
public class Prac20Application {

	public static void main(String[] args) {
		SpringApplication.run(Prac20Application.class, args);
		Worker worker = new Worker(1, "Ivan");
		WorkerService workerService = new WorkerService(worker);
		workerService.doWork();
		workerService.doChill();
	}

}

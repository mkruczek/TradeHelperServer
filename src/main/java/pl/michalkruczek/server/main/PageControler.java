package pl.michalkruczek.server.main;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.ui.ModelMap;
import org.springframework.web.bind.annotation.*;

import java.text.ParseException;
import java.text.SimpleDateFormat;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikr on 18/08/17.
 */
@RestController
public class PageControler {

    @Autowired
    public TaskRepository taskRepository;

    @RequestMapping("/")
    @ResponseBody
    public String mainPage() {
        return "Hello World!";
    }

    @RequestMapping("/hello")
    @ResponseBody
    public String pageTwo() {
        return "Hi!";
    }

    @RequestMapping("/hello/{name}")
    @ResponseBody
    String hello(@PathVariable String name) {
        return "Hello, " + name + "!";
    }

    @RequestMapping("/db")
    @ResponseBody
    public String testMethod() {
        StringBuilder response = new StringBuilder();

        Task task = new Task()
                .withName("Task 1")
                .withDescription("Test task")
                .withBudget(123.55)
                .withDone(true);
        taskRepository.save(task);

        for(Task i: taskRepository.findAll()) {
            response.append(i).append("<br>");
        }

        return response.toString();
    }

    @RequestMapping("/db2")
    @ResponseBody
    public String testMethod2() {
        StringBuilder response = new StringBuilder();

        response.append("Tasks with done set to true:<br>");
        for(Task i: taskRepository.findByDone(true)) {
            response.append(i).append("<br>");
        }

        response.append("Tasks with done set to false:<br>");
        for(Task i: taskRepository.findByDone(false)) {
            response.append(i).append("<br>");
        }

        response.append("Tasks with \"Do\" in description:<br>");
        for(Task i: taskRepository.getByDescriptionLike("Do")) {
            response.append(i).append("<br>");
        }

        return response.toString();
    }

    @RequestMapping("/allTasks")
    public List<TaskDto> allTask() {
        List<Task> TaskList = taskRepository.findAll();
        List<TaskDto> taskDtoList = new ArrayList<TaskDto>();

        for (Task task : TaskList) {
            TaskDto taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setName(task.getName());
            taskDto.setDescription(task.getDescription());
            taskDto.setBudget(task.getBudget());
            taskDto.setDone(task.getDone());
            taskDtoList.add(taskDto);
        }

        return taskDtoList;
    }

    @RequestMapping("/tasks/{id}")
    public TaskDto task(@PathVariable int id) {
        Task task = taskRepository.findAll().get(id);

        TaskDto taskDto = new TaskDto();

            taskDto.setId(task.getId());
            taskDto.setName(task.getName());
            taskDto.setDescription(task.getDescription());
            taskDto.setBudget(task.getBudget());
            taskDto.setDone(task.getDone());


        return taskDto;
    }

    @RequestMapping(value = "/task/add", method = RequestMethod.POST)
    public String addTask(ModelMap modelMap, @RequestBody TaskDto taskDto) throws ParseException{

        Task task = new Task();

        task.setId(taskDto.getId());
        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setBudget(taskDto.getBudget());
        task.setDone(taskDto.getDone());

        taskRepository.save(task);

        return "Success";
    }

    @RequestMapping("/thx")
    public String thx(){
        return "BARDZO DZIĘKUJĘ PANIE SENIOR!!";
    }

}

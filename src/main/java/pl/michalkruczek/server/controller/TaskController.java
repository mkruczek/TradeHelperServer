package pl.michalkruczek.server.controller;

import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.web.bind.annotation.*;
import pl.michalkruczek.server.dto.TaskDto;
import pl.michalkruczek.server.model.Task;
import pl.michalkruczek.server.repository.TaskRepository;

import java.text.ParseException;
import java.util.ArrayList;
import java.util.List;

/**
 * Created by mikr on 03/09/17.
 */
@RestController
@RequestMapping("/task")
public class TaskController {

    @Autowired
    public TaskRepository taskRepository;

    @RequestMapping(value = "/add", method = RequestMethod.POST)
    public String addTask(@RequestBody TaskDto taskDto) throws ParseException {
        Task task = new Task();

        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setDate(taskDto.getDate());
        task.setDone(taskDto.getDone());

        taskRepository.save(task);

        return "Success - add product [" + task.getName() + "].";
    }

    @RequestMapping("/all")
    public List<TaskDto> allTask(){
        List<Task> taskList = taskRepository.findAll();
        List<TaskDto> taskDtoList = new ArrayList<TaskDto>();

        for (Task task : taskList) {
            TaskDto taskDto = new TaskDto();
            taskDto.setId(task.getId());
            taskDto.setName(task.getName());
            taskDto.setDescription(task.getDescription());
            taskDto.setDate(task.getDate());
            taskDto.setDone(task.getDone());

            taskDtoList.add(taskDto);
        }

        return taskDtoList;
    }

    @RequestMapping("/{id}")
    public TaskDto singleTask(@PathVariable long id){
        Task task = taskRepository.findOne(id);

        TaskDto taskDto = new TaskDto();
        taskDto.setId(task.getId());
        taskDto.setName(task.getName());
        taskDto.setDescription(task.getDescription());
        taskDto.setDate(task.getDate());
        taskDto.setDone(task.getDone());

        return taskDto;
    }

    @RequestMapping(value = "/update/{id}", method = RequestMethod.PUT)
    public String updateTask(@PathVariable long id, @RequestBody TaskDto taskDto){

        Task task = taskRepository.findOne(id);

        task.setName(taskDto.getName());
        task.setDescription(taskDto.getDescription());
        task.setDate(taskDto.getDate());
        task.setDone(taskDto.getDone());

        taskRepository.save(task);

        return "Update task - success [" + task.getName() + "].";
    }

    @RequestMapping(value = "/delete/{id}", method = RequestMethod.DELETE)
    public String deleteTak(@PathVariable long id) {

        String nameOfProduct = taskRepository.findOne(id).getName();

        taskRepository.delete(id);

        return "Delete task [" + nameOfProduct + "].";
    }
}

package org.talent.todolist.service.impl;

import org.modelmapper.ModelMapper;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.stereotype.Service;
import org.talent.todolist.dto.NewTaskRequest;
import org.talent.todolist.entity.Category;
import org.talent.todolist.entity.Task;
import org.talent.todolist.repo.TaskRepo;
import org.talent.todolist.service.TaskService;

import java.util.List;

@Service
public class TaskServiceImpl implements TaskService {
    @Autowired
    private TaskRepo taskRepo;
    @Autowired
    private ModelMapper mapper;

    @Override
    public Task saveNewTask(NewTaskRequest request) {
        Task task = mapper.map(request, Task.class);
        return taskRepo.save(task);
    }

    @Override
    public Task updateNewTask(Task task) {
        Task existingTask = taskRepo.findById(task.getId()).orElse(null);
        if (existingTask != null) {
            existingTask.setLabel(task.getLabel());
            existingTask.setStartTime(task.getStartTime());
            existingTask.setEndTime(task.getEndTime());
            existingTask.setRepeatType(task.getRepeatType());
            existingTask.setCategory(task.getCategory());
            return taskRepo.save(existingTask);
        }
        return null;
    }

    @Override
    public void delete(Long id) {
//        if (taskRepo.existsById(id)){
            taskRepo.deleteById(id);
//        }
    }

    @Override
    public Task findById(Long id) {
        return taskRepo.findById(id).orElse(null);
    }

    @Override
    public List<Task> findAll() {
        return taskRepo.findAll();
    }


}

package br.com.desafiotodolist.service;

import br.com.desafiotodolist.entity.ToDo;
import br.com.desafiotodolist.records.ToDoPostRecord;
import br.com.desafiotodolist.records.ToDoUpdateRecord;
import br.com.desafiotodolist.repository.ToDoRepository;
import org.springframework.beans.BeanUtils;
import org.springframework.data.domain.Sort;
import org.springframework.stereotype.Service;

import java.util.List;

@Service
public class ToDoService {

    private ToDoRepository toDoRepository;

    public ToDoService(ToDoRepository toDoRepository) {
        this.toDoRepository = toDoRepository;
    }


    public List<ToDo> getAll(){
        Sort sort  = Sort.by("prioridade").descending().and(Sort.by("nome").ascending());
        return toDoRepository.findAll();
    }

    public List<ToDo> update(ToDoUpdateRecord toDoUpdateRecord){
        var toDo = new ToDo();
        BeanUtils.copyProperties(toDoUpdateRecord, toDo);
        toDoRepository.save(toDo);
        return getAll();
    }

    public List<ToDo> delete(Long id){
        toDoRepository.deleteById(id);
        return  getAll();
    }

    public List<ToDo> save(ToDoPostRecord toDoPostRecord){
        var toDo = new ToDo();
        BeanUtils.copyProperties(toDoPostRecord, toDo);
        toDoRepository.save(toDo);
        return getAll();
    }
}

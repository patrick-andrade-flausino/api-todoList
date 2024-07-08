package br.com.desafiotodolist.controller;

import br.com.desafiotodolist.entity.ToDo;
import br.com.desafiotodolist.records.ToDoPostRecord;
import br.com.desafiotodolist.records.ToDoUpdateRecord;
import br.com.desafiotodolist.service.ToDoService;
import jakarta.validation.Valid;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;

import java.util.List;

@RestController
@RequestMapping("/toDoList")
public class ToDoController {

    private ToDoService toDoService ;

    public ToDoController(ToDoService toDoService) {
        this.toDoService = toDoService;
    }

    @PostMapping
    public ResponseEntity<List<ToDo>> save(@RequestBody @Valid ToDoPostRecord toDoPostRecord){
        return ResponseEntity.ok(toDoService.save(toDoPostRecord));
    }

    @GetMapping
    public ResponseEntity<List<ToDo>> getAll(){
        return ResponseEntity.ok(toDoService.getAll());
    }

    @DeleteMapping("{id}")
    public ResponseEntity<List<ToDo>> delete(@PathVariable("id") Long id){
        return ResponseEntity.ok(toDoService.delete(id));
    }

    @PutMapping
    public ResponseEntity<List<ToDo>> update(@RequestBody @Valid ToDoUpdateRecord toDoUpdateRecord){
        return ResponseEntity.ok(toDoService.update(toDoUpdateRecord));
    }
}

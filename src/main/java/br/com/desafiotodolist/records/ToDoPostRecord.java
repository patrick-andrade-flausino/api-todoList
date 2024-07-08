package br.com.desafiotodolist.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record ToDoPostRecord(@NotBlank(message = "Nome não pode ser vazio") String nome,
                             String descricao,
                             boolean realizado,
                             int prioridade){

}

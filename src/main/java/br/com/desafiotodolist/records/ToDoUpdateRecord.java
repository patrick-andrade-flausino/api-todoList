package br.com.desafiotodolist.records;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotEmpty;
import jakarta.validation.constraints.NotNull;
import org.springframework.lang.NonNull;

public record ToDoUpdateRecord (
                                @NotNull(message = "Id cannot be null") Long id,
                                @NotBlank(message = "Nome não pode ser vazio") String nome,
                                String descricao,
                                boolean realizado,
                                int prioridade){

}

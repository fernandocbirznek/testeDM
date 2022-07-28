package com.example.todolist;

import androidx.annotation.NonNull;
import androidx.appcompat.app.AppCompatActivity;

import android.os.Bundle;
import android.view.Menu;
import android.view.MenuItem;
import android.widget.Toast;

import com.google.android.material.textfield.TextInputEditText;

public class AddToDoActivity extends AppCompatActivity {

    private TextInputEditText newToDo;
    private ToDo currentToDo;

    @Override
    protected void onCreate(Bundle savedInstanceState) {
        super.onCreate(savedInstanceState);
        setContentView(R.layout.activity_add_to_do);

        newToDo = findViewById(R.id.editTextNewTask);

        currentToDo = (ToDo) getIntent().getSerializableExtra("selectedToDo");
        if(currentToDo != null)
            newToDo.setText(currentToDo.getToDoName());
    }

    @Override
    public boolean onCreateOptionsMenu(Menu menu) {
        getMenuInflater().inflate(R.menu.menu_add_to_do, menu);
        return super.onCreateOptionsMenu(menu);
    }

    @Override
    public boolean onOptionsItemSelected(@NonNull MenuItem item) {
        if(item.getItemId() == R.id.itemSalvar) {
            ToDoDAO toDoDAO = new ToDoDAO(getApplicationContext());
            if (currentToDo != null) {
                String strNewToDo = newToDo.getText().toString();
                if(!strNewToDo.isEmpty()) {
                    ToDo toDo = new ToDo();
                    toDo.setToDoName(strNewToDo);
                    toDo.setId(currentToDo.getId());
                    if(toDoDAO.uptdateToDo(toDo)) {
                        finish();
                        Toast.makeText(this, "Tarefa atualizada", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Ero ao salvar tarefa", Toast.LENGTH_SHORT).show();
                    }
                }
            } else {
                String strNewToDo = newToDo.getText().toString();
                if(!strNewToDo.isEmpty()) {
                    ToDo toDo = new ToDo();
                    toDo.setToDoName(strNewToDo);
                    if(toDoDAO.insertToDo(toDo)) {
                        finish();
                        Toast.makeText(this, "Tarefa salva", Toast.LENGTH_SHORT).show();
                    } else {
                        Toast.makeText(this, "Erro ao salvar tarefa", Toast.LENGTH_SHORT).show();
                    }
                } else {
                    Toast.makeText(this, "Insira a tarefa", Toast.LENGTH_SHORT).show();
                }
            }
        }
        return super.onOptionsItemSelected(item);
    }
}
package Model;
/**
 * Task
 */
public class Task {
// atributos  
String description; 
String details;  
String taskDescription; 
boolean done;  



//construtor 
public Task(String description, String done, String taskDescription) {
this.description = description; 
this.done = false;  
this.taskDescription = taskDescription;

}


public Task(String taskDescription2) {   
    //Tive que fazer um construtor novo pois fiz merda 
}


public Task(String string, String string2, String string3, String string4) {
    //TODO Auto-generated constructor stub
}


// getter and setter 
public String getDescription() {
    return description;
}


public void setDescription(String description) {
    this.description = description;
}


public boolean isDone() {
    return done;
}


public void setDone(boolean done) {
    this.done = done;
}

public String getDetails() {
    return null;
}

public void setDetails(String newDetails) {
}


public String getTaskDescription() {
    return taskDescription;
}


public void setTaskDescription(String taskDescription) {
    this.taskDescription = taskDescription;
}


public void add(Task task) {
    // TODO Auto-generated method stub
    throw new UnsupportedOperationException("Unimplemented method 'add'");
}     




}
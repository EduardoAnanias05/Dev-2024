package Model;
/**
 * Task
 */
public class Task {
// atributos  
String description; 
String details; 
boolean done; 


//construtor 
public Task(String description) {
this.description = description; 
this.done = false; 


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


}
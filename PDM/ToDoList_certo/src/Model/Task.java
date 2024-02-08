package Model;
/**
 * Task
 */
public class Task {
// atributos  
String descrição; 
String detalhes;  
String taskdescrição; 
boolean concluida; 


// construtor  
public Task(String descrição, String detalhes, String taskdescrição, boolean concluida) {
    this.descrição = descrição;
    this.detalhes = detalhes;
    this.taskdescrição = taskdescrição;
    this.concluida = concluida;
}

// construtor vazio  (estanciar objetos sem passar parametros )
public Task() {
}


// getter and setter  
public String getDescrição() {
    return descrição;
}



public void setDescrição(String descrição) {
    this.descrição = descrição;
}


public String getDetalhes() {
    return detalhes;
}


public void setDetalhes(String detalhes) {
    this.detalhes = detalhes;
}


public String getTaskdescrição() {
    return taskdescrição;
}


public void setTaskdescrição(String taskdescrição) {
    this.taskdescrição = taskdescrição;
}


public boolean isConcluida() {
    return concluida;
}


public void setConcluida(boolean concluida) {
    this.concluida = concluida;
}  








}
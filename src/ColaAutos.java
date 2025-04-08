import java.util.ArrayDeque;
import java.util.Queue;

public class ColaAutos {

    Queue<Auto> autos;

    public ColaAutos(){
        autos = new ArrayDeque<>();
    }

    public void encolar(Auto dato){
        autos.add(dato);
    }

    public Auto desencolar() throws Exception{
        if(autos.isEmpty()){
            throw new Exception("No hay autos encoldos");
        }
        return autos.poll();
    }

    public String listarTodos(){
        StringBuilder sb = new StringBuilder();
        //solo sirve para hacer busquedas
        //este es un for each, solo sive cuando son de la interfaz collections
        for(Auto autoX:autos){
            sb.append(autoX.toString());
        }
        return sb.toString();
    }
}

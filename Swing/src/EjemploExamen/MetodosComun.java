package EjemploExamen;

import java.util.ArrayList;
import java.util.List;

public class MetodosComun {
public static List<Empleado> listaEmpleados  = new ArrayList();


public static void añadoEmpleado(Empleado e) 
{
listaEmpleados.add(e);	
}
public static List<Empleado> pasoEmpleados() 
{
return listaEmpleados;	
}
	
	
}

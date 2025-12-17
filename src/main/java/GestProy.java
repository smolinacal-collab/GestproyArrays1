public class GestProy {
    // Atributos
    // TODO 30: Constructor GestProy DONE

    private Proyecto[] proyectos = new Proyecto[10];

    // Getters y setters usando arrays
    public Proyecto getProyecto(int numero) {
        if (numero < 0 || numero >= proyectos.length) return null;
        return proyectos[numero];
    }

    public void setProyecto(int numero, Proyecto proyecto) {
        if (numero < 0 || numero >= proyectos.length) return;
        proyectos[numero] = proyecto;
    }

    public void terminarProyecto(int numProyecto) {
        // TODO 31: Terminar proyecto DONE

        Proyecto p = getProyecto(numProyecto);
        if (p != null) {
            setProyecto(numProyecto, null); // Eliminar proyecto
        }
    }

    // Comprobar si se pueden añadir más proyectos
    public boolean puedeHaberMasProyectos() {
        return getCantidadProyectosActivos() < Ctes.MAX_NUM_PROYECTOS_GESTOR;
    }

    public int getMaxNumProyectos() {
        return Ctes.MAX_NUM_PROYECTOS_GESTOR;
    }

    // Contar proyectos activos
    public int getCantidadProyectosActivos() {
        int cantidad = 0;
        // TODO 32: Contar el número de proyectos activos utilizando un bucle  DONE

        for (int i = 0; i < proyectos.length; i++) {
            if (proyectos[i] != null) cantidad++;
        }
        return cantidad;
    }

    // Añadir horas a un proyecto
    public boolean addHorasProyecto(int numeroProyecto, int numeroHoras) {
        // TODO 33: Añadir horas al número de proyecto indicado DONE

        Proyecto p = getProyecto(numeroProyecto);
        if (p == null) return false;
        p.addHoras(numeroHoras);
        return true;
    }

    // Añadir un proyecto nuevo
    public int addProyectoNuevo(String nombreProyecto, int presupuesto) {
        // TODO 34: Agregar el proyecto si hay hueco utilizando un bucle DONE


        for (int i = 0; i < getMaxNumProyectos(); i++) {
            if (getProyecto(i) == null) {
                setProyecto(i, new Proyecto(nombreProyecto, presupuesto));
                return i;
            }
        }
        return -1; // No hay hueco
    }

    // Añadir participante a un proyecto
    public boolean addParticipanteProyecto(int numProyecto, int numTrabajador) {
        // TODO 35: Añadir al proyecto el participante validando que el proyecto y el trabajador existe


        Proyecto proyecto = getProyecto(numProyecto);
        Trabajador trabajador = Trabajadores.getTrabajador(numTrabajador);
        if (proyecto == null || trabajador == null) return false;
        return proyecto.addParticipante(trabajador);
    }

    // Mostrar todos los proyectos
    public void mostrarProyectos() {
        // TODO 36: Mostrar los proyectos junto con su número de proyecto utilizando un bucle


        for (int i = 0; i < getMaxNumProyectos(); i++) {
            Proyecto p = getProyecto(i);
            if (p != null) {
                System.out.printf("%d. %s\n", i, p);
            }
        }
    }

    // Mostrar equipo de un proyecto
    public void mostrarEquipoProyecto(int numProyecto) {
        // TODO 37: Mostrar el equipo si existe


        Proyecto p = getProyecto(numProyecto);
        if (p != null) {
            p.mostrarEquipo();
        } else {
            System.out.println("Proyecto no existe.");
        }
    }

    // Asignar líder de un proyecto
    public void setLiderProyecto(int numProyecto, int numParticipante) {
        Proyecto proyecto = getProyecto(numProyecto);
        if (proyecto != null) {
            proyecto.setLider(numParticipante);
        }
    }

    // Mostrar todos los trabajadores de la empresa
    public void mostrarTrabajadoresEmpresa() {
        Trabajadores.mostrar();
    }
}
public class Equipo {

    private Trabajador lider;

    private Trabajador[] participantes = new Trabajador[8];

    private int numParticipantes = 0;


    public int getMaxNumeroParticipantes() {
        return Ctes.MAX_NUM_PARTICIPANTES_EQUIPO;
    }

    public Trabajador getParticipante(int numero ) {

    if (numero < 1 || numero > getMaxNumeroParticipantes()) {
            return null;
        } else {
            return participantes[numero - 1];
        }
    }


    public void setParticipante(int numero, Trabajador trabajador) {

            if (numero >= 1 && numero <= getMaxNumeroParticipantes()) {
                participantes[numero - 1] = trabajador;
            }

//        switch (numero) {
//            case 1: participante1 = trabajador; break;
//            case 2: participante2 = trabajador; break;
//            case 3: participante3 = trabajador; break;
        }


    public boolean tieneLider() {
        // TODO 21: Saber si el equipo tiene líder DONE
        return lider != null;

    }

    public Trabajador getLider() {
        // TODO 22: Devolver quién es el líder DONE
        return lider;
    }

    public void setLider(int numeroParticipante) {
        // TODO 23: Asignar el liderazgo a un participante DONE
        lider = getParticipante(numeroParticipante);
    }

    public int getNumeroParticipantes() {
        // TODO 24: Calcular el número de participantes utilizando un bucle DONE
        int num = 0;
        for (int i = 0; i <=getMaxNumeroParticipantes() ; i++) {
            if (participantes[i] != null) {
                num++;
            }
        }
        return num;
    }

    public boolean estaEquipoCompleto() {  //TODO-DUDA
        return numParticipantes == getMaxNumeroParticipantes();
    }

    public boolean addParticipante(Trabajador trabajador) {
        // TODO 25: Agregar un trabajador como participante si no se ha llegado al límite utilizando un bucle DONE

        for (int i = 0; i <getMaxNumeroParticipantes() ; i++) {
            if (participantes[i] == null ) {
                participantes[i] = trabajador;
                return true;
            }
        }
        return false;
    }

    public void mostrar() {
        // TODO 26: Mostrar los participantes del equipo junto con su número de participante utilizando un bucle


        for (int i = 0; i < getMaxNumeroParticipantes(); i++) {
            Trabajador t = participantes[i];
            if (t != null) {
                String marcaLider = "";
                if (t == lider) {
                    marcaLider = " (Líder)";
                }
                System.out.printf("%d. %s%s\n", i + 1, t, marcaLider);
            }
        }
    }
//        for (int i = 0; i < getMaxNumeroParticipantes(); i++) {
//            Trabajador t = participantes[i];
//            if (t != null) {
//                System.out.println("%d. %s%s\n", i + 1, t);
//            }
//        }
//    }



    public int getPrecioHora() {
        int precio = 0;
        // TODO 27: Calcular el precio de la hora de todos los participantes del equipo utilizando un bucle DONE


        for (int i = 0; i < getMaxNumeroParticipantes(); i++) {
            Trabajador t = participantes[i];
            if (t != null) {
                precio += t.getPrecioHora();
            }
        }
        return precio;
    }
}

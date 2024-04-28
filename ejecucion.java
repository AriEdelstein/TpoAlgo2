package TpoAlgo2;

public class ejecucion {

	public static void main(String[] args) {
		// TODO Auto-generated method stub
		Metodo cola = new Metodo();
        cola.InicializarCola();

        // Ejemplo de entrada de clientes
        cola.AcolarPrioridad(101, 2);  // Cliente Particular cliente
        cola.AcolarPrioridad(102, 1);  // Cliente Empresa
        cola.AcolarPrioridad(103, 3);  // Cliente Particular no cliente
        // Puedes añadir más clientes según tus necesidades

        // Crear conjuntos para cada tipo de cliente
        int[] ConjuntoEmpresa = new int[100];
        int[] ConjuntoParticularCliente = new int[100];
        int[] ConjuntoParticularNoCliente = new int[100];
        int indiceEmpresa = 0;
        int indiceParticularCliente = 0;
        int indiceParticularNoCliente = 0;

        // Procesar clientes y agregarlos a los conjuntos respectivos
        while (!cola.ColaVacia()) {
            int cliente = cola.Primero();
            int prioridad = cola.Prioridad();
            switch (prioridad) {
                case 1:
                    ConjuntoEmpresa[indiceEmpresa++] = cliente;
                    break;
                case 2:
                    ConjuntoParticularCliente[indiceParticularCliente++] = cliente;
                    break;
                case 3:
                    ConjuntoParticularNoCliente[indiceParticularNoCliente++] = cliente;
                    break;
            }
            cola.Desacolar();
        }

        // Imprimir conjuntos
        System.out.println("Clientes atendidos según su tipo:");
        System.out.print("Conjunto Empresa: ");
        imprimirConjunto(ConjuntoEmpresa, indiceEmpresa);
        System.out.print("Conjunto Particular Cliente: ");
        imprimirConjunto(ConjuntoParticularCliente, indiceParticularCliente);
        System.out.print("Conjunto Particular No Cliente: ");
        imprimirConjunto(ConjuntoParticularNoCliente, indiceParticularNoCliente);
    }

    public static void imprimirConjunto(int[] conjunto, int size) {
        System.out.print("{");
        for (int i = 0; i < size; i++) {
            System.out.print(conjunto[i]);
            if (i < size - 1) {
                System.out.print(", ");
            }
        }
        System.out.println("}");
    }

}



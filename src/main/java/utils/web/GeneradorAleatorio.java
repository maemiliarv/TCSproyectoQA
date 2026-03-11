package utils.web;

import java.util.concurrent.ThreadLocalRandom;

public class GeneradorAleatorio {

    public static int numeroEntre(int minimo, int maximo) {
        return ThreadLocalRandom.current().nextInt(minimo, maximo + 1);
    }

}
package com.aluracursos.screenmatch.calculos;

public class FiltrosRecomendacion {
    public void filtrar(Clasificable clasificacion){

        if(clasificacion.getClasificacion() >= 4){
            System.out.println("Muy bien evaluado en el momento");
        } else if (clasificacion.getClasificacion() >= 2) {
            System.out.println("popular en el momento");
        } else{
            System.out.println("Colocalo en tu lista para verlo despues");
        }
    }

}

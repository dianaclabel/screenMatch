package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.calculos.FiltrosRecomendacion;
import com.aluracursos.screenmatch.modelos.Episodio;
import com.aluracursos.screenmatch.modelos.Pelicula;
import com.aluracursos.screenmatch.modelos.Serie;

import java.util.ArrayList;

public class Principal {
    public static void main(String[] args) {
        Pelicula miPelicula = new Pelicula("Encanto", 2021);
        miPelicula.setDuracionEnMinutos(120);
        miPelicula.setIncluidoEnElPlan(true);
        miPelicula.muestraFichaTecnica();

        miPelicula.evalua(10);
        miPelicula.evalua(10);
        miPelicula.evalua(7.8);
        System.out.println(miPelicula.getTotalDeLasEvaluaciones());
        System.out.println(miPelicula.calculaMedia());

        Serie casaDragon = new Serie("La casa del dragón",2022);
        casaDragon.setTemporadas(1);
        casaDragon.setMinutosPorEpisodio(50);
        casaDragon.setEpisodiosPorTemporada(10);
        casaDragon.muestraFichaTecnica();
        System.out.println(casaDragon.getDuracionEnMinutos());

        Pelicula otraPelicula = new Pelicula("Matrix", 1998);
        otraPelicula.setDuracionEnMinutos(180);

        FiltrosRecomendacion filtrosRecomendacion = new FiltrosRecomendacion();
        filtrosRecomendacion.filtrar(miPelicula);

        Episodio episodio = new Episodio();
        episodio.setNumero(1);
        episodio.setNombre("La casa de Targaryen");
        episodio.setSerie(casaDragon);
        episodio.setTotalVisualizaciones(50);

        filtrosRecomendacion.filtrar(episodio);

        var peliculaDeBruno = new Pelicula("El señor de los anillos", 2001);
        peliculaDeBruno.setDuracionEnMinutos(180);

        ArrayList<Pelicula> listaDePeliculas = new ArrayList<>();
        listaDePeliculas.add(miPelicula);
        listaDePeliculas.add(otraPelicula);
        listaDePeliculas.add(peliculaDeBruno);

        //size nos permite visualizar la cantidad de los items del array
        System.out.println("Tamaño de la lista: "+ listaDePeliculas.size());
        System.out.println("La primera pelicula es:"+ listaDePeliculas.get(0).getNombre());
        System.out.println(listaDePeliculas.toString());
        System.out.println("toString de la pelicula: "+listaDePeliculas.get(0).toString());













     /*   CalculadoraDeTiempo calculadora = new CalculadoraDeTiempo();
        calculadora.incluye(miPelicula);
        calculadora.incluye(casaDragon);
        calculadora.incluye(otraPelicula);
        System.out.println("Tiempo necesario para ver tus titulos favoritos en estas vacaciones " + calculadora.getTiempoTotal() + " minutos");
    */







    }
}

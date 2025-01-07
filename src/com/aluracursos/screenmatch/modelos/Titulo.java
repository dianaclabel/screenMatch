package com.aluracursos.screenmatch.modelos;

import com.aluracursos.screenmatch.exception.ErrorEnConversionDeDuracionException;
import com.google.gson.annotations.SerializedName;

public class Titulo implements Comparable <Titulo> {
        @SerializedName("Title")
        private String nombre;
        @SerializedName("Year")
        private int fechaDeLanzamiento;
        private int duracionEnMinutos;
        private boolean incluidoEnElPlan;
        private double sumaDeLasEvaluaciones;
        private int totalDeLasEvaluaciones;

    public Titulo(String nombre, int fechaDeLanzamiento) {
        this.nombre = nombre;
        this.fechaDeLanzamiento = fechaDeLanzamiento;
    }

    public Titulo(TituloOmbd miTituloOmbd) {
        this.nombre = miTituloOmbd.title();
        //Integer.valueof permite hacer us caste de string a numero.
        this.fechaDeLanzamiento =Integer.valueOf(miTituloOmbd.year());
        if (miTituloOmbd.runtime().contains("N/A")){
            throw new ErrorEnConversionDeDuracionException("No pude convertir la duracion"+
                    "porque contiene  N/A");
        }
        this.duracionEnMinutos = Integer.valueOf(miTituloOmbd.runtime().replaceAll("\\D",""));
    }

    public void setNombre(String nombre) {
            this.nombre = nombre;
        }

        public void setFechaDeLanzamiento(int fechaDeLanzamiento) {
            this.fechaDeLanzamiento = fechaDeLanzamiento;
        }

        public void setDuracionEnMinutos(int duracionEnMinutos) {
            this.duracionEnMinutos = duracionEnMinutos;
        }

        public void setIncluidoEnElPlan(boolean incluidoEnElPlan) {
            this.incluidoEnElPlan = incluidoEnElPlan;
        }

        public int getTotalDeLasEvaluaciones(){
            return totalDeLasEvaluaciones;
        }

        public String getNombre() {
            return nombre;
        }

        public int getFechaDeLanzamiento() {
            return fechaDeLanzamiento;
        }

        public int getDuracionEnMinutos() {
            return duracionEnMinutos;
        }

        public boolean isIncluidoEnElPlan() {
            return incluidoEnElPlan;
        }

        public void muestraFichaTecnica(){
            System.out.println("El nombre de la pelicula es: "+ nombre);
            System.out.println("Su fecha de lanzamiento es: " + fechaDeLanzamiento);
            System.out.println("Duración en minutos : "+  getDuracionEnMinutos());
        }

        public void evalua(double nota){
            sumaDeLasEvaluaciones += nota;
            totalDeLasEvaluaciones ++;
        }

        public double calculaMedia(){
            return sumaDeLasEvaluaciones / totalDeLasEvaluaciones;
        }


    @Override
    public int compareTo(Titulo otroTitulo) {
        return this.getNombre().compareTo(otroTitulo.getNombre());
    }

    @Override
    public String toString() {
        return
                "nombre='" + nombre + '\'' +
                ", fechaDeLanzamiento=" + fechaDeLanzamiento +
                ", duración : " + duracionEnMinutos ;
    }
}

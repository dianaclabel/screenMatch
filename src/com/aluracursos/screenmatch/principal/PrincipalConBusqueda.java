package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.exception.ErrorEnConversionDeDuracionException;
import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmbd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

import java.io.FileWriter;
import java.io.IOException;
import java.net.URI;
import java.net.http.HttpClient;
import java.net.http.HttpRequest;
import java.net.http.HttpResponse;
import java.util.Scanner;


public class PrincipalConBusqueda {
    public static void main(String[] args) throws IOException, InterruptedException {

        Scanner lectura = new Scanner(System.in);
        System.out.println("Escriba el nombre de la pelicula");
        var busqueda = lectura.nextLine();
        System.out.println(busqueda);

        String direccion="https://www.omdbapi.com/?t="+
                busqueda.replace(" ","+")+
                "&apikey=597dbcb5";

        //HttpRequest es una clase abstracta quiere decir que es parecido a una interface
        // hay algunos metodos que estan implementados otros que no.
        try{
            HttpClient client = HttpClient.newHttpClient();
            HttpRequest request = HttpRequest.newBuilder()
                    .uri(URI.create(direccion))
                    .build();

            HttpResponse<String> response = client
                    .send(request, HttpResponse.BodyHandlers.ofString());

            String json  =  response.body();
            System.out.println(json);

            Gson gson =  new GsonBuilder().setFieldNamingPolicy(FieldNamingPolicy.UPPER_CAMEL_CASE).create();
            TituloOmbd miTituloOmbd = gson.fromJson(json, TituloOmbd.class );
            System.out.println(miTituloOmbd);

            Titulo miTitulo = new Titulo(miTituloOmbd);
            System.out.println("Titulo ya convertido: " + miTitulo);

            FileWriter escritura = new FileWriter("Peliculas.txt");
            escritura.write(miTitulo.toString());
            escritura.close();
        }catch(NumberFormatException e){
            System.out.println("Ocurrió un error");
            System.out.println(e.getMessage());
        }catch (IllegalArgumentException e){
            System.out.println("Error en la URI, verifique la dirección.");

        }catch (ErrorEnConversionDeDuracionException e){
            System.out.println(e.getMessage());
        }

        System.out.println("Finalizo la ejecución del programa");




    }
}

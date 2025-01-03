package com.aluracursos.screenmatch.principal;

import com.aluracursos.screenmatch.modelos.Titulo;
import com.aluracursos.screenmatch.modelos.TituloOmbd;
import com.google.gson.FieldNamingPolicy;
import com.google.gson.Gson;
import com.google.gson.GsonBuilder;

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

        String direccion="https://www.omdbapi.com/?t="+ busqueda+"&apikey=597dbcb5";
        //HttpRequest es una clase abstracta quiere decir que es paraecido a una interface
        // hay algunos metodos que estan implementados otros que no.
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
        System.out.println(miTitulo);



    }
}

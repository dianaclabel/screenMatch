package com.aluracursos.screenmatch.exception;

public class ErrorEnConversionDeDuracionException extends RuntimeException {
    // Hacemos que extienda de RuntimeException y no de Throwable ya que Throwable lo que se esta haciendo es crea una clase
    //checkcable y hace que implemente un throw.

    private String mensaje;

    public ErrorEnConversionDeDuracionException(String mensaje) {
        this.mensaje =  mensaje;
    }

    @Override
    public String getMessage() {
        return this.mensaje;
    }
}

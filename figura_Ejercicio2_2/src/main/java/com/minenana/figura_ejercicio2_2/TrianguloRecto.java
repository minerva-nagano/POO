package com.minenana.figura_ejercicio2_2;

public class TrianguloRecto extends FigurasRectas {

    public TrianguloRecto(int alto, int ancho) {
        this.alto = alto;
        this.ancho = ancho;
    }

    @Override
    public double calcularArea() {
        return (alto * ancho) / 2.0;
    }

    @Override
    public double calcularPerimetro() {
        double hipotenusa = Math.sqrt(Math.pow(alto, 2) + Math.pow(ancho, 2));
        return alto + ancho + hipotenusa;
    }

    @Override
    public String imprimeFigura() {
        return String.format("Se imprime una FiguraPlana...\n\nSe imprime un Triangulo con alto: %d, ancho: %d, area: %.2f, perimetro: %.2f", alto, ancho, calcularArea(), calcularPerimetro());
    }
}
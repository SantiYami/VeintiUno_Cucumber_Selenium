/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package juego;

/**
 *
 * @author david
 */
public class Carta {
    private char simbolo; //2-3-4-5-6-7-8-9-D-J-Q-K-A D=diez
    private char tipo;//P/C/R/T Picas/Corazones/Rombos/Treboles
    
    public Carta() {

	}
    

    public Carta(char simbolo, char tipo) {
		this.simbolo = simbolo;
		this.tipo = tipo;
	}

	public void setSimbolo(char simbolo) {
        this.simbolo = simbolo;
    }

    public void setTipo(char tipo) {
        this.tipo = tipo;
    }

    public char getSimbolo() {
        return simbolo;
    }

    public char getTipo() {
        return tipo;
    }
    
    public int obtenerValorSimbolo(){
        if (this.simbolo=='D' || this.simbolo=='J' || this.simbolo=='Q' || this.simbolo=='K') {
            return 10;
        }else{
            if (this.simbolo=='A'){
                return 1;
            }else{
                return Integer.parseInt(this.simbolo+"");
            }
        }
    }

    @Override
    public String toString() {
        return "Carta{" + "simbolo=" + simbolo + ", tipo=" + tipo + '}';
    }
    
    
}

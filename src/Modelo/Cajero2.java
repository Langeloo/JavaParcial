/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package Modelo;

import java.util.ArrayList;

/**
 *
 * @author migue
 */
public class Cajero2 extends Thread{
    
      private ArrayList<String> listac;
    private ArrayList<Cliente> clientes;

    public Cajero2(ArrayList<String> listac, ArrayList<Cliente> clients) {
        this.listac = listac;
        this.clientes = clients;
    }
    
    
    @Override
    public void run(){
        for(int i = 0 ; i < listac.size(); i++){
            if(i % 2 == 0){
                
                
                String linea[] = listac.get(i).split(";");
                Cliente cli = new Cliente();
                    int zero = 0;
                    int uno = 1;
                    int dos = 2;
                for(int j=0; j<linea.length/3; j++){
                    String datos[] = listac.get(i).split(";");
                    Producto pro = new Producto(datos[zero],Integer.parseInt(datos[uno]),Integer.parseInt(datos[dos]));
                  //  esperarXsegundos(Integer.parseInt(datos[dos]));
                    cli.getProductos().add(pro);
                    zero=zero+3 ;
                    uno=uno+3;
                    dos=dos+3;
                    
                }
                clientes.add(cli);
            }
        } 
    }
    
    
    
    
    
    
    private void esperarXsegundos(int segundos) {
            try{
                Thread.sleep(segundos*1000);
            }catch(InterruptedException ex){
                Thread.currentThread().interrupt();
            }
        }
    
    
}

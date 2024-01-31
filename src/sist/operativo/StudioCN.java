/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package sist.operativo;
import java.util.concurrent.Semaphore;
/**
 *
 * @author Emilio Jr
 */
public class StudioCN {
    public static Semaphore[]
            /**
             * Cada elemento representa un recurso compartido diferente en el estudio CN. 
             * El número dentro de cada Semaphore indica la cantidad de permisos disponibles (capacidad máxima drive)
             */
            semaforos = {new Semaphore(25), new Semaphore(20), new Semaphore(55), new Semaphore(35), new Semaphore(10)};
    public static Semaphore
            /**
             * Este semaforo permite el acceso a un único hilo a la vez (ensambla un capitulo)
             */
            semaforoEnsamblador = new Semaphore(1);
    public static Semaphore 
            /*
            Asegura que las operaciones de revisión y actualización del estado del día de producción se realicen de manera ordenada 
            */
            revisarDia = new Semaphore(1);
    public static int [] 
            /**
             * Este arreglo contabiliza el número de guiones, animaciones, plt, etc. que haya
             * registro de cuántas partes se han producido o consumido, o realizar cálculos 
             * y decisiones basadas en la disponibilidad de ciertas partes en el proceso de producción.
             */
            partesCapitulo = {0,0,0,0,0};
    public static TrabajadorrCN[] guion;
    public static TrabajadorrCN[] escenario;
    public static TrabajadorrCN[] animacion;
    public static TrabajadorrCN[] doblaje;
    public static TrabajadorrCN[] plotwist;
    public static EnsambladorCN[] ensamblador;
}

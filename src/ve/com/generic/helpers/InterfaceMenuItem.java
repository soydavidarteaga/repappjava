/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.generic.helpers;

import java.io.File;

/**
 *
 * @author salon2-2
 */
public interface InterfaceMenuItem {
    public final char SEP = File.separatorChar;
    public final String[] NOMBRE_ARCHIVO = {
        "Nuevo",
        "Abrir...",
        "-",
        "Guardar",
        "Guardar Como...",
        "-",
        "Importar",
        "Exportar",
        "-",
        "Cerrar",
        "-",
        "Salir"
    };
    public final char[] LETRAS = {
        'n',
        'a',
        '-',
        'g',
        'u',
        'u',
        '-',
        'i',
        'e',
        '-',
        'c',
        '-',
        's'
    };
    
    public final String[] RUTA_ICONOS = {
       "iconos16"+SEP+"nuevo.png",
        "iconos16"+SEP+"abrir.png",
        "-",
        "iconos16"+SEP+"guardar.png",
        "iconos16"+SEP+"guardar2.png",
        "-",
        "-",
        "-",
        "-",
        "iconos16"+SEP+"cerrar.png",
        "-",
        "-"
    };
}

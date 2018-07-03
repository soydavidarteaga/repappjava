/*
 * To change this license header, choose License Headers in Project Properties.
 * To change this template file, choose Tools | Templates
 * and open the template in the editor.
 */
package ve.com.generic.helpers;

import java.io.File;

/**
 *
 * @author S2M6-2
 */
public interface InterfaceMenuContexto {
    public final char SEP = File.separatorChar;
    public final String[] MENU_CONTEXTO = {
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
    
    public final String[] ICONOS_CONTEXTO = {
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

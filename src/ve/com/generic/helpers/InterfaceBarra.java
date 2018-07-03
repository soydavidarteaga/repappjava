package ve.com.generic.helpers;

import java.io.File;

/**
 *
 * @author salon2-2
 */
public interface InterfaceBarra {
 public final String[] TOOL_TIP_TEXT_BARRA = {
   "Nuevo",
    "Abrir",
    "-",
    "Guardar",
    "Guardar Como",
    "-",
    "Cerrar"
 };
 public char SEP = File.separatorChar;
 public final String[] RUTA_ICONOS = {
   "iconos16"+SEP+"nuevo.png",
     "iconos16"+SEP+"abrir.png",
     "-",
     "iconos16"+SEP+"guardar.png",
     "iconos16"+SEP+"guardar2.png",
     "-",
     "iconos16"+SEP+"cerrar.png"
 };
}

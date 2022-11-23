import java.io.IOException;
import java.nio.file.Path;


/**
 *
 * @author berna
 */
public class CJasonJava{
    public static final String rutafitxerJson ="C:\\Users\\berna\\Desktop\\DAM2\\Accés a dades\\json\\jsonModuls.json";

    public static void main(String args[]) {

        try {
            String strfitxerJSON= new String(Filas.readAllBytes(Path.get(rutafitxerJson)));
            System.out.println(strfitxerJSON);
            JSONobject jsonObj;
            jsonObj = new JSONobject(strfitxerJSON);
            System.out.println("Key set"+jsonObj.keyset());
            System.out.println("length"+jsonObj.length());
            String institutvalue =jsonObj.getString("institut");
            System.out.print ("")

        }catch(IOException e){
            e.printStackTrace();


        }catch(JSONException e){
            e.printStackTrace();

      }
    }
}
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.ResultSet;
import java.sql.Statement;

public class conexion {

    public conexion(){
        try{
            // Se registra el Driver de MySQL
            Class.forName("com.mysql.cj.jdbc.Driver");
            Connection conexion = DriverManager.getConnection(
                    "jdbc:mysql://localhost/poo", "root", "marlon");
            //se crea un Statemen, para realizar la consulta
            Statement s = conexion.createStatement();

            //Se reakuza ka cibsykta. Los resultados se guardan en el
            // ResultSet rs
            ResultSet rs = s.executeQuery("select * from estudiantes");
            //Se recorre el ResultSet, mostrando po pantalla los resultados
            while (rs.next()){
                System.out.println(rs.getString("Nombre_est") +
                        " " + rs.getString(2));
            }
            //Se cierra la conexion con la base de datos.
            conexion.close();
        }catch (Exception e){
            e.printStackTrace();
        }
    }
}

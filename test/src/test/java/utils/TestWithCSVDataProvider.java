package utils;
import org.testng.annotations.DataProvider;

import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;
import java.util.ArrayList;
import java.util.List;
import java.util.stream.Stream;
import org.testng.annotations.Parameters;

public class TestWithCSVDataProvider {
	
	
	//Dataproviders
	@DataProvider(name = "datos")
    public Object[][] createDataCSV() throws IOException {
        String filePath = "src/resources/WikiDatos.csv"; // Ruta al archivo CSV
        return readCSV(filePath);
    }
	//Dataproviders
	@DataProvider(name = "WikiDatos")
    public Object[][] createDataWikiCSV() throws IOException {
        String filePath = "src/resources/WikiDatos.csv"; // Ruta al archivo CSV
        return readCSV(filePath);
    }
	@DataProvider(name = "GoogleDatos")
    public Object[][] createDataGoogleCSV() throws IOException {
        String filePath = "src/resources/GoogleDatos.csv"; // Ruta al archivo CSV
        return readCSV(filePath);
    }
	@DataProvider(name = "DemoDatos")
    public Object[][] createDataDemoCSV() throws IOException {
        String filePath = "src/resources/DemoDatos.csv"; // Ruta al archivo CSV
        return readCSV(filePath);
    }

    // Función que lee el CSV y devuelve los datos en formato Object[][]
    public Object[][] readCSV(String filePath) throws IOException {
        List<Object[]> data = new ArrayList<>();
        BufferedReader br = new BufferedReader(new FileReader(filePath));
        String line;
        
        // Lee el archivo línea por línea y agrega cada valor a la lista
        while ((line = br.readLine()) != null) {
            data.add(new Object[] { line });
        }
        br.close();

        // Convierte la lista a un arreglo de Object[][]
        return data.toArray(new Object[data.size()][]);
    }
}

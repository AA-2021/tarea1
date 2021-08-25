package utilidades;

import java.io.FileInputStream;
import java.io.IOException;
import java.util.ArrayList;
import java.util.Iterator;

import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.CellType;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.ss.util.NumberToTextConverter;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class DataDriven {
	
	public static ArrayList<String> getData(String nombreCP) throws IOException {
		
		ArrayList<String> a = new ArrayList<String>();
		
		//instanciar un objeto de tipo file
		FileInputStream file = new FileInputStream(
				"C:\\eclipse-workspace\\PageObjectModel_primerosPasos_YO\\src\\test\\resources\\Data\\DatosPruebas.xlsx");
		
		
		//instanciar un libro de excel
		XSSFWorkbook excel = new XSSFWorkbook(file);
		
		
		//devuelve la cantidad de hojas del libro excel
		
		int sheets = excel.getNumberOfSheets();
		
		
		for(int i=0; i < sheets;i++ ) {
			if(excel.getSheetName(i).equalsIgnoreCase("dataPrueba")) { //pregunta por la hoja con la que se quiere trabajar 
				//encontre la hoja
				XSSFSheet hojaExcel = excel.getSheetAt(i);
				
				Iterator<Row> filas = hojaExcel.iterator();
				
				//creamos un objeto de tipo fila con la primera fila
				//de la hoja con los casos de prueba
				Row fila = filas.next();
				
				Iterator<Cell> celdas = fila.cellIterator();
				
				int k=0;
				int columna = 0;
				
				while(celdas.hasNext()) { //hasNext() comprobar que siguen quedando elementos en el iterador
					Cell celdaSelecciona = celdas.next();//siguiente elemento del iterador
					
					if(celdaSelecciona.getStringCellValue().equalsIgnoreCase(
							"CasosDePrueba")) {
						//encontre la columna
						columna = k;
					}
					k++;
				}
			
				while(filas.hasNext()) {
					Row r = filas.next();//fila
					
					if(r.getCell(columna).getStringCellValue().equalsIgnoreCase(nombreCP)) { //columna es el indice de la celda. nombreCP ->cp01
						
						Iterator<Cell> cv = r.cellIterator();
						
						while(cv.hasNext()) { //mientras exista un valor para iterar
							Cell c = cv.next();
							
							if(c.getCellTypeEnum() == CellType.STRING ||c.getCellTypeEnum() == CellType.BLANK) {
								a.add(c.getStringCellValue());
							}else{
								a.add(NumberToTextConverter.toText(c.getNumericCellValue()));
							}

						}
					}
				}
			}
		}
		return a;//el arreglo

	}
		
}

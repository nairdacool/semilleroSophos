package tiendaTelmexExcelTest;

import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import atu.testrecorder.exceptions.ATUTestRecorderException;

import static utilidadesExcel.UtilidadesExcel.*;

public class ExcelJunit {
	
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test() throws IOException, ATUTestRecorderException {
		iniciarGrabacion();
		abrirNavegador();
		verificarControladorNoSeaNulo();
		leerDatosTablaExcel();
		realizarBusquedaDeArticulos();
		detenerGrabacion();
	}
	
	@After
	public void tearDown() throws Exception {
		generarReporteEnArchivoDeBusquedaExcel();
		cerrarNavegador();
	}
	
}
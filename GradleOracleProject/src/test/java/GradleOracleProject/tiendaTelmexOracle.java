package GradleOracleProject;

import static utilidadesOracle.UtilidadesOracle.*;
//import static utilidadesOracle.UtilidadesExcel.cerrarNavegador;
//import static utilidadesOracle.UtilidadesExcel.detenerGrabacion;
//import static utilidadesOracle.UtilidadesExcel.generarReporteEnArchivoDeBusquedaExcel;
//import static utilidadesOracle.UtilidadesExcel.iniciarGrabacion;
//import static utilidadesOracle.UtilidadesExcel.leerDatosTablaExcel;
//import static utilidadesOracle.UtilidadesExcel.realizarBusquedaDeArticulos;
//import static utilidadesOracle.UtilidadesExcel.verificarControladorNoSeaNulo;

import java.io.IOException;

import org.junit.After;
import org.junit.Before;
import org.junit.Test;

import atu.testrecorder.exceptions.ATUTestRecorderException;

public class tiendaTelmexOracle {
	
	@Before
	public void setUp() throws Exception {

	}

	@Test
	public void test() throws IOException, ATUTestRecorderException {
		iniciarGrabacion();
		abrirNavegador();
		verificarControladorNoSeaNulo();
		crearConexionConLaBD();
		realizarBusquedaDeArticulos();
		cerrarConexionConLaBD();
		detenerGrabacion();
	}
	
	@After
	public void tearDown() throws Exception {
		cerrarConexionConLaBD();
		cerrarNavegador();
	}
	
}
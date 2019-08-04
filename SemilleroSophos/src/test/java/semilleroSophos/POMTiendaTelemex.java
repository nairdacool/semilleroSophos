package semilleroSophos;

import static utilidadesPOM.MisUtilidades.*;

import java.io.IOException;
import org.junit.Test;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class POMTiendaTelemex {
	
	@Test
	public void test() throws InterruptedException, IOException, ATUTestRecorderException {
		abrirNavegador();
		verificarNoNullControlador();
		escribirEnElCampoDeBusqueda("Lavadora");
		ingresarAlPrimerResultado();
		agregarAlCarritodeCompras();
		irAlCarritodeCompras();
		tomarPantallazo();
		verificacionContenidoCarritoCompras();
		realizarCompra();
		cerrarNavegador();
	}

}

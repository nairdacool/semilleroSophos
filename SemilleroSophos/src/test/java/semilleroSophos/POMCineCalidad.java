package semilleroSophos;

import static utilidadesPOM.MisUtilidades.*;

import java.io.IOException;
import org.junit.Test;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class POMCineCalidad {
	
	@Test
	public void test() throws InterruptedException, IOException, ATUTestRecorderException {
		abrirNavegador();
		verificarNoNullControlador();
		iniciarGrabacion();
		verificarNotNullFecha();
		escribirEnElCampoDeBusqueda("Cine Calidad");
		tomarPantallazo();
		ingresarAlPrimerResultado();
		tomarPantallazo();
		buscarPelicula("Avengers");
		tomarPantallazo();
		detenerGrabacion();
		cerrarNavegador();
	}

}

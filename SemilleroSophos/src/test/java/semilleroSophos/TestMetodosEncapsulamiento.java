package semilleroSophos;

import static utilidades.MisUtilidades.*;
import java.io.IOException;
import org.junit.Test;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class TestMetodosEncapsulamiento {
	
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

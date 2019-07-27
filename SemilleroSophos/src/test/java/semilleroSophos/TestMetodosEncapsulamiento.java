package semilleroSophos;

import static utilidades.MisUtilidades.*;
import java.io.IOException;
import org.junit.After;
import org.junit.Before;
import org.junit.Test;
import atu.testrecorder.exceptions.ATUTestRecorderException;

public class TestMetodosEncapsulamiento {

	@Before
	public void setUp() throws Exception {
		abrirNavegador();
		iniciarGrabacion();
	}
	
	@Test
	public void test() throws InterruptedException, IOException, ATUTestRecorderException {
		escribirEnElCampoDeBusqueda("Cine Calidad");
		tomarPantallazo();
		ingresarAlPrimerResultado();
		tomarPantallazo();
		buscarPelicula("Avengers");
		tomarPantallazo();
	}

	@After
	public void tearDown() throws Exception {
		detenerGrabacion();
		cerrarNavegador();
	}

}

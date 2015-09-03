package org.activestack.connectors;

import static org.junit.Assert.*;

import java.util.ArrayList;
import java.util.Iterator;
import java.util.List;
import java.util.Vector;

import org.junit.After;
import org.junit.AfterClass;
import org.junit.Before;
import org.junit.BeforeClass;
import org.junit.Test;
import org.junit.runner.RunWith;
import org.mockito.InjectMocks;
import org.mockito.internal.util.reflection.Whitebox;
import org.mockito.runners.MockitoJUnitRunner;

import com.pulse.sync.helpers.HttpLogicConnector;
import com.pulse.sync.helpers.HttpLogicConnector.SoapConnectorDefinition;

@RunWith(MockitoJUnitRunner.class)
public class HttpLogicConnectorTest {
	
	@InjectMocks
	private HttpLogicConnector httpLogicConnector;

	@BeforeClass
	public static void setUpBeforeClass() throws Exception {
	}

	@AfterClass
	public static void tearDownAfterClass() throws Exception {
	}

	@Before
	public void setUp() throws Exception {
	}

	@After
	public void tearDown() throws Exception {
	}

	@Test
	public void test() {
		String estartWsdlUrl = "http://localhost:8900/estart/estart.wsdl";
		SoapConnectorDefinition soapConnector = httpLogicConnector.importSoapConnectorDefinition(estartWsdlUrl, true);
		
		ClassLoader classLoader = (ClassLoader) Whitebox.getInternalState(httpLogicConnector, "classLoader");
		Vector classes = (Vector) Whitebox.getInternalState(classLoader, "classes");
//		ClassLoader classLoader = httpLogicConnector.classLoader
		
		List<Object> myClasses = new ArrayList<Object>();
		Iterator itrClasses = classes.iterator();
		while (itrClasses.hasNext()) {
			try {
				Object nextClass = itrClasses.next();
				Class<?> nextClassT = (Class<?>) nextClass;
				if (nextClassT.getCanonicalName().startsWith("com.cybershift.wfm3")) {
					myClasses.add(nextClass);
				}
			} catch(Exception e) {
				e.printStackTrace();
			}
		}
		
		System.out.println(myClasses.size());
		
		assertNotNull(soapConnector);
	}

}

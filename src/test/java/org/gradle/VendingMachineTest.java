package org.gradle;

import static org.junit.Assert.assertEquals;
import static org.junit.Assert.assertTrue;

import org.junit.Before;
import org.junit.Test;

public class VendingMachineTest {
	
	public  VendingMachine vendingMachine;
	public Producto producto1;
	public Producto producto2;
	
	@Before
	public void setup() {
		vendingMachine = new VendingMachine();
		
		producto1 = new Producto();
		producto1.setCodigoProducto("A10");
		producto1.setPrecioProducto(2000);
		producto1.setNombreProducto("Cholatina JET");
		producto1.setStockProducto(50);
		
		producto2 = new Producto();
		producto2.setCodigoProducto("B10");
		producto2.setPrecioProducto(3000);
		producto2.setNombreProducto("Arequipe");
		producto2.setStockProducto(10);
	}
	
	
	
	@Test
	public void ingresoExisteProductoCodigoyObtengoObjetoProducto() {
		// arrange definicion de la variables
		
		
		String codigoProducto="A10";
		
		// act- accion
				
		boolean resultado = VendingMachine.existeProducto(producto1, codigoProducto);
		
		// assert
		assertTrue(resultado);
	}
	
	@Test
	public void existeExistenciayObtengoAfirmacion() {
		// arrange definicion de la variables
		
		
		//String codigoProducto="B10";
		
		// act- accion
				
		boolean resultado = VendingMachine.existenciaStock(producto1);
		
		// assert
		assertTrue(resultado);
	}
	
	
	@Test
	public void ingresoDineroyObtengoSumatoria() {
		// arrange definicion de la variables
		int dinero[]= {100, 500, 2000};
		
		//String codigoProducto="B10";
		
		// act- accion
				
		int resultado = VendingMachine.ingresoDinero(dinero);
		
		// assert
		assertEquals(2600,resultado);
	}
	
	
	@Test
	public void ingresoDineroyObtengoSiAlcanza() {
		// arrange definicion de la variables
		int dinero[]= {100, 500, 2000};
		
		//String codigoProducto="B10";
		
		// act- accion
				
		boolean resultado = VendingMachine.ingresoDineroAlcanza(producto1,dinero);
		
		// assert
		assertTrue(resultado);
	}
	
	@Test
	public void ingresoDineroyObtengoDevueltaSiAlcanza() {
		// arrange definicion de la variables
		int dinero[]= {100, 500, 2000};
		
		// act- accion
				
		int resultado = VendingMachine.ingresoDineroYDevuelvo(producto1,dinero);
		
		// assert
		assertEquals(600,resultado);
	}
	
	@Test
	public void entregoProductoyRestoStock() {
		// arrange definicion de la variables
		
		
		// act- accion
				
		int resultado = VendingMachine.restoStockProducto(producto1);
		
		// assert
		assertEquals(49,resultado);
	}
	
	@Test
	public void validarEntregaProducto() {
		// arrange definicion de la variables
		int dinero[]= {100, 500, 2000};
		String codigoProducto="A10";
		
		// act- accion
				
		int resultado = VendingMachine.validarEntregaProducto(producto1,dinero, codigoProducto);
		
		// assert
		assertEquals(600, resultado);
	}
	
	@Test
	public void validarNoEntregaProducto() {
		// arrange definicion de la variables
		int dinero[]= {100, 500, 200};
		String codigoProducto="A10";
		
		// act- accion
				
		int resultado = VendingMachine.validarEntregaProducto(producto1,dinero, codigoProducto);
		
		// assert
		assertEquals(resultado,-1);
	}
	
}

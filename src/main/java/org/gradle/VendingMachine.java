package org.gradle;

public class VendingMachine {

	public static boolean existeProducto(Producto producto, String codigoProducto) {
		return (producto.getCodigoProducto().equals(codigoProducto));

	}

	public static boolean existenciaStock(Producto producto1) {

		return (producto1.getStockProducto() > 0);
	}

	public static int ingresoDinero(int[] dinero) {
		int totalDinero = 0;

		for (int i = 0; i < dinero.length; i++) {
			totalDinero += dinero[i];
		}

		return (totalDinero);
	}

	public static boolean ingresoDineroAlcanza(Producto producto1, int[] dinero) {

		int totalDinero = ingresoDinero(dinero);

		return (totalDinero >= producto1.getPrecioProducto());

	}

	public static int ingresoDineroYDevuelvo(Producto producto1, int[] dinero) {
		int totalDinero = ingresoDinero(dinero);

		if (totalDinero >= producto1.getPrecioProducto()) {
			return totalDinero - producto1.getPrecioProducto();
		}
		return 0;
	}

	public static int validarEntregaProducto(Producto producto1, int[] dinero, String codigoProducto) {
		
		if (existeProducto(producto1, codigoProducto) && 
				existenciaStock(producto1) && 
				ingresoDinero(dinero) > 0 &&
				ingresoDineroAlcanza(producto1, dinero)) {
			restoStockProducto(producto1);
			return ingresoDineroYDevuelvo(producto1, dinero);
		}
			return -1;
	}

	public static int restoStockProducto(Producto producto1) {
		if(producto1.getStockProducto() > 0) {
			return --producto1.stockProducto;
		}
		
		return 0;
	}

}
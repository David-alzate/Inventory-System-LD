package co.inventory.system.ld.crosscutting.messagecatalog.impl;

import java.util.HashMap;
import java.util.Map;

import co.inventory.system.ld.crosscutting.exceptions.CroscutingInventorySystemException;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.messagecatalog.MessageCatalog;
import co.inventory.system.ld.crosscutting.messagecatalog.data.Message;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;

public class MessageCatalogBase implements MessageCatalog {

	private final Map<String, Message> messages = new HashMap<>();

	@Override
	public void initialize() {
		messages.clear();
		messages.put(MessageCode.M00001.getIdentifer(), new Message(MessageCode.M00001,
				"El código del mensaje que quiere obtener del catálogo mensajes llegó nulo..."));
		messages.put(MessageCode.M00002.getIdentifer(), new Message(MessageCode.M00002,
				"Se ha presentado un problema tratando de llevar a cabo la operación deseada..."));
		messages.put(MessageCode.M00003.getIdentifer(), new Message(MessageCode.M00003,
				"El mensajeque se intentó obtener, no está en el catálogo de mensajes base..."));
		messages.put(MessageCode.M00004.getIdentifer(), new Message(MessageCode.M00004,
				"El mensaje que se intentó obtener, no está configurado para residir en el catálogo de mensajes base..."));
		
		// Users - Exceptions
		
		messages.put(MessageCode.M00005.getIdentifer(), new Message(MessageCode.M00005,
				"El formato del email del usuario no es valido"));
		messages.put(MessageCode.M00006.getIdentifer(), new Message(MessageCode.M00006,
				"El email del usuario ya existe"));
		messages.put(MessageCode.M00007.getIdentifer(), new Message(MessageCode.M00007,
				"El id del usuario ya existe"));
		messages.put(MessageCode.M00008.getIdentifer(), new Message(MessageCode.M00008,
				"El id no puede ser nulo"));
		messages.put(MessageCode.M00009.getIdentifer(), new Message(MessageCode.M00009,
				"Ya Existe un usuario con este numero de documento para este tipo de usuario"));
		messages.put(MessageCode.M00010.getIdentifer(), new Message(MessageCode.M00010,
				"El tamaño para el número de identificación del usuario no es valido"));
		messages.put(MessageCode.M00011.getIdentifer(), new Message(MessageCode.M00011,
				"El formato del apellido del usuario no es valido"));
		messages.put(MessageCode.M00012.getIdentifer(), new Message(MessageCode.M00012,
				"El apellido del usuario no puede ser vacio"));
		messages.put(MessageCode.M00013.getIdentifer(), new Message(MessageCode.M00013,
				"El apellido del usuario no puede ser nulo"));
		messages.put(MessageCode.M00014.getIdentifer(), new Message(MessageCode.M00014,
				"El tamaño del apellido no es valido"));
		messages.put(MessageCode.M00015.getIdentifer(), new Message(MessageCode.M00015,
				"El formato del nombre del usuario no es valido"));
		messages.put(MessageCode.M00016.getIdentifer(), new Message(MessageCode.M00016,
				"El nombre del usuario no puede ser vacio"));
		messages.put(MessageCode.M00017.getIdentifer(), new Message(MessageCode.M00017,
				"El nombre del usuario no puede ser nulo"));
		messages.put(MessageCode.M00018.getIdentifer(), new Message(MessageCode.M00018,
				"El tamaño del nombre no es valido"));
		
		// Users - Interactor and controller
		
		messages.put(MessageCode.M00019.getIdentifer(), new Message(MessageCode.M00019, 
				"Se ha presentado un problema registrando el usuario"));
		messages.put(MessageCode.M00020.getIdentifer(), new Message(MessageCode.M00020, 
				"Se ha presentado un problema INESPERADO registrando el usuario"));
		messages.put(MessageCode.M00021.getIdentifer(), new Message(MessageCode.M00021, 
				"Se ha presentado un problema tratando de consultar los Usuarios"));
		
		messages.put(MessageCode.M00022.getIdentifer(), new Message(MessageCode.M00022, 
				"Usuario creado exitosamente"));
		messages.put(MessageCode.M00023.getIdentifer(), new Message(MessageCode.M00023, 
				"Usuarios Consultados exitosamente"));
		
		// Commons - Exceptions
		
		messages.put(MessageCode.M00024.getIdentifer(), new Message(MessageCode.M00024, 
				"El id del tipo de identificacion no existe."));
		messages.put(MessageCode.M00025.getIdentifer(), new Message(MessageCode.M00025, 
				"El id del tipo de identificacion no puede ser el valor por defecto"));
		messages.put(MessageCode.M00026.getIdentifer(), new Message(MessageCode.M00026, 
				"El id del tipo de identificacion no puede ser nulo"));
		
		messages.put(MessageCode.M00027.getIdentifer(), new Message(MessageCode.M00027, 
				"El id del status no existe."));
		messages.put(MessageCode.M00028.getIdentifer(), new Message(MessageCode.M00028, 
				"El id del status no puede ser el valor por defecto"));
		messages.put(MessageCode.M00029.getIdentifer(), new Message(MessageCode.M00029, 
				"El id del status no puede ser nulo"));

		// Suppliers - Exceptions

		messages.put(MessageCode.M00030.getIdentifer(), new Message(MessageCode.M00030,
				"El id del proveedor ya existe."));
		messages.put(MessageCode.M00031.getIdentifer(), new Message(MessageCode.M00031,
				"El id del proveedor no existe"));
		messages.put(MessageCode.M00032.getIdentifer(), new Message(MessageCode.M00032,
				"El id del proveedor es nulo"));
		messages.put(MessageCode.M00033.getIdentifer(), new Message(MessageCode.M00033,
				"El formato del nombre del proveedor no es valido"));
		messages.put(MessageCode.M00034.getIdentifer(), new Message(MessageCode.M00034,
				"El nombre del proveedor no puede ser vacio"));
		messages.put(MessageCode.M00035.getIdentifer(), new Message(MessageCode.M00035,
				"El nombre del proveedor no puede ser nulo"));
		messages.put(MessageCode.M00036.getIdentifer(), new Message(MessageCode.M00036,
				"La longitud del nombre del proveedor no es valida"));
		
		//Suppliers - Interactor and controller
		
		
		messages.put(MessageCode.M00037.getIdentifer(), new Message(MessageCode.M00037,
				"Se ha presentado un error intentando registrar el proveedor"));
		messages.put(MessageCode.M00038.getIdentifer(), new Message(MessageCode.M00038,
				"Se ha presentado un error inesperado intentando registrar el proveedor"));
		messages.put(MessageCode.M00039.getIdentifer(), new Message(MessageCode.M00039,
				"Se ha presentado un problema tratando de consultar los proveedores"));
		
		messages.put(MessageCode.M00040.getIdentifer(), new Message(MessageCode.M00040,
				"Proveedor creado exitosamente"));
		messages.put(MessageCode.M00041.getIdentifer(), new Message(MessageCode.M00041,
				"Proveedores Consultados exitosamente"));
		
		// Customers - Exceptions
		
		messages.put(MessageCode.M00042.getIdentifer(), new Message(MessageCode.M00042,
				"El email del cliente ya se encuentra registrado"));
		messages.put(MessageCode.M00043.getIdentifer(), new Message(MessageCode.M00043,
				"El formato del email del cliente no es valido"));
		messages.put(MessageCode.M00044.getIdentifer(), new Message(MessageCode.M00044,
				"El id del cliente ya existe"));
		messages.put(MessageCode.M00045.getIdentifer(), new Message(MessageCode.M00045,
				"El id no puede ser nulo"));
		messages.put(MessageCode.M00046.getIdentifer(), new Message(MessageCode.M00046,
				"El id del cliente ya existe."));
		messages.put(MessageCode.M00047.getIdentifer(), new Message(MessageCode.M00047,
				"El tamaño para el número de identificación del cliente no es valido"));
		messages.put(MessageCode.M00048.getIdentifer(), new Message(MessageCode.M00048,
				"El formato del apellido del cliente no es valido"));
		messages.put(MessageCode.M00049.getIdentifer(), new Message(MessageCode.M00049,
				"El apellido del cliente no puede ser vacio"));
		messages.put(MessageCode.M00050.getIdentifer(), new Message(MessageCode.M00050,
				"El apellido del cliente no puede ser nulo"));
		messages.put(MessageCode.M00051.getIdentifer(), new Message(MessageCode.M00051,
				"El tamaño del apellido no es valido"));
		messages.put(MessageCode.M00052.getIdentifer(), new Message(MessageCode.M00052,
				"El formato del nombre del cliente no es valido"));
		messages.put(MessageCode.M00053.getIdentifer(), new Message(MessageCode.M00053,
				"El nombre del cliente no puede ser vacio"));
		messages.put(MessageCode.M00054.getIdentifer(), new Message(MessageCode.M00054,
				"El nombre del cliente no puede ser nulo"));
		messages.put(MessageCode.M00055.getIdentifer(), new Message(MessageCode.M00055,
				"El tamaño del nombre no es valido"));
		
		// Customers - Interactor and controller
		
		messages.put(MessageCode.M00056.getIdentifer(), new Message(MessageCode.M00056,
				"Se ha presentado un problema registrando el cliente"));
		messages.put(MessageCode.M00057.getIdentifer(), new Message(MessageCode.M00057,
				"Se ha presentado un problema INESPERADO registrando el cliente"));
		messages.put(MessageCode.M00058.getIdentifer(), new Message(MessageCode.M00058,
				"Se ha presentado un problema tratando de consultar los clientes"));
		
		messages.put(MessageCode.M00059.getIdentifer(), new Message(MessageCode.M00059,
				"Cliente creado exitosamente"));
		messages.put(MessageCode.M00060.getIdentifer(), new Message(MessageCode.M00060,
				"Clientes Consultados exitosamente"));

		// Product Type - Exceptions

		messages.put(MessageCode.M00061.getIdentifer(), new Message(MessageCode.M00061,
				"El id del tipo del producto ya existe"));
		messages.put(MessageCode.M00062.getIdentifer(), new Message(MessageCode.M00062,
				"El formato del nombre del tipo de producto no es valido"));
		messages.put(MessageCode.M00063.getIdentifer(), new Message(MessageCode.M00063,
				"El nombre del tipo de producto no puede estar vacio"));
		messages.put(MessageCode.M00064.getIdentifer(), new Message(MessageCode.M00064,
				"El nombre del tipo de producto no puede ser nulo"));
		messages.put(MessageCode.M00065.getIdentifer(), new Message(MessageCode.M00065,
				"El tamaño del nombre del tipo de producto no es válido"));
		messages.put(MessageCode.M00066.getIdentifer(), new Message(MessageCode.M00066,
				"El id del tipo del producto no puede ser el valor por defecto"));
		messages.put(MessageCode.M00067.getIdentifer(), new Message(MessageCode.M00067,
				"El id del tipo del producto no puede ser nulo"));
		messages.put(MessageCode.M00068.getIdentifer(), new Message(MessageCode.M00068,
				"El id del tipo de producto no existe"));
		
		// Product Type - Interactor and controller
		
		messages.put(MessageCode.M00069.getIdentifer(), new Message(MessageCode.M00069,
				"Se ha presentado un problema registrando el tipo de producto"));
		messages.put(MessageCode.M00070.getIdentifer(), new Message(MessageCode.M00070,
				"Se ha presentado un problema INESPERADO registrando el tipo de producto"));
		messages.put(MessageCode.M00071.getIdentifer(), new Message(MessageCode.M00071,
				"Se ha presentado un problema consultando el tipo de producto"));
		
		messages.put(MessageCode.M00072.getIdentifer(), new Message(MessageCode.M00072,
				"Tipo de Producto registrado correctamente"));
		messages.put(MessageCode.M00073.getIdentifer(), new Message(MessageCode.M00073,
				"Tipo de producto consultado correctamente"));
		
		// Product - Exceptions
		
		messages.put(MessageCode.M00074.getIdentifer(), new Message(MessageCode.M00074,
				"El id del producto ya existe"));
		messages.put(MessageCode.M00075.getIdentifer(), new Message(MessageCode.M00075,
				"El id del producto es nulo"));
		messages.put(MessageCode.M00076.getIdentifer(), new Message(MessageCode.M00076,
				"El formato del nombre del producto no es valido"));
		messages.put(MessageCode.M00077.getIdentifer(), new Message(MessageCode.M00077,
				"El nombre del producto no puede estar vacio"));
		messages.put(MessageCode.M00078.getIdentifer(), new Message(MessageCode.M00078,
				"El id del producto ya existe"));
		messages.put(MessageCode.M00079.getIdentifer(), new Message(MessageCode.M00079,
				"El tamaño del nombre del producto no es válido"));
		
		// Product - Interactor and controller
		
		messages.put(MessageCode.M00080.getIdentifer(), new Message(MessageCode.M00080,
				"Se ha presentado un problema registrando el producto"));
		messages.put(MessageCode.M00081.getIdentifer(), new Message(MessageCode.M00081,
				"Se ha presentado un problema INESPERADO registrando el producto"));
		messages.put(MessageCode.M00082.getIdentifer(), new Message(MessageCode.M00082,
				"Se ha presentado un problema consultando el producto"));
		
		messages.put(MessageCode.M00083.getIdentifer(), new Message(MessageCode.M00083,
				"Producto registrado correctamente"));
		messages.put(MessageCode.M00084.getIdentifer(), new Message(MessageCode.M00084,
				"Productos consultados correctamente"));
		
		// User Type - Exceptions
		
		messages.put(MessageCode.M00085.getIdentifer(), new Message(MessageCode.M00085,
				"El tipo de usuario no existe."));
		messages.put(MessageCode.M00086.getIdentifer(), new Message(MessageCode.M00086,
				"El id del tipo de usuario no puede ser el valor por defecto"));
		messages.put(MessageCode.M00087.getIdentifer(), new Message(MessageCode.M00087,
				"El id del tipo de usuario no puede ser nulo."));
		
		// Product Update - Exception 
		
		messages.put(MessageCode.M00088.getIdentifer(), new Message(MessageCode.M00088,
				"El producto no existe"));
		
		// Product Update - Interactor and controller
		
		messages.put(MessageCode.M00089.getIdentifer(), new Message(MessageCode.M00089,
				"Se ha presentado un problema modificando el producto"));
		messages.put(MessageCode.M00090.getIdentifer(), new Message(MessageCode.M00090,
				"Se ha presentado un problema INESPERADO modificando el producto"));
		
		messages.put(MessageCode.M00091.getIdentifer(), new Message(MessageCode.M00091,
				"Producto modificado existosamente "));
		
		// Product Delete - Interactor and controller
		
		messages.put(MessageCode.M00092.getIdentifer(), new Message(MessageCode.M00092,
				"Se ha presentado un problema tratando de eliminar la informacion del Producto"));
		messages.put(MessageCode.M00093.getIdentifer(), new Message(MessageCode.M00093,
				"Producto eliminado existosamente"));
	
		
	}

	@Override
	public String getMessageContent(MessageCode codigo, String... parametros) {
		return obtainMessage(codigo, parametros).getContent();
	}

	@Override
	public Message obtainMessage(MessageCode codigo, String... parametros) {
		if (ObjectHelper.isNull(codigo)) {
			var userMessage = getMessageContent(MessageCode.M00002);
			var technicalMessage = getMessageContent(MessageCode.M00001);
			throw CroscutingInventorySystemException.create(userMessage, technicalMessage);
		}

		if (!codigo.isBase()) {
			var userMessage = getMessageContent(MessageCode.M00002);
			var technicalMessage = getMessageContent(MessageCode.M00004, codigo.getIdentifer());
			throw CroscutingInventorySystemException.create(userMessage, technicalMessage);
		}

		if (!messages.containsKey(codigo.getIdentifer())) {
			var userMessage = getMessageContent(MessageCode.M00002);
			var technicalMessage = getMessageContent(MessageCode.M00003, codigo.getIdentifer());
			throw CroscutingInventorySystemException.create(userMessage, technicalMessage);
		}
		return messages.get(codigo.getIdentifer());
	}

}

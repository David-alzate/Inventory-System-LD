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

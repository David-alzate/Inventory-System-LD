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
		// UserEmailFormatIsNotValidException
		messages.put(MessageCode.M00005.getIdentifer(), new Message(MessageCode.M00005,
				"El formato del email del usuario no es valido"));

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

package co.inventory.system.ld.crosscutting.messagecatalog;

import co.inventory.system.ld.crosscutting.exceptions.CroscutingInventorySystemException;
import co.inventory.system.ld.crosscutting.helpers.ObjectHelper;
import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;
import co.inventory.system.ld.crosscutting.messagecatalog.impl.MessageCatalogBase;

public class MessageCatalogStrategy {
	
	private static final MessageCatalog base = new MessageCatalogBase();
	
	static {
		inicializar();
	}

	private MessageCatalogStrategy() {
		super();
	}

	public static void inicializar() {
		base.initialize();

	}

	private static final MessageCatalog getStrategy(final boolean isBase) {
		return base;
	}

	private static final co.inventory.system.ld.crosscutting.messagecatalog.data.Message getMessage(final MessageCode code, final String... parameters) {
		if (ObjectHelper.isNull(code)) {
			var mensajeUsuario = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00002);
			var mensajeTecnico = MessageCatalogStrategy.getContenidoMensaje(MessageCode.M00001);
			throw new CroscutingInventorySystemException(mensajeUsuario, mensajeTecnico, new Exception());
		}

		return getStrategy(code.isBase()).obtainMessage(code, parameters);

	}

	public static final String getContenidoMensaje(final MessageCode codigo, final String... parametros) {
		return getMessage(codigo, parametros).getContent();

	}

}

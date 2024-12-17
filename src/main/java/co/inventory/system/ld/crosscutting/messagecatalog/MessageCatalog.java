package co.inventory.system.ld.crosscutting.messagecatalog;

import co.inventory.system.ld.crosscutting.messagecatalog.data.MessageCode;
import co.inventory.system.ld.crosscutting.messagecatalog.data.Message;

public interface MessageCatalog {
	
	void initialize();
	
	String getMessageContent(final MessageCode codigo, String ...parametros);
	Message obtainMessage(final MessageCode codigo,String ...parametros);

}

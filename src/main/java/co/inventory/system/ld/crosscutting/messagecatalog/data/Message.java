package co.inventory.system.ld.crosscutting.messagecatalog.data;

public final class Message {

	private MessageCode code;
	private String content;

	public Message(final MessageCode code, final String content) {
		setCode(code);
		setContent(content);
	}

	public final boolean esBase() {
		return getCode().isBase();
	}

	private final MessageCode getCode() {
		return code;
	}

	public final String getContent() {
		return content;
	}

	public final MessageType getTipo() {
		return getCode().getType();
	}

	public final CategoryMessage getCategoria() {
		return getCode().getCategory();
	}

	private final void setCode(final MessageCode code) {
		this.code = code;
	}

	private final void setContent(final String content) {
		this.content = content;
	}

	public final String getIdentifer() {
		return getCode().getIdentifer();
	}

}

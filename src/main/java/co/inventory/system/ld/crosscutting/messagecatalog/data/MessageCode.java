package co.inventory.system.ld.crosscutting.messagecatalog.data;

import static co.inventory.system.ld.crosscutting.helpers.TextHelper.UNDERLINE;
import static co.inventory.system.ld.crosscutting.helpers.TextHelper.concatenate;

public enum MessageCode {

	M00001(MessageType.TECHNICAL, CategoryMessage.ERROR, "00001", true),
	M00002(MessageType.USER, CategoryMessage.ERROR, "00002", true),
	M00003(MessageType.TECHNICAL, CategoryMessage.ERROR, "00003", true),
	M00004(MessageType.TECHNICAL, CategoryMessage.ERROR, "00004", true),
	M00005(MessageType.USER, CategoryMessage.ERROR, "00005", true);

	private MessageType type;
	private CategoryMessage category;
	private String code;
	private boolean base;

	private MessageCode(MessageType type, CategoryMessage category, String code, boolean base) {
		setType(type);
		setCategory(category);
		setCode(code);
		setBase(base);
	}

	public final MessageType getType() {
		return type;
	}

	public final CategoryMessage getCategory() {
		return category;
	}

	public final String getCode() {
		return code;
	}

	public final boolean isBase() {
		return base;
	}

	private final void setType(MessageType type) {
		this.type = type;
	}

	private final void setCategory(CategoryMessage category) {
		this.category = category;
	}

	private final void setCode(String code) {
		this.code = code;
	}

	private final void setBase(boolean base) {
		this.base = base;
	}

	public String getIdentifer() {
		return concatenate(getType().name(), UNDERLINE, getCategory().name(), UNDERLINE, getCode());
	}

}

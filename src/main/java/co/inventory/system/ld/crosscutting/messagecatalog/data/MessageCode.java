package co.inventory.system.ld.crosscutting.messagecatalog.data;

import static co.inventory.system.ld.crosscutting.helpers.TextHelper.UNDERLINE;
import static co.inventory.system.ld.crosscutting.helpers.TextHelper.concatenate;

public enum MessageCode {

	M00001(MessageType.TECHNICAL, CategoryMessage.ERROR, "00001", true),
	M00002(MessageType.USER, CategoryMessage.ERROR, "00002", true),
	M00003(MessageType.TECHNICAL, CategoryMessage.ERROR, "00003", true),
	M00004(MessageType.TECHNICAL, CategoryMessage.ERROR, "00004", true),

	// Users - Exceptions

	M00005(MessageType.USER, CategoryMessage.ERROR, "00005", true),
	M00006(MessageType.USER, CategoryMessage.ERROR, "00006", true),
	M00007(MessageType.USER, CategoryMessage.ERROR, "00007", true),
	M00008(MessageType.USER, CategoryMessage.ERROR, "00008", true),
	M00009(MessageType.USER, CategoryMessage.ERROR, "00009", true),
	M00010(MessageType.USER, CategoryMessage.ERROR, "00010", true),
	M00011(MessageType.USER, CategoryMessage.ERROR, "00011", true),
	M00012(MessageType.USER, CategoryMessage.ERROR, "00012", true),
	M00013(MessageType.USER, CategoryMessage.ERROR, "00013", true),
	M00014(MessageType.USER, CategoryMessage.ERROR, "00014", true),
	M00015(MessageType.USER, CategoryMessage.ERROR, "00015", true),
	M00016(MessageType.USER, CategoryMessage.ERROR, "00016", true),
	M00017(MessageType.USER, CategoryMessage.ERROR, "00017", true),
	M00018(MessageType.USER, CategoryMessage.ERROR, "00018", true),

	// Users - Interactor and controller

	M00019(MessageType.USER, CategoryMessage.ERROR, "00019", true),
	M00020(MessageType.USER, CategoryMessage.ERROR, "00020", true),
	M00021(MessageType.USER, CategoryMessage.ERROR, "00021", true),

	M00022(MessageType.USER, CategoryMessage.SUCCESS, "00022", true),
	M00023(MessageType.USER, CategoryMessage.SUCCESS, "00023", true),

	// Commons - Exceptions

	M00024(MessageType.USER, CategoryMessage.ERROR, "00024", true),
	M00025(MessageType.USER, CategoryMessage.ERROR, "00025", true),
	M00026(MessageType.USER, CategoryMessage.ERROR, "00026", true),

	M00027(MessageType.USER, CategoryMessage.ERROR, "00027", true),
	M00028(MessageType.USER, CategoryMessage.ERROR, "00028", true),
	M00029(MessageType.USER, CategoryMessage.ERROR, "00029", true),

	//Suppliers - Exceptions

	M00030(MessageType.USER, CategoryMessage.ERROR, "00030", true),
	M00031(MessageType.USER, CategoryMessage.ERROR, "00031", true),
	M00032(MessageType.USER, CategoryMessage.ERROR, "00032", true),
	M00033(MessageType.USER, CategoryMessage.ERROR, "00033", true),
	M00034(MessageType.USER, CategoryMessage.ERROR, "00034", true),
	M00035(MessageType.USER, CategoryMessage.ERROR, "00035", true),
	M00036(MessageType.USER, CategoryMessage.ERROR, "00036", true);
	
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

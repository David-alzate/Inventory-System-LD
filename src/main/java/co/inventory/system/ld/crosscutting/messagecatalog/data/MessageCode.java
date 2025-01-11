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

	// Suppliers - Exceptions

	M00030(MessageType.USER, CategoryMessage.ERROR, "00030", true),
	M00031(MessageType.USER, CategoryMessage.ERROR, "00031", true),
	M00032(MessageType.USER, CategoryMessage.ERROR, "00032", true),
	M00033(MessageType.USER, CategoryMessage.ERROR, "00033", true),
	M00034(MessageType.USER, CategoryMessage.ERROR, "00034", true),
	M00035(MessageType.USER, CategoryMessage.ERROR, "00035", true),
	M00036(MessageType.USER, CategoryMessage.ERROR, "00036", true),

	// Suppliers - Interactor and controller

	M00037(MessageType.USER, CategoryMessage.ERROR, "00037", true),
	M00038(MessageType.USER, CategoryMessage.ERROR, "00038", true),
	M00039(MessageType.USER, CategoryMessage.ERROR, "00039", true),

	M00040(MessageType.USER, CategoryMessage.SUCCESS, "00040", true),
	M00041(MessageType.USER, CategoryMessage.SUCCESS, "00041", true),

	// Customers - Exceptions

	M00042(MessageType.USER, CategoryMessage.ERROR, "00042", true),
	M00043(MessageType.USER, CategoryMessage.ERROR, "00043", true),
	M00044(MessageType.USER, CategoryMessage.ERROR, "00044", true),
	M00045(MessageType.USER, CategoryMessage.ERROR, "00045", true),
	M00046(MessageType.USER, CategoryMessage.ERROR, "00046", true),
	M00047(MessageType.USER, CategoryMessage.ERROR, "00047", true),
	M00048(MessageType.USER, CategoryMessage.ERROR, "00048", true),
	M00049(MessageType.USER, CategoryMessage.ERROR, "00049", true),
	M00050(MessageType.USER, CategoryMessage.ERROR, "00050", true),
	M00051(MessageType.USER, CategoryMessage.ERROR, "00051", true),
	M00052(MessageType.USER, CategoryMessage.ERROR, "00052", true),
	M00053(MessageType.USER, CategoryMessage.ERROR, "00053", true),
	M00054(MessageType.USER, CategoryMessage.ERROR, "00054", true),
	M00055(MessageType.USER, CategoryMessage.ERROR, "00055", true),

	// Customers - Interactor and controller

	M00056(MessageType.USER, CategoryMessage.ERROR, "00056", true),
	M00057(MessageType.USER, CategoryMessage.ERROR, "00057", true),
	M00058(MessageType.USER, CategoryMessage.ERROR, "00058", true),

	M00059(MessageType.USER, CategoryMessage.SUCCESS, "00059", true),
	M00060(MessageType.USER, CategoryMessage.SUCCESS, "00060", true),

	// Product Type - Exceptions

	M00061(MessageType.USER, CategoryMessage.ERROR, "00061", true),
	M00062(MessageType.USER, CategoryMessage.ERROR, "00062", true),
	M00063(MessageType.USER, CategoryMessage.ERROR, "00063", true),
	M00064(MessageType.USER, CategoryMessage.ERROR, "00064", true),
	M00065(MessageType.USER, CategoryMessage.ERROR, "00065", true),
	M00066(MessageType.USER, CategoryMessage.ERROR, "00066", true),
	M00067(MessageType.USER, CategoryMessage.ERROR, "00067", true),
	M00068(MessageType.USER, CategoryMessage.ERROR, "00068", true),

	// Product Type - Interactor and controller

	M00069(MessageType.USER, CategoryMessage.ERROR, "00069", true),
	M00070(MessageType.USER, CategoryMessage.ERROR, "00070", true),
	M00071(MessageType.USER, CategoryMessage.ERROR, "00071", true),

	M00072(MessageType.USER, CategoryMessage.SUCCESS, "00072", true),
	M00073(MessageType.USER, CategoryMessage.SUCCESS, "00073", true),

	// Product - Exceptions

	M00074(MessageType.USER, CategoryMessage.ERROR, "00074", true),
	M00075(MessageType.USER, CategoryMessage.ERROR, "00075", true),
	M00076(MessageType.USER, CategoryMessage.ERROR, "00076", true),
	M00077(MessageType.USER, CategoryMessage.ERROR, "00077", true),
	M00078(MessageType.USER, CategoryMessage.ERROR, "00078", true),
	M00079(MessageType.USER, CategoryMessage.ERROR, "00079", true),

	// Product - Interactor and controller

	M00080(MessageType.USER, CategoryMessage.ERROR, "00080", true),
	M00081(MessageType.USER, CategoryMessage.ERROR, "00081", true),
	M00082(MessageType.USER, CategoryMessage.ERROR, "00082", true),

	M00083(MessageType.USER, CategoryMessage.SUCCESS, "00083", true),
	M00084(MessageType.USER, CategoryMessage.SUCCESS, "00084", true),

	// User Type - Exceptions

	M00085(MessageType.USER, CategoryMessage.ERROR, "00085", true),
	M00086(MessageType.USER, CategoryMessage.ERROR, "00086", true),
	M00087(MessageType.USER, CategoryMessage.ERROR, "00087", true),

	// Product Update - Exception
	M00088(MessageType.USER, CategoryMessage.ERROR, "00088", true),

	// Product Update - Interactor and controller

	M00089(MessageType.USER, CategoryMessage.ERROR, "00089", true),
	M00090(MessageType.USER, CategoryMessage.ERROR, "00090", true),

	M00091(MessageType.USER, CategoryMessage.SUCCESS, "00091", true),

	// Product Delete - Interactor and controller

	M00092(MessageType.USER, CategoryMessage.ERROR, "00092", true),
	M00093(MessageType.USER, CategoryMessage.SUCCESS, "00093", true),

	// Product Type Update - Interactor and controller

	M00094(MessageType.USER, CategoryMessage.ERROR, "00094", true),
	M00095(MessageType.USER, CategoryMessage.ERROR, "00095", true),

	M00096(MessageType.USER, CategoryMessage.SUCCESS, "00096", true),

	// Product Type Delete - Interactor and controller

	M00097(MessageType.USER, CategoryMessage.ERROR, "00097", true),
	M00098(MessageType.USER, CategoryMessage.SUCCESS, "00098", true),

	// Supplier Update - Interactor and controller

	M00099(MessageType.USER, CategoryMessage.ERROR, "00099", true),
	M00100(MessageType.USER, CategoryMessage.ERROR, "00100", true),

	M00101(MessageType.USER, CategoryMessage.SUCCESS, "00101", true),

	// Supplier Delete - Interactor and controller

	M00102(MessageType.USER, CategoryMessage.ERROR, "00102", true),
	M00103(MessageType.USER, CategoryMessage.SUCCESS, "00103", true);

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

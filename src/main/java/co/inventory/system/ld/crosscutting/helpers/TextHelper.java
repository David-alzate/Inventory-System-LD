package co.inventory.system.ld.crosscutting.helpers;

import java.util.regex.Pattern;

public class TextHelper {

	public static final String EMPTY = "";
	public static final String UNDERLINE = "_";
	private static final Pattern EMAIL_PATTERN = Pattern.compile("^[\\w.-]+@[\\w.-]+\\.[a-zA-Z]{2,}$");

	private TextHelper() {

	}

	public static boolean isNull(final String string) {
		return ObjectHelper.isNull(string);
	}

	public static String getDefault(final String string, final String defaultValue) {
		return ObjectHelper.getDefault(string, defaultValue);
	}

	public static String getDefault(final String string) {
		return getDefault(string, EMPTY);
	}

	public static boolean isEmpty(final String string) {
		return EMPTY.equals(getDefault(string));
	}

	public static boolean isEmptyApplyingTrim(final String string) {
		return isEmpty(applyTrim(string));
	}

	public static String applyTrim(final String string) {
		return getDefault(string).trim();
	}

	public static String concatenate(final String... strings) {
		final var sb = new StringBuilder(EMPTY);

		if (!ObjectHelper.isNull(strings)) {
			for (final var string : strings) {
				sb.append(applyTrim(string));
			}
		}
		return sb.toString();
	}

	public static String replaceParameter(String message, String... parameters) {
		String replacedMessage = message;
		for (int i = 0; i < parameters.length; i++) {
			String marker = "${" + (i + 1) + "}";
			replacedMessage = replacedMessage.replace(marker, parameters[i]);
		}
		return replacedMessage;
	}
	
    public static boolean emailValid(final String email) {
        return !isEmpty(email) && EMAIL_PATTERN.matcher(email).matches();
    }

}

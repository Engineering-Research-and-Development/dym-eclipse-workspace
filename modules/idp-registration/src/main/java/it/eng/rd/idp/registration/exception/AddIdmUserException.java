package it.eng.rd.idp.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class AddIdmUserException extends PortalException {
	public AddIdmUserException() {
		super();
	}

	public AddIdmUserException(String msg) {
		super(msg);
	}

	public AddIdmUserException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public AddIdmUserException(Throwable cause) {
		super(cause);
	}
}

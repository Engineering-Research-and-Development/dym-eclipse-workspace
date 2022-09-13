package it.eng.rd.idp.registration.exception;

import com.liferay.portal.kernel.exception.PortalException;

public class IdmException extends PortalException {
	public IdmException() {
		super();
	}

	public IdmException(String msg) {
		super(msg);
	}

	public IdmException(String msg, Throwable cause) {
		super(msg, cause);
	}

	public IdmException(Throwable cause) {
		super(cause);
	}
}

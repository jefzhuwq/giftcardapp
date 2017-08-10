package com.mediabox.giftcardapp.exceptions;

import org.springframework.http.HttpStatus;
import org.springframework.web.bind.annotation.ResponseStatus;

@ResponseStatus(value= HttpStatus.FORBIDDEN, reason="No permission")
public class NoPermissionException extends RuntimeException {

}

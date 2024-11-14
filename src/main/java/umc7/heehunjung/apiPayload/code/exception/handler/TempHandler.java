package umc7.heehunjung.apiPayload.code.exception.handler;

import umc7.heehunjung.apiPayload.code.BaseErrorCode;
import umc7.heehunjung.apiPayload.code.exception.GeneralException;

public class TempHandler extends GeneralException {

    public TempHandler(BaseErrorCode errorCode) {
        super(errorCode);
    }
}
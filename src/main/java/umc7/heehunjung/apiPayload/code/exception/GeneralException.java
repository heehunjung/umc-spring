package umc7.heehunjung.apiPayload.code.exception;

import lombok.AllArgsConstructor;
import lombok.Getter;
import umc7.heehunjung.apiPayload.code.BaseErrorCode;
import umc7.heehunjung.apiPayload.code.ErrorReasonDTO;

@Getter
@AllArgsConstructor
public class GeneralException extends RuntimeException {

    private BaseErrorCode code;

    public ErrorReasonDTO getErrorReason() {
        return this.code.getReason();
    }

    public ErrorReasonDTO getErrorReasonHttpStatus(){
        return this.code.getReasonHttpStatus();
    }
}
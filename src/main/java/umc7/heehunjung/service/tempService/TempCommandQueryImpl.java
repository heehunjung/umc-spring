package umc7.heehunjung.service.tempService;

import umc7.heehunjung.apiPayload.code.exception.handler.TempHandler;
import umc7.heehunjung.apiPayload.code.status.ErrorStatus;

public class TempCommandQueryImpl implements TempQueryService {
    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}

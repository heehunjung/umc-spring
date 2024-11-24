package umc7.heehunjung.service.tempService;

import org.springframework.stereotype.Service;
import umc7.heehunjung.apiPayload.code.exception.handler.TempHandler;
import umc7.heehunjung.apiPayload.code.status.ErrorStatus;

@Service
public class TempCommandQueryImpl implements TempQueryService {
    @Override
    public void CheckFlag(Integer flag) {
        if (flag == 1)
            throw new TempHandler(ErrorStatus.TEMP_EXCEPTION);
    }
}

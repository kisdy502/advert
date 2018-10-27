package com.sdt.advert;

import com.sdt.advert.exception.TipException;
import org.slf4j.Logger;

public class ExceptionHelper {
    /**
     * 统一处理异常
     * @param logger
     * @param msg
     * @param e
     * @return
     */
    public static RestResponse handlerException(Logger logger, String msg, Exception e) {
        if (e instanceof TipException) {
            msg = e.getMessage();
        } else {
            logger.error(msg, e);
        }
        return RestResponse.fail(msg);
    }
}

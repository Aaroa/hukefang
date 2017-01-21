package com.yunwei.easyDear.function.account.data.soure;

import com.yunwei.easyDear.function.account.data.UserInfoEntity;
import com.yunwei.easyDear.base.BaseDataSourse;

/**
 * @author hezhiWu
 * @version V1.0
 * @Package com.yunwei.frame.function.account.data.soure
 * @Description:
 * @date 2016/11/29 15:02
 */

public interface LoginDataSoure extends BaseDataSourse {

    interface LoginCallBack {

        void onLoginSuccess(UserInfoEntity entity);

        void onLoginFailure(String error);

    }

    interface RigestCallBack {
        void onRigestSuccess(UserInfoEntity entity);

        void onRigestFailure(String error);

        String getMobile();

        String getPassword();

        String getMobileKey();
    }

    interface ValidateCallBack {
        void onValidateSuccess(String code);

        void onValidateFailure(String error);

        String getSendMobile();
    }

    void login(String account, String password, LoginCallBack callBack);

    void rigest(RigestCallBack callBack);

    void sendValidateCode(ValidateCallBack callBack);
}

package com.jellysoft.vegi.interfaces;

import com.jellysoft.vegi.models.UserRoot;

public interface LoginListnraer {
    void onLoginSuccess(UserRoot.User user);

    void onDismiss();

    void onFailure();
}

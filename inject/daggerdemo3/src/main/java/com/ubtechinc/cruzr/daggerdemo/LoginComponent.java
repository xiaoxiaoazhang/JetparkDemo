package com.ubtechinc.cruzr.daggerdemo;

import dagger.Component;
import dagger.Subcomponent;
@ActivityScope
// @Subcomponent annotation informs Dagger this interface is a Dagger Subcomponent
@Subcomponent
public interface LoginComponent {
    // Factory that is used to create instances of this subcomponent
    @Subcomponent.Factory
    interface Factory {
        LoginComponent create();
    }

    void inject(LoginActivity loginActivity);
    void inject(LoginUsernameFragment loginUsernameFragment);
    void inject(LoginPasswordFragment loginPasswordFragment);
}

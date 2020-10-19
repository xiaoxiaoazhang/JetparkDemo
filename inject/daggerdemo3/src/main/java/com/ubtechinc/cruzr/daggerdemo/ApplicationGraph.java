package com.ubtechinc.cruzr.daggerdemo;

import javax.inject.Singleton;

import dagger.Component;
// Scope annotations on a @Component interface informs Dagger that classes annotated
// with this annotation (i.e. @Singleton) are scoped to the graph and the same
// instance of that type is provided every time the type is requested.
@Singleton
//或者
//@MyCustomScope
@Component // @Component makes Dagger create a graph of dependencies
public interface ApplicationGraph {
    // The return type  of functions inside the component interface is
    // what can be consumed from the graph
    UserRepository userRepository();
}

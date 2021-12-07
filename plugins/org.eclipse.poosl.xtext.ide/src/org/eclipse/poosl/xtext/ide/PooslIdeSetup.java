/*
 * generated by Xtext 2.23.0
 */
package org.eclipse.poosl.xtext.ide;

import org.eclipse.poosl.xtext.PooslRuntimeModule;
import org.eclipse.poosl.xtext.PooslStandaloneSetup;
import org.eclipse.xtext.util.Modules2;

import com.google.inject.Guice;
import com.google.inject.Injector;

/**
 * Initialization support for running Xtext languages as language servers.
 * 
 * @author <a href="mailto:arjan.mooij@tno.nl">Arjan Mooij</a>
 */
public class PooslIdeSetup extends PooslStandaloneSetup {

    @Override
    public Injector createInjector() {
        return Guice.createInjector(Modules2.mixin(new PooslRuntimeModule(), new PooslIdeModule()));
    }

}
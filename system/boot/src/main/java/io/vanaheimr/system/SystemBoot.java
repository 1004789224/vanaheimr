package io.vanaheimr.system;

import io.micronaut.runtime.Micronaut;

public class SystemBoot {
    public static void main(String[] args) {
        Micronaut.run(SystemBoot.class)
                .start();
    }
}

package io.vanaheimr.system;

import io.micronaut.runtime.Micronaut;

public class SystemBoot {
    public static void main(String[] args) {
        Micronaut.build(args)
                .packages("io.vanaheimr")
                .start();
    }
}

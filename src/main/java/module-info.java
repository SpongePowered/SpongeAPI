open module org.spongepowered.api {
    requires transitive java.desktop;
    requires transitive java.sql;

    requires transitive org.apache.logging.log4j;
    requires transitive com.google.common; // guava
    requires transitive com.google.gson;

    requires transitive net.kyori.adventure;
    requires transitive net.kyori.adventure.text.serializer.gson;
    requires transitive net.kyori.adventure.text.serializer.legacy;
    requires transitive net.kyori.adventure.text.serializer.plain;
    requires transitive net.kyori.adventure.text.minimessage;

    requires transitive com.google.guice;
    requires transitive com.github.benmanes.caffeine;
    requires transitive com.github.benmanes.caffeine.guava;

    requires transitive org.spongepowered.plugin.spi;
    requires transitive org.spongepowered.plugin.metadata;

    requires transitive org.spongepowered.configurate;
    requires transitive org.spongepowered.configurate.hocon;
    requires transitive org.spongepowered.configurate.gson;
    requires transitive org.spongepowered.configurate.yaml;
    requires transitive org.spongepowered.configurate.extra.guice;

    requires static transitive com.google.errorprone.annotations;
    requires static transitive org.checkerframework.checker.qual;
    requires static transitive org.jetbrains.annotations; // via adventure (unneeded once Adventure gets real module descriptors)

    requires transitive org.spongepowered.math;
    requires transitive io.leangen.geantyref;

    // AP
    requires transitive java.compiler;

    // provides javax.annotation.processing.Processor with org.spongepowered.plugin.processor.ListenerProcessor; // TODO
}

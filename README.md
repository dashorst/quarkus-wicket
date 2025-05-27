# Quarkus Wicket

[![Version](https://img.shields.io/maven-central/v/io.quarkiverse.wicket/quarkus-wicket?logo=apache-maven&style=flat-square)](https://central.sonatype.com/artifact/io.quarkiverse.wicket/quarkus-wicket-parent)

## Welcome to Quarkus Wicket!

This is the Quarkus extension to build Quarkus web applications using [Apache Wicket](https://wicket.apache.org).

## Features

- Should be compatible with ArC CDI injection (aka CDI lite)

- Injection of your CDI services works in Components, Behaviors and sessions

- Configures Wicket using the profiles of Quarkus (e.g. dev -> development configuration, prod -> deployment configuration)

## Caveats

- Your application should extend `QuarkusWicketApplication` to work (the codestart generates this for you)

- Your application should be a `@Singleton` for proper injection into the WicketFilter to work

- Apache Wicket doesn't work well (yet) with native GraalVM so this extension doesn't support native applications

- Does not support build time processing (all CDI references are resolved at runtime)

- Requires all CDI beans to be injectable (see build time processing) at runtime, this causes overhead

- No attempts have been made to integrate Hibernate/Panache/... into this project, so expect difficulties

- There are no configuration options available other than through coding them yourself in your application


## Documentation

The documentation for this extension can be found at the [Quarkiverse Wicket](https://docs.quarkiverse.io/quarkus-wicket/dev/index.html) website.


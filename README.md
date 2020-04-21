# compile-switches-maven-plugin
Maven plugin to support some kind of conditional compilation in Java Maven projects

Please see [this blog post](https://www.renebergelt.de/blog/2018/03/conditional-compilation-with-java-and-maven/) on how this works and how it can be used in a project.

# How to use
The plugin is available on maven central to be included in your project's pom file:

```xml
<dependency>
  <groupId>de.renebergelt.maven.plugins</groupId>
  <artifactId>compile-switches-maven-plugin</artifactId>
  <version>1.0.0</version>
  <type>maven-plugin</type>
</dependency>
```
